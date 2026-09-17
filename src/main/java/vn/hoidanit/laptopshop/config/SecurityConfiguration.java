package vn.hoidanit.laptopshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import vn.hoidanit.laptopshop.service.CustomUserDetailsService;
import vn.hoidanit.laptopshop.service.UserService;

// Ma hoa password ( Hashing)
// ví dụ: input: "353249523" output: 3338be694f50c5f338814986cdf0686453a888b84f424d792af4b9202398f39

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService(UserService userService) {
    return new CustomUserDetailsService(userService);
  }

  // @Bean
  // public AuthenticationManager authenticationManager(HttpSecurity http,
  // PasswordEncoder passwordEncoder,
  // UserDetailsService userDetailsService) throws Exception {
  // AuthenticationManagerBuilder authenticationManagerBuilder = http
  // .getSharedObject(AuthenticationManagerBuilder.class);
  // authenticationManagerBuilder
  // .userDetailsService(userDetailsService)
  // .passwordEncoder(passwordEncoder);
  // return authenticationManagerBuilder.build();
  // }
  @Bean
  public DaoAuthenticationProvider authProvider(
      PasswordEncoder passwordEncoder,
      UserDetailsService userDetailsService) {

    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder);
    // Có muốn UsernameNotFoundException hiển thị thông báo lỗi không
    // authProvider.setHideUserNotFoundExceptions(false);

    return authProvider;
  }

}
