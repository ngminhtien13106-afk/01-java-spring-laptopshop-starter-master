package vn.hoidanit.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import vn.hoidanit.laptopshop.service.validator.StrongPassword;

@Entity
@Table(name = "Users")
public class User {
  // @ID chỉ ứng với thuôc tính first , các thuộc tính sau không ảnh hưởng
  @Id
  // @GeneratedValue với method GenerationType.IDENTITY là id tự động tăng ( chỉ
  // ứng với attribute first)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
  private String email;
  // @NotBlank(message = "Vui lòng nhập đầy đủ thông tin User")
  // (?=.*[A-Z])kiểm tra xem ở phía sau có ít nhất một chữ hoa [A-Z] hay không
  // @Pattern(regexp =
  // "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
  // message = "Mật khẩu phải có ít nhất 8 ký tự, gồm chữ hoa, chữ thường, số và
  // ký tự đặc biệt")
  @StrongPassword
  private String password;
  @NotBlank(message = "Vui lòng nhập đầy đủ FullName người dùng")
  private String fullname;
  // @NotBlank(message = "Vui lòng nhập đầy đu thông tin người dùng")
  private String address;
  // @Pattern(regexp = "^(03|05|07|08|09)[0-9]{8}$", message = "Số điện thoại
  // không hợp lệ")
  private String phone;
  private String avatar;

  // Users many - to one - role
  @ManyToOne
  // Create column foreign key with role
  @JoinColumn(name = "role_id")
  // khai báo đối tượng role
  private Role role;

  // User one - to many - order
  @OneToMany(mappedBy = "user")
  private List<Order> orders;

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", email=" + email + ", password=" + password + ", fullname=" + fullname + ", address="
        + address + ", phone=" + phone + ", avatar=" + avatar + "]";
  }

}
