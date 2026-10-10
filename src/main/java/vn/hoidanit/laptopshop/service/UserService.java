package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.OrderRepository;
import vn.hoidanit.laptopshop.repository.ProductRepository;
import vn.hoidanit.laptopshop.repository.RoleRepository;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;

  public UserService(UserRepository userRepository, RoleRepository roleRepository, ProductRepository productRepository,
      OrderRepository orderRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }

  public String handleHell() {
    return "Hello from Service";
  }

  // User
  public List<User> getAllUsers() {
    return this.userRepository.findAll();
  }

  public User getUserId(long id) {
    return this.userRepository.findById(id);
  }

  public User handleSaveUser(User user) {
    return this.userRepository.save(user);
  }

  public User handleDeleteUser(long id) {
    return this.userRepository.deleteById(id);
  }

  public User getUserByEmail(String email) {
    return this.userRepository.findByEmail(email);

  }

  // Role
  public Role getRoleName(String name) {
    return this.roleRepository.findByName(name);
  }

  // Count product , user , order
  public long getCountUser() {
    return this.userRepository.count();
  }

  public long getCountProduct() {
    return this.productRepository.count();
  }

  public long getCountOrder() {
    return this.orderRepository.count();
  }

}
