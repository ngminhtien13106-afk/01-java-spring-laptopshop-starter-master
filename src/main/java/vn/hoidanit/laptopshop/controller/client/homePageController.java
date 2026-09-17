package vn.hoidanit.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;

@Controller
public class homePageController {
  private final ProductService productService;

  public homePageController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/")
  public String getHomePage(Model model) {
    // danh sach show
    List<Product> products = this.productService.getAllProducts();
    List<Product> ListProducts = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      ListProducts.add(products.get(i));
    }

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

    model.addAttribute("randomProducts", randomProducts);
    model.addAttribute("ListProduct", ListProducts);

    return "client/homePage/homePage";
  }

  // @RequestMapping("/product")
  // public String getProductDetail() {
  // return "client/product/productDetail";
  // }

}
