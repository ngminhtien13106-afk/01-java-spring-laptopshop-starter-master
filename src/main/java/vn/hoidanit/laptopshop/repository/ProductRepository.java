package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.Product;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  Product save(Product product);

  Product findById(long id);

  Product deleteById(long id);

  @Query("""
          SELECT p.factory, COUNT(p)
          FROM Product p
          GROUP BY p.factory
      """)
  List<Object[]> countProductByFactory();

}
