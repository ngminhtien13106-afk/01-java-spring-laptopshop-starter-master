package vn.hoidanit.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.Product_;
import vn.hoidanit.laptopshop.domain.DTO.ProductCriteriaDTO;
import vn.hoidanit.laptopshop.service.ProductService;

@Controller
public class homePageController {
  private final ProductService productService;

  public homePageController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/")
  public String getHomePage(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
    // danh sach show
    Pageable pageable = PageRequest.of(page - 1, 4);
    // List<String> listStr = Arrays.asList(name.join(",", name));
    Page<Product> products = this.productService.getAllProducts(pageable);
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

  // @RequestParam(name = "page", defaultValue = "1") int page,
  // @RequestParam(name = "name", defaultValue = "") String name,
  // @RequestParam(name = "factory", required = false) List<String> factory,
  // @RequestParam(name = "priceMin", defaultValue = "0") double priceMin,
  // @RequestParam(name = "priceMax", defaultValue = "0") double priceMax,
  // @RequestParam(name = "price", defaultValue = "") String price,
  // @RequestParam(name = "flexRadioDefault", defaultValue = "normal") String
  // flexRadioDefault,
  // @RequestParam(name = "target", required = false) List<String> target
  @RequestMapping(value = "/product", method = { RequestMethod.POST, RequestMethod.GET })
  public String showAllProduct(Model model, ProductCriteriaDTO productCriteriaDTO,
      HttpServletRequest httpServletRequest) {
    int page = 1;
    if (productCriteriaDTO.getPage() != null && productCriteriaDTO.getPage().isPresent()) {
      page = Integer.parseInt(productCriteriaDTO.getPage().get());
    }

    Pageable pageable = pageable = PageRequest.of(page - 1, 2);
    ;
    if (productCriteriaDTO.getFlexRadioDefault() != null && productCriteriaDTO.getFlexRadioDefault().isPresent()) {
      String sort = productCriteriaDTO.getFlexRadioDefault().get();
      if (sort.equals("tang-dan")) {
        pageable = PageRequest.of(page - 1, 2, Sort.by(Product_.PRICE).ascending());
      } else if (sort.equals("giam-dan")) {
        pageable = PageRequest.of(page - 1, 2, Sort.by(Product_.PRICE).descending());
      }
    }

    String qs = httpServletRequest.getQueryString();

    if (qs != null && !qs.isBlank()) {
      qs = qs.replace("page=" + page, "");
    }

    Page<Product> products = this.productService.searchProducts(pageable, productCriteriaDTO);
    List<Product> ListProducts = products.getContent();
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPage", products.getTotalPages());
    model.addAttribute("qs", qs);
    model.addAttribute("ListProduct", ListProducts);

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
