package vn.hoidanit.laptopshop.controller.client;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.DTO.RegisterDTO;
import vn.hoidanit.laptopshop.service.UserService;
import vn.hoidanit.laptopshop.service.DTO.RegisterDTOService;

@Controller
public class authPageController {
  private final RegisterDTOService registerDTOService;
  private final PasswordEncoder passwordEncoder;
  private final UserService userService;

  public authPageController(RegisterDTOService registerDTOService, PasswordEncoder passwordEncoder,
      UserService userService) {
    this.registerDTOService = registerDTOService;
    this.passwordEncoder = passwordEncoder;
    this.userService = userService;
  }

  @RequestMapping("/register")
  public String getRegisterPage(Model model) {
    model.addAttribute("registerUser", new RegisterDTO());

    return "client/auth/register";
  }

  @RequestMapping("/registerSuccess")
  public String handleRegisterUser(@ModelAttribute("registerUser") @Valid RegisterDTO registerDTO,
      BindingResult registerUserbBindingResult,
      Model model) {
    if (registerUserbBindingResult.hasErrors()) {
      return "client/auth/register";
    }

    User user = this.registerDTOService.getRegisterDTOtoUser(registerDTO);
    user.setPassword(this.passwordEncoder.encode(registerDTO.getPassword()));
    user.setRole(this.userService.getRoleName("USER"));
    // save
    this.userService.handleSaveUser(user);
    return "redirect:/login";
  }

  @RequestMapping("/login")
  public String getLoginPage(Model model) {
    // model.addAttribute("registerUser", new RegisterDTO());

    return "client/auth/login";
  }

}
