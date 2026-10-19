package vn.hoidanit.laptopshop.service.Specification;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.Product_;

public class ProductSpecs {
  public static Specification<Product> factoryIn(List<String> name) {

    return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get(Product_.FACTORY)).value(name);
  }

  public static Specification<Product> factoryLike(String name) {

    return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Product_.FACTORY), "%" + name + "%");
  }

}
