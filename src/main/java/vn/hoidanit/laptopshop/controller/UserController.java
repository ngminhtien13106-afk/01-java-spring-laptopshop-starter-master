package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
  private UserService userservice;

  public UserController(UserService userservice) {
    this.userservice = userservice;
  }

  // @RequestMapping("/")
  // public String getHomePage(Model model) {
  // String test = this.userservice.handleHell();
  // model.addAttribute("TMind", test);
  // return "hello";
  // }

  @RequestMapping("/admin/user")
  public String getHomeUser(Model model) {
    model.addAttribute("newUser", new User());
    return "admin/user/create";
  }

  @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
  public String createUserPage(@ModelAttribute("newUser") User TMind) {
    System.out.println("run Here" + TMind);
    return "hello";
  }
}
