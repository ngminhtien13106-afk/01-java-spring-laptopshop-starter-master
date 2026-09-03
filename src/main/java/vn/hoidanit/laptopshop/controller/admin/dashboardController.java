package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dashboardController {

  @RequestMapping("/admin")
  public String getHomeDashboard() {
    return "admin/dashboard/homeDashBoard";
  }

}
