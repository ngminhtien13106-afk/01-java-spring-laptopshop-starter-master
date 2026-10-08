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

@Entity
@Table(name = "`Orders`")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  // private long userId;
  private double totalPrice;

  private String receiveFullName;

  public String getReceiveFullName() {
    return receiveFullName;
  }

  public void setReceiveFullName(String receiveFullName) {
    this.receiveFullName = receiveFullName;
  }

  public String getReceiveAddress() {
    return receiveAddress;
  }

  public void setReceiveAddress(String receiveAddress) {
    this.receiveAddress = receiveAddress;
  }

  public String getReceivePhoneNumber() {
    return receivePhoneNumber;
  }

  public void setReceivePhoneNumber(String receivePhoneNumber) {
    this.receivePhoneNumber = receivePhoneNumber;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Order_detail> getOrder_details() {
    return order_details;
  }

  public void setOrder_details(List<Order_detail> order_details) {
    this.order_details = order_details;
  }

  private String receiveAddress;

  private String receivePhoneNumber;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "order")
  private List<Order_detail> order_details;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", totalPrice=" + totalPrice + "]";
  }

}
