package vn.hoidanit.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

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
    List<Product> allproducts = this.productService.getAllProducts();
    List<Product> randomProducts = new ArrayList<>();
    Random random = new Random();
    while (randomProducts.size() < 7 && randomProducts.size() < allproducts.size()) {
      Product product = allproducts.get(random.nextInt(allproducts.size()));

      if (!randomProducts.contains(product)) {
        randomProducts.add(product);
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
