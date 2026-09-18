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
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.DispatcherType;
import vn.hoidanit.laptopshop.service.CustomUserDetailsService;
import vn.hoidanit.laptopshop.service.UserService;

// Ma hoa password ( Hashing)
// ví dụ: input: "353249523" output: 3338be694f50c5f338814986cdf0686453a888b84f424d792af4b9202398f39

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
  // hashcode
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // Check username - password
  @Bean
  public UserDetailsService userDetailsService(UserService userService) {
    return new CustomUserDetailsService(userService);
  }

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

  // Giao diện login

  @Bean
  public AuthenticationSuccessHandler CustomSuccessHandle() {
    return new CustomSuccessHandle();
  }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            // DispatcherType.FORWARD cho phép render các return requets/.jsp, mỗi return
            // jsp đều tính là request
            .dispatcherTypeMatchers(DispatcherType.FORWARD,
                // DispatcherType.INCLUDE cho phép sử dụng các trường thông tin của request
                // method
                DispatcherType.INCLUDE)
            .permitAll()

            .requestMatchers("/", "product/**", "/register", "/login", "/avatar", "/client/**", "/css/**", "/js/**",
                "/images/**")
            .permitAll()

            .requestMatchers("/admin/**").hasRole("ADMIN")

            .anyRequest().authenticated())

        .formLogin(formLogin -> formLogin
            // chuyển đổi login , mỗi lần request chạy /login
            .loginPage("/login")
            // login thất bại chạy request này
            .failureUrl("/login?error")
            .successHandler(CustomSuccessHandle())
            // All đều có quyền truy cập
            .permitAll());

    return http.build();
  }

}
