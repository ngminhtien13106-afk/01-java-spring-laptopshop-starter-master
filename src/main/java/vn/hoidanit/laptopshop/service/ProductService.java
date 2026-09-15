package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product handleSaveProduct(Product product) {

    return this.productRepository.save(product);

  }

  public List<Product> getAllProducts() {
    return this.productRepository.findAll();
  }

  public Product getProductId(long id) {
    return this.productRepository.findById(id);
  }

  public Product handleDeleteProduct(long id) {
    return this.productRepository.deleteById(id);
  }

  public List<Object[]> countProductByFactory() {
    return this.productRepository.countProductByFactory();
  }

}
