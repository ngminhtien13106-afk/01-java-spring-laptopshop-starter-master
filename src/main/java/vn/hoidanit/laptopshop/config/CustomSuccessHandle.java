package vn.hoidanit.laptopshop.config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

public class CustomSuccessHandle implements AuthenticationSuccessHandler {
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
  @Autowired
  private UserService userService;

  // Authentication authentication: thông tin về người dùng sau khi Spring
  // Security xác thực.
  protected String determineTargetUrl(final Authentication authentication) {
    // map giống như object js => key: value
    Map<String, String> roleTargetUrlMap = new HashMap<>();
    roleTargetUrlMap.put("ROLE_USER", "/");
    roleTargetUrlMap.put("ROLE_ADMIN", "/admin");
    // getAuthorities() lấy ra quyền/role của user.
    final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    for (final GrantedAuthority grantedAuthority : authorities) {
      String authorityName = grantedAuthority.getAuthority();
      if (roleTargetUrlMap.containsKey(authorityName)) {
        // return về url tương ứng
        return roleTargetUrlMap.get(authorityName);
      }
    }

    throw new IllegalStateException();
  }

  protected void handle(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication) throws IOException {

    String targetUrl = determineTargetUrl(authentication);

    if (response.isCommitted()) {

      return;
    }

    redirectStrategy.sendRedirect(request, response, targetUrl);
  }

  // Kiểm tra session nếu không có thì dừng lại , còn có thì dùng nó
  protected void clearAuthenticationAttributes(HttpServletRequest request, Authentication authentication) {
    HttpSession session = request.getSession(false);
    if (session == null) {
      return;
    }

    // get email
    String currentPrincipalName = authentication.getName();
    // query email
    User user = this.userService.getUserByEmail(currentPrincipalName);

    if (user != null) {
      session.setAttribute("fullName", user.getFullname());
      session.setAttribute("avatar", user.getAvatar());
      session.setAttribute("id", user.getId());
      session.setAttribute("email", user.getEmail());
    }

    session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    // TODO Auto-generated method stub
    handle(request, response, authentication);
    clearAuthenticationAttributes(request, authentication);
  }

}
