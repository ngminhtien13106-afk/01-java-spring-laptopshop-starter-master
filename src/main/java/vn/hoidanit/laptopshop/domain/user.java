package vn.hoidanit.laptopshop.domain;

public class User {
  // id: long
  // email: String
  // password: String
  // fullName: String
  // address: String;
  // phone: String
  private long id;
  private String email;
  private String password;
  private String fullname;
  private String address;
  private String phone;

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

  @Override
  public String toString() {
    return "User [id:" + id + "email: " + email + "fullName: " + fullname + "phone: " + phone + "address: "
        + address + "]";
  }
}
