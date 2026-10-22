package vn.hoidanit.laptopshop.service.Specification;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.Product_;

public class ProductSpecs {
  // Lọc theo danh sách nhà sản xuất
  public static Specification<Product> factoryIn(List<String> factories) {
    return (root, query, cb) -> {

      if (factories == null || factories.isEmpty()) {
        return cb.conjunction();
      }

      return root.get(Product_.FACTORY).in(factories);
    };
  }

  // Tìm kiếm theo tên sản phẩm
  public static Specification<Product> factoryLike(String name) {
    return (root, query, cb) -> {

      if (name == null || name.isBlank()) {
        return cb.conjunction();
      }

      return cb.like(
          cb.lower(root.get(Product_.NAME)),
          "%" + name.trim().toLowerCase() + "%");
    };
  }

  // Tìm kiếm sản phẩm sản phẩm nhỏ hơn đối số number
  public static Specification<Product> priceLt(double priceMin) {
    return (root, query, cb) -> {

      if (priceMin == 0) {
        return cb.conjunction();
      }

      return cb.le(
          root.get(Product_.PRICE), priceMin);
    };
  }

  public static Specification<Product> price(double priceMax, double priceMin) {
    return (root, query, cb) -> {
      if (priceMax == 0 && priceMin == 0) {
        return cb.conjunction();
      }

      return cb.and(cb.le(root.get(Product_.PRICE), priceMax),
          cb.ge(root.get(Product_.PRICE), priceMin));
    };
  }

}
