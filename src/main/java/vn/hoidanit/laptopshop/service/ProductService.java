package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.repository.CartRepository;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;
  private final CartRepository cartRepository;
  private final CartDetailRepository cartDetailRepository;
  private final UserService userService;

  public ProductService(ProductRepository productRepository, CartRepository cartRepository,
      CartDetailRepository cartDetailRepository, UserService userService) {
    this.productRepository = productRepository;
    this.cartRepository = cartRepository;
    this.cartDetailRepository = cartDetailRepository;
    this.userService = userService;
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

  public void hanldAddProductToCart(long id, String email) {
    User user = this.userService.getUserByEmail(email);

    if (user != null) {
      Cart cart = this.cartRepository.findByUser(user);

      if (cart == null) {

        Cart otherCart = new Cart();
        otherCart.setUser(user);
        otherCart.setSum(1);

        cart = this.cartRepository.save(otherCart);
      }
      Product product = this.productRepository.findById(id);

      CartDetail cartDetail = new CartDetail();

      cartDetail.setPrice(product.getPrice());
      cartDetail.setProduct(product);
      cartDetail.setCart(cart);
      cartDetail.setQuantity(1);

      this.cartDetailRepository.save(cartDetail);
    }

  }
}
