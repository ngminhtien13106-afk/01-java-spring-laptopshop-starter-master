package vn.hoidanit.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;

@Controller
public class itemController {
  private final ProductService productService;

  public itemController(ProductService productService) {
    this.productService = productService;
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
}
