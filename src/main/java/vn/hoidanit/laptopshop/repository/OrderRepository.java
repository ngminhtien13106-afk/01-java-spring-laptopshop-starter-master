package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.laptopshop.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

  Order deleteById(long id);

}
