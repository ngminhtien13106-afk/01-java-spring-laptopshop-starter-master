package vn.hoidanit.laptopshop.controller;

import java.util.List;

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
  // List<User> arrUser = this.userservice.getAllUsersByEmailList("Lào Cai - Sơn
  // La");
  // System.out.print(arrUser);
  // return "hello";
  // }

  // Nếu server nhận được request đến /admin/user, hãy chạy method getHomeUser().
  @RequestMapping("/admin/user")
  public String getHomeUser(Model model) {
    // Tạo object với tên là newUser
    // render trang /view/admin/user/create.jsp
    return "admin/user/managementUser";
  }

  // Nếu server nhận được request đến /admin/user, hãy chạy method getHomeUser().
  @RequestMapping("/admin/user/createPage")
  public String createUserPage(Model model) {
    // Tạo object với tên là newUser
    model.addAttribute("newUser", new User());
    // render trang /view/admin/user/create.jsp
    return "admin/user/create";
  }

  // Nếu nhận được POST request tới /admin/user/create1, hãy chạy method
  // createUserPage().
  // method = RequestMethod.POST Nó có nghĩa:Method này chỉ xử lý HTTP POST.
  @RequestMapping(value = "/admin/user/createSuccess", method = RequestMethod.POST)
  public String createUserPage(@ModelAttribute("newUser") User TMind) {
    this.userservice.handleSaveUser(TMind);

    System.out.println("run Here" + TMind);
    return "hello";
  }
}
