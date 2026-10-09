package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.Order_detail;

public interface OrderDetailRepository extends JpaRepository<Order_detail, Long> {
  List<Order_detail> findByOrder(Order order);

}
