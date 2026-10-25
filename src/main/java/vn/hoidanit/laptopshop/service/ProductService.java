package vn.hoidanit.laptopshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.controller.admin.productController;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.Order_detail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.DTO.ProductCriteriaDTO;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.repository.CartRepository;
import vn.hoidanit.laptopshop.repository.OrderDetailRepository;
import vn.hoidanit.laptopshop.repository.OrderRepository;
import vn.hoidanit.laptopshop.repository.ProductRepository;
import vn.hoidanit.laptopshop.service.Specification.ProductSpecs;

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

  // page & specification

  public Page<Product> searchProducts(
      Pageable pageable, ProductCriteriaDTO productCriteriaDTO) {

    // if (productCriteriaDTO.getPrice() != null) {

    // }
    if (productCriteriaDTO.getFactory() == null && productCriteriaDTO.getPrice() == null
        && productCriteriaDTO.getFlexRadioDefault() == null && productCriteriaDTO.getTarget() == null) {
      return productRepository.findAll(pageable);
    }
    Specification<Product> spec = Specification
        .where(null);
    if (productCriteriaDTO.getFactory() != null && productCriteriaDTO.getFactory().isPresent()) {
      Specification<Product> otherSpec = ProductSpecs.factoryIn(productCriteriaDTO.getFactory().get());
      spec = spec.and(otherSpec);
    }
    if (productCriteriaDTO.getTarget() != null && productCriteriaDTO.getTarget().isPresent()) {
      Specification<Product> otherSpec = ProductSpecs.targetIn(productCriteriaDTO.getTarget().get());
      spec = spec.and(otherSpec);
    }
    // if (productCriteriaDTO.getFlexRadioDefault() != null &&
    // productCriteriaDTO.getFlexRadioDefault().isPresent()) {
    // Specification<Product> otherSpec =
    // ProductSpecs.priceArrange(productCriteriaDTO.getFlexRadioDefault().get());
    // spec = spec.and(otherSpec);
    // }
    if (productCriteriaDTO.getPrice() != null &&
        productCriteriaDTO.getPrice().isPresent()) {
      double max = 0;
      double min = 0;
      if (productCriteriaDTO.getPrice().get().equals("Tu10-15")) {
        max = 15000000;
        min = 10000000;
      } else if (productCriteriaDTO.getPrice().get().equals("Tu15-20")) {
        max = 20000000;
        min = 15000000;
      } else if (productCriteriaDTO.getPrice().get().equals("Tu20-25")) {
        max = 25000000;
        min = 20000000;
      } else if (productCriteriaDTO.getPrice().get().equals("duoi10")) {
        min = 10000000;
      } else if (productCriteriaDTO.getPrice().get().equals("tren30")) {
        max = 30000000;
      }
      Specification<Product> otherSpec = ProductSpecs.price(max, min);
      spec = spec.and(otherSpec);
    }

    return productRepository.findAll(spec, pageable);
  }

  // public Page<Product> getAllProducts(Pageable pageable, List<String> name) {
  // return this.productRepository.findAll(ProductSpecs.factoryIn(name),
  // pageable);
  // }

  // public Page<Product> getLikeProducts(Pageable pageable, String name) {
  // return this.productRepository.findAll(ProductSpecs.factoryLike(name),
  // pageable);
  // }
  public Page<Product> getAllProducts(Pageable pageable) {
    return this.productRepository.findAll(pageable);
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

  public void hanldAddProductToCart(long id, String email, HttpSession session, long getValQuantitys) {
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
        cartDetail.setQuantity(getValQuantitys);
        // update Cart
        cart.setSum(cart.getSum() + 1);
        session.setAttribute("cart", cart.getSum());

        this.cartDetailRepository.save(cartDetail);

      } else {
        isExistsProductInCart.setQuantity(isExistsProductInCart.getQuantity() + getValQuantitys);

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

  public Page<Order> getAllOrders(Pageable pageable) {
    return this.orderRepository.findAll(pageable);
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

  // history
  public List<Order_detail> handleHistory(String email) {
    User user = this.userService.getUserByEmail(email);
    List<Order_detail> order_details = new ArrayList<>();
    List<Order> order = user.getOrders();
    for (int i = 0; i < order.size(); i++) {
      List<Order_detail> order_detail = this.orderDetailRepository.findByOrder(order.get(i));
      order_details.add(order_detail.get(i));
    }
    return order_details;

  }

}
