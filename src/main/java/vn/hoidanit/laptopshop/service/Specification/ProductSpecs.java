package vn.hoidanit.laptopshop.service.Specification;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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
  public static Specification<Product> priceLe(double priceMin) {
    return (root, query, cb) -> {

      if (priceMin == 0) {
        return cb.conjunction();
      }

      return cb.le(
          root.get(Product_.PRICE), priceMin);
    };
  }

  // Tìm kiếm sản phẩm lớn hơn đối số number
  public static Specification<Product> priceGe(double priceMax) {
    return (root, query, cb) -> {

      if (priceMax == 0) {
        return cb.conjunction();
      }

      return cb.ge(
          root.get(Product_.PRICE), priceMax);
    };
  }

  // Tìm kiểm sản phẩm trong khoảng giá
  public static Specification<Product> price(double priceMax, double priceMin) {
    return (root, query, cb) -> {
      if (priceMax == 0 && priceMin == 0) {
        return cb.conjunction();
      }
      if (priceMin > 10000000 && priceMax < 30000000) {
        return cb.and(cb.le(root.get(Product_.PRICE), priceMax),
            cb.ge(root.get(Product_.PRICE), priceMin));
      } else if (priceMin == 10000000 && priceMax == 0) {
        return cb.le(
            root.get(Product_.PRICE), priceMin);
      } else if (priceMax == 30000000 && priceMin == 0) {
        return cb.ge(
            root.get(Product_.PRICE), priceMax);
      }
      return cb.conjunction();
    };
  }

  // Sắp xếp
  public static Specification<Product> priceArrange(String flexRadioDefault) {
    return (root, query, cb) -> {

      if (flexRadioDefault == null || flexRadioDefault.isEmpty()) {
        return cb.conjunction();
      }

      if (flexRadioDefault.equals("tang-dan")) {
        query.orderBy(cb.asc(root.get(Product_.PRICE)));

      }
      if (flexRadioDefault.equals("giam-dan")) {
        query.orderBy(cb.desc(root.get(Product_.PRICE)));
      }

      return cb.conjunction();
    };
  }

  public static Specification<Product> targetIn(List<String> target) {
    return (root, query, cb) -> {

      if (target == null || target.isEmpty()) {
        return cb.conjunction();
      }

      return root.get(Product_.TARGET).in(target);
    };
  }
}
