package vn.hoidanit.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.service.ProductService;

@Controller
public class itemController {
  private final CartDetailRepository cartDetailRepository;
  private final ProductService productService;

  public itemController(ProductService productService, CartDetailRepository cartDetailRepository) {
    this.productService = productService;
    this.cartDetailRepository = cartDetailRepository;
  }

  @RequestMapping("/product/{productid}")
  public String handleProductDetail(Model model, @PathVariable long productid) {
    Product products = this.productService.getProductId(productid);
    List<Object[]> result = this.productService.countProductByFactory();
    // random
    List<Product> randomProducts = new ArrayList<>();

    while (randomProducts.size() < 3) {
      int randomNumber = (int) (Math.random() * 5);
      Product randomProduct = this.productService.getProductId(randomNumber);
      if (!randomProducts.contains(randomProduct)) {
        if (randomNumber != 0) {
          randomProducts.add(randomProduct);
        }
      }
    }

    model.addAttribute("randomProducts", randomProducts);

    model.addAttribute("factoryCount", result);
    model.addAttribute("product", products);

    return "client/product/productDetail";
  }

  @RequestMapping(value = "/product/addProductToCart/{id}", method = RequestMethod.POST)
  public String addProductToCard(HttpServletRequest request, @PathVariable long id) {
    HttpSession session = request.getSession(false);
    String email = (String) session.getAttribute("email");
    this.productService.hanldAddProductToCart(id, email, session);

    return "redirect:/";
  }

  @RequestMapping(value = "/product/addProductDetailToCart/{id}", method = RequestMethod.POST)
  public String addProductDetailToCard(HttpServletRequest request, @PathVariable long id) {
    HttpSession session = request.getSession(false);
    String email = (String) session.getAttribute("email");
    this.productService.hanldAddProductToCart(id, email, session);

    return "redirect:/product/{id}";
  }

  @RequestMapping("/productToCartDetail")
  public String ShowCartDetails(Model model, HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    String email = (String) session.getAttribute("email");

    List<CartDetail> cartDetails = this.productService.handleCartDetails(email);
    double totalPrice = 0;
    for (CartDetail cd : cartDetails) {
      totalPrice += cd.getPrice() * cd.getQuantity();
    }
    model.addAttribute("cartDetail", cartDetails);
    model.addAttribute("totalPrice", totalPrice);

    return "client/product/cartDetail";
  }

  @RequestMapping(value = "/product/deleteProductToCart/{id}", method = RequestMethod.POST)
  public String deleteProductToCart(@PathVariable long id, HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    this.productService.handleDeleteCart(id, session);
    return "redirect:/productToCartDetail";
  }
}
