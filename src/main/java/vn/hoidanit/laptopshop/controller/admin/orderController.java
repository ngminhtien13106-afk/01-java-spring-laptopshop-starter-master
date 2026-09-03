package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class orderController {

  @RequestMapping("/admin/order")
  public String getHomeDashboard() {
    return "admin/order/homeOrder";
  }

}
