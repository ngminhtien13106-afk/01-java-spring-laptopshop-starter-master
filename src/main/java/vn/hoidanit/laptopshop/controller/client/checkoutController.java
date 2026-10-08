package vn.hoidanit.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.domain.User;

@Controller
public class checkoutController {
  @Autowired
  private ProductService productService;

  @RequestMapping(value = "/configuration/checkout", method = RequestMethod.POST)
  public String handleCheckout(
      Model model,
      HttpServletRequest request,
      @RequestParam("cartDetailIds") long[] getValId,
      @RequestParam("quantities") long[] getValQuantity) {

    double totalPrice = 0;

    List<CartDetail> cartDetails = new ArrayList<>();

    for (int i = 0; i < getValId.length; i++) {

      long idCartDetail = getValId[i];
      long quantityCartDetail = getValQuantity[i];

      CartDetail cartDetail = this.productService.getCartDetailId(idCartDetail);

      cartDetail.setQuantity(quantityCartDetail);

      totalPrice += cartDetail.getPrice() * cartDetail.getQuantity();

      cartDetails.add(cartDetail);
    }

    model.addAttribute("cartDetails", cartDetails);
    model.addAttribute("totalPrice", totalPrice);

    return "client/product/checkout";
  }

  @RequestMapping(value = "/checkout/getInformation", method = RequestMethod.POST)
  public String handlGetInformation(@RequestParam("fullName") String fullName, @RequestParam("address") String address,
      @RequestParam("phoneNumber") String phoneNumber, HttpServletRequest request,
      @RequestParam("totalPrice") double totalPrice) {

    HttpSession session = request.getSession(false);
    long id = (long) session.getAttribute("id");
    User user = new User();
    user.setId(id);
    this.productService.handleRecelveOrder(user, fullName, address, phoneNumber, totalPrice, session);

    return "client/product/thanks";
  }

}
