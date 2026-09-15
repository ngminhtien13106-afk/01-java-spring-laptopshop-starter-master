package vn.hoidanit.laptopshop.service.DTO;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.DTO.RegisterDTO;
import vn.hoidanit.laptopshop.repository.DTO.RegisterRepository;

@Service
public class RegisterDTOService {
  private final RegisterRepository registerRepository;

  public RegisterDTOService(RegisterRepository registerRepository) {
    this.registerRepository = registerRepository;
  }

  public User getRegisterDTOtoUser(RegisterDTO registerDTO) {
    User user = new User();
    user.setFullname(registerDTO.getFirstName() + " " + registerDTO.getLastName());
    user.setEmail(registerDTO.getEmail());
    user.setPassword(registerDTO.getPassword());
    return user;
  }

  public boolean checkEmailExists(String email) {
    return this.registerRepository.existsByEmail(email);
  }

  
}
