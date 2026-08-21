package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myControll {
  @GetMapping("/")
  public String index() {
    return "Hello with The T-Mind";
  }

  @GetMapping("/user")
  public String userPage() {
    return "Hello with user";
  }

  @GetMapping("/admin")
  public String adminPage() {
    return "Hello with admin";
  }
}
