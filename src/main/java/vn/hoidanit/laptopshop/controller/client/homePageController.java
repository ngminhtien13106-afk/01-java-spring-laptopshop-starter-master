package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homePageController {

  @RequestMapping("/")
  public String getHomePage() {
    return "client/homePage/homePage";
  }
}
