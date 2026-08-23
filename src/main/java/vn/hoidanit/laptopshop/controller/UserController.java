package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
  private UserService userservice;

  public UserController(UserService userservice) {
    this.userservice = userservice;
  }

  @RequestMapping("/")
  public String getHomePage() {
    String test = this.userservice.handleHell();
    return "T-Mind.html";
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
