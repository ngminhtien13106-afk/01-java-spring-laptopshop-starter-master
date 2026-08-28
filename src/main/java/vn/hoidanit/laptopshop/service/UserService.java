package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public String handleHell() {
    return "Hello from Service";
  }

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

}
