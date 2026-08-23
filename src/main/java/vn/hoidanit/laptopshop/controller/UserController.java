package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
  private UserService userservice;

  public UserController(UserService userservice) {
    this.userservice = userservice;
  }

  @RequestMapping("/")
  public String getHomePage(Model model) {
    String test = this.userservice.handleHell();
    model.addAttribute("TMind", test);
    return "hello";
  }

}

// @RestController
// public class UserController {

// private UserService userservice;

// public UserController(UserService userservice) {
// this.userservice = userservice;
// }

// @GetMapping("")
// public String getHomePage() {
// return this.userservice.handleHell();
// }

// }
