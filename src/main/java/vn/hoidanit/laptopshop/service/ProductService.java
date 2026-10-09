package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.controller.admin.orderController;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.Order_detail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.repository.CartRepository;
import vn.hoidanit.laptopshop.repository.OrderDetailRepository;
import vn.hoidanit.laptopshop.repository.OrderRepository;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {

  private final OrderDetailRepository orderDetailRepository;
  private final OrderRepository orderRepository;
  private final ProductRepository productRepository;
  private final CartRepository cartRepository;
  private final CartDetailRepository cartDetailRepository;
  private final UserService userService;

  public ProductService(ProductRepository productRepository, CartRepository cartRepository,
      CartDetailRepository cartDetailRepository, UserService userService,
      OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
    this.productRepository = productRepository;
    this.cartRepository = cartRepository;
    this.cartDetailRepository = cartDetailRepository;
    this.userService = userService;

    this.orderRepository = orderRepository;
    this.orderDetailRepository = orderDetailRepository;

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

  public CartDetail getCartDetailId(long id) {
    return this.cartDetailRepository.findById(id);
  }

  public void hanldAddProductToCart(long id, String email, HttpSession session) {
    User user = this.userService.getUserByEmail(email);

    if (user != null) {
      Cart cart = this.cartRepository.findByUser(user);

      if (cart == null) {

        Cart otherCart = new Cart();
        otherCart.setUser(user);
        otherCart.setSum(0);

        cart = this.cartRepository.save(otherCart);
      }

      Product product = this.productRepository.findById(id);
      CartDetail isExistsProductInCart = this.cartDetailRepository.findByCartAndProduct(cart, product);

      if (isExistsProductInCart == null) {
        CartDetail cartDetail = new CartDetail();

        cartDetail.setPrice(product.getPrice());
        cartDetail.setProduct(product);
        cartDetail.setCart(cart);
        cartDetail.setQuantity(1);
        // update Cart
        cart.setSum(cart.getSum() + 1);
        session.setAttribute("cart", cart.getSum());

        this.cartDetailRepository.save(cartDetail);

      } else {
        isExistsProductInCart.setQuantity(isExistsProductInCart.getQuantity() + 1);

      }
    }

  }

  public List<CartDetail> handleCartDetails(String email) {
    User user = this.userService.getUserByEmail(email);
    Cart cart = this.cartRepository.findByUser(user);
    return this.cartDetailRepository.findByCart(cart);

  }

  public void handleDeleteCart(long id, HttpSession session) {

    CartDetail cartDetail = this.cartDetailRepository.findById(id);

    if (cartDetail == null) {
      return;
    }

    long idCart = cartDetail.getCart().getId();

    this.cartDetailRepository.deleteById(id);

    Cart cart = this.cartRepository.findById(idCart);

    if (cart == null) {
      return;
    }

    if (cart.getSum() > 0) {
      cart.setSum(cart.getSum() - 1);
      this.cartRepository.save(cart);

      session.setAttribute("cart", cart.getSum());
    }
  }

  public void handleRecelveOrder(User id, String receiveFullName, String receiveAddress, String receivePhoneNumber,
      double totalPrice, HttpSession session) {
    // step 1: Create Order
    Order order = new Order();
    order.setUser(id);
    order.setReceiveFullName(receiveFullName);
    order.setReceiveAddress(receiveAddress);
    order.setReceivePhoneNumber(receivePhoneNumber);
    order.setTotalPrice(totalPrice);
    order = this.orderRepository.save(order);
    // step 2: Create OrderDetail
    Cart cart = this.cartRepository.findByUser(id);
    if (cart != null) {
      List<CartDetail> cartDetails = this.cartDetailRepository.findByCart(cart);
      if (cartDetails != null) {
        for (CartDetail cd : cartDetails) {

          Order_detail order_detail = new Order_detail();
          order_detail.setOrder(order);
          order_detail.setPrice(cd.getPrice());
          order_detail.setProduct(cd.getProduct());
          order_detail.setQuantity(cd.getQuantity());

          this.orderDetailRepository.save(order_detail);
        }
        // step 3: delete CartDetail
        for (CartDetail cd : cartDetails) {
          this.cartDetailRepository.deleteById(cd.getId());
        }
        // step 4: delete Cart
        this.cartRepository.deleteById(cart.getId());

        // step 5: update session
        session.setAttribute("cart", 0);
      }
    }

  }

  public List<Order> getAllOrders() {
    return this.orderRepository.findAll();
  }

  public List<Order_detail> getOrder_detailsByOrder(Order order) {
    return this.orderDetailRepository.findByOrder(order);
  }

  public void handleDeleteOrder(long id, Order order) {
    // step 1: Xoá Order_detail
    List<Order_detail> order_details = this.orderDetailRepository.findByOrder(order);
    if (order_details != null) {
      for (Order_detail order_detail : order_details) {
        this.orderDetailRepository.deleteById(order_detail.getId());
      }
    }

    // step 2: Xoá Order
    this.orderRepository.deleteById(id);
  }

}
