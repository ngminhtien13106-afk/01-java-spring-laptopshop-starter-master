package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.Order_detail;
import vn.hoidanit.laptopshop.service.ProductService;

@Controller
public class orderController {

  private final ProductService productService;

  public orderController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping("/admin/order")
  public String getHomeDashboard(Model model) {
    List<Order> orders = this.productService.getAllOrders();
    model.addAttribute("order", orders);
    return "admin/order/homeOrder";
  }

  @RequestMapping("/admin/order/view/{id}")
  public String getOrderDetail(@PathVariable long id, Model model) {
    Order order = new Order();
    order.setId(id);
    List<Order_detail> order_details = this.productService.getOrder_detailsByOrder(order);
    model.addAttribute("order_details", order_details);
    return "admin/order/viewOrder";
  }

  @RequestMapping("/admin/order/delete/{id}")
  public String deleteOrderDetail(@PathVariable long id, Model model) {
    model.addAttribute("OrderId", id);

    return "admin/order/deleteOrder";
  }

  @RequestMapping(value = "/admin/order/deleteSuccess/{OrderId}", method = RequestMethod.POST)
  public String deleteOrderDetailSeccess(@PathVariable long OrderId) {

    Order order = new  Order(); 
    order.setId(OrderId);
    this.productService.handleDeleteOrder(OrderId, order);
    return "redirect:/admin/order";
  }

}
