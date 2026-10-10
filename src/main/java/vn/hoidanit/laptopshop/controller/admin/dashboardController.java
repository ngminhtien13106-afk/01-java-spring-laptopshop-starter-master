package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class dashboardController {
  @Autowired
  private UserService userService;

  @RequestMapping("/admin")
  public String getHomeDashboard(Model model) {
    model.addAttribute("countUser", this.userService.getCountUser());
    model.addAttribute("countProduct", this.userService.getCountProduct());
    model.addAttribute("countOrder", this.userService.getCountOrder());

    return "admin/dashboard/homeDashBoard";
  }

}
