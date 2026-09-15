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
    List<Product> allProduct = this.productService.getAllProducts();
    List<Product> randomProducts = new ArrayList<>();
    Random random = new Random();

    while (randomProducts.size() < 6 && randomProducts.size() < allProduct.size()) {

      Product randomProduct = allProduct.get(
          random.nextInt(allProduct.size()));

      if (!randomProducts.contains(randomProduct)) {
        randomProducts.add(randomProduct);
      }
    }

    model.addAttribute("randomProducts", randomProducts);

    model.addAttribute("factoryCount", result);
    model.addAttribute("product", products);

    return "client/product/productDetail";
  }
}
