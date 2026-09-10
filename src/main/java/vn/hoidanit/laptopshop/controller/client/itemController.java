package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class itemController {
  @RequestMapping("/product/{id}")
  public String handleProductDetail(Model model) {

    return "client/product/productDetail";
  }
}
