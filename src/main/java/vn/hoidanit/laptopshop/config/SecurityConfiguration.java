package vn.hoidanit.laptopshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Ma hoa password ( Hashing)
// ví dụ: input: "353249523" output: 3338be694f50c5f338814986cdf0686453a888b84f424d792af4b9202398f39

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
