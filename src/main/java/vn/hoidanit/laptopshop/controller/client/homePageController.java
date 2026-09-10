package vn.hoidanit.laptopshop.controller.client;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homePageController {

  @RequestMapping("/")
  public String getHomePage() {
    return "client/homePage/homePage";
  }

  @RequestMapping("/product")
  public String getProductDetail() {
    return "client/product/productDetail";
  }

}
