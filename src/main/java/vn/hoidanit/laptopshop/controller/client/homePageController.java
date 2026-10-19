package vn.hoidanit.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;

@Controller
public class homePageController {
  private final ProductService productService;

  public homePageController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/")
  public String getHomePage(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
      @RequestParam(name = "name", defaultValue = "") String name) {
    // danh sach show
    Pageable pageable = PageRequest.of(page - 1, 4);
    // List<String> listStr = Arrays.asList(name.join(",", name));
    Page<Product> products = this.productService.getLikeProducts(pageable, name);
    List<Product> ListProducts = products.getContent();

    // random

    List<Product> randomProducts = new ArrayList<>();

    while (randomProducts.size() < 3) {

      int randomNumber = (int) (Math.random() * 5);
      Product product = this.productService.getProductId(randomNumber);

      if (!randomProducts.contains(product)) {
        if (randomNumber != 0) {
          randomProducts.add(product);
        }
      }

    }
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPage", products.getTotalPages());
    model.addAttribute("randomProducts", randomProducts);
    model.addAttribute("ListProduct", ListProducts);

    return "client/homePage/homePage";
  }

  @RequestMapping(value = "/product", method = { RequestMethod.POST, RequestMethod.GET })
  public String showAllProduct(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
      @RequestParam(name = "name", defaultValue = "") String name) {
    Pageable pageable = PageRequest.of(page - 1, 10);
    String Null = "";
    if (name.equalsIgnoreCase(Null)) {

      Page<Product> products = this.productService.getLikeProducts(pageable, name);
      List<Product> ListProducts = products.getContent();
      model.addAttribute("currentPage", page);
      model.addAttribute("totalPage", products.getTotalPages());

      model.addAttribute("ListProduct", ListProducts);
    } else {
      List<String> listName = Arrays.asList(name.split(","));
      Page<Product> products = this.productService.getAllProducts(pageable, listName);
      List<Product> ListProducts = products.getContent();
      model.addAttribute("currentPage", page);
      model.addAttribute("totalPage", products.getTotalPages());

      model.addAttribute("ListProduct", ListProducts);
    }

    return "client/product/allProduct";
  }

  @RequestMapping(value = "/product/addAllProductToCart/{id}", method = RequestMethod.POST)
  public String addAllProductToCard(HttpServletRequest request, @PathVariable long id,
      @RequestParam("quantities") long getValQuantitys) {
    HttpSession session = request.getSession(false);
    String email = (String) session.getAttribute("email");
    this.productService.hanldAddProductToCart(id, email, session, getValQuantitys);

    return "redirect:/product";
  }

}
