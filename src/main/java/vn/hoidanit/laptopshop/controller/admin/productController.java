package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class productController {

  @RequestMapping("/admin/product")
  public String getHomeDashboard() {
    return "admin/product/homeProduct";
  }

}
