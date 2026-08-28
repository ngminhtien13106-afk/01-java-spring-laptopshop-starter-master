package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

  // @RequestMapping("/")
  // public String getHomePage(Model model) {
  // List<User> users = this.userservice.getAllUsersByEmailList("Hà Nội");
  // System.out.print(users);
  // return "hello";
  // }

  // Nếu server nhận được request đến /admin/user, hãy chạy method getHomeUser().
  @RequestMapping("/admin/user")
  public String getHomeUser(Model model) {
    List<User> users = this.userservice.getAllUsers();
    model.addAttribute("users1", users);
    // render trang /view/admin/user/managementUser.jsp
    return "admin/user/managementUser";
  }

  // Nếu server nhận được request đến /admin/user, hãy chạy method CreateUser().
  @RequestMapping("/admin/user/createPage")
  public String createUserPage(Model model) {
    // Tạo object với tên là newUser
    model.addAttribute("newUser", new User());
    // render trang /view/admin/user/create.jsp
    return "admin/user/create";
  }

  // Nếu server nhận được request đến /admin/user/view/..., hãy chạy method
  // ViewUser().
  @RequestMapping("/admin/user/view/{userid}")
  public String getUserdetail(Model model, @PathVariable long userid) {
    // Tạo object với tên là newUser
    model.addAttribute("newUser", userid);

    // select information detail user
    User user = this.userservice.getUserId(userid);
    model.addAttribute("detailUser", user);
    // render trang /view/admin/user/create.jsp
    return "admin/user/viewUser";
  }

  // Nếu server nhận được request đến /admin/user/updata/..., hãy chạy method
  // UpdataUser().
  @RequestMapping("/admin/user/updata/{userid}")
  public String updataUserdetail(Model model, @PathVariable long userid) {
    // select information detail user
    model.addAttribute("detailUser", userservice.getUserId(userid));
    // render trang /view/admin/user/updataUser.jsp
    return "admin/user/updataUser";
  }

  // Nếu server nhận được request đến /admin/user/delete/..., hãy chạy method
  // deleteUser().
  @RequestMapping("/admin/user/delete/{userid}")
  public String deleteUserdetail(Model model, @PathVariable long userid) {
    // Tạo object với tên là newUser
    // select information detail user

    model.addAttribute("detailUser", userservice.getUserId(userid));
    // render trang /view/admin/user/deleteUser.jsp
    return "admin/user/deleteUser";
  }

  // Nếu nhận được POST request tới /admin/user/createSuccess, hãy chạy method
  // createUserPage().
  // method = RequestMethod.POST Nó có nghĩa:Method này chỉ xử lý HTTP POST.
  @RequestMapping(value = "/admin/user/createSuccess", method = RequestMethod.POST)
  public String createUserPage(@ModelAttribute("newUser") User TMind) {

    if (TMind.getEmail() == "" || TMind.getFullname() == "" || TMind.getPassword() == "" || TMind.getPhone() == ""
        || TMind.getAddress() == "") {
      System.out.print("Create failed");
    } else {
      this.userservice.handleSaveUser(TMind);
    }
    return "redirect:/admin/user";
  }

  @RequestMapping(value = "/admin/user/updataSuccess/{userid}", method = RequestMethod.POST)
  public String updataUserPage(@ModelAttribute("detailUser") User TMind, @PathVariable long userid) {
    // Set id cho object TMind

    User resultUser = this.userservice.getUserId(userid);
    resultUser.setAddress(TMind.getAddress());
    resultUser.setFullname(TMind.getPhone());
    resultUser.setFullname(TMind.getFullname());
    if (resultUser.getAddress() == "" || resultUser.getFullname() == "" || resultUser.getPhone() == "") {
      System.out.print("Update failed");
    } else {
      this.userservice.handleSaveUser(resultUser);
    }

    return "redirect:/admin/user";
  }

  @RequestMapping(value = "/admin/user/deleteSuccess/{userid}", method = RequestMethod.POST)
  public String deleteUserPage(@ModelAttribute("detailUser") User TMind, @PathVariable long userid) {
    // Set id cho object TMind
    TMind.setId(userid);

    // Update thông tin chỉnh sủa
    this.userservice.handleDeleteUser(userid);
    return "redirect:/admin/user";
  }
}
