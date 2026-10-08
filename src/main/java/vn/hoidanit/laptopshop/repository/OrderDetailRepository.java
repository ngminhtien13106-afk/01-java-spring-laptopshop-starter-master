package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.laptopshop.domain.Order_detail;

public interface OrderDetailRepository extends JpaRepository<Order_detail, Long> {

}
