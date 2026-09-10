package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;

@Controller
public class productController {
  private final ProductService productService;
  private final UploadService uploadService;

  public productController(ProductService productService, UploadService uploadService) {
    this.productService = productService;
    this.uploadService = uploadService;
  }

  // managementproduct
  @RequestMapping("/admin/product")
  public String getHomeDashboard() {
    return "admin/product/managementProduct";
  }

  // create Product
  @RequestMapping("/admin/product/createPage")
  public String createProductPage(Model model) {
    model.addAttribute("newProduct", new Product());
    return "admin/product/createProduct";

  }

  @RequestMapping(value = "/admin/product/createSuccess", method = RequestMethod.POST)
  public String createProductPage(@ModelAttribute("newProduct") Product product,
      @RequestParam("file") MultipartFile file) {

    if (product.getName() == null || product.getName().trim().isEmpty()
        || product.getPrice() == 0.0
        || product.getDetailDesc() == null || product.getDetailDesc().trim().isEmpty()
        || product.getShortDesc() == null || product.getShortDesc().trim().isEmpty()
        || product.getQuantity() == 0
        || product.getFactory() == null || product.getFactory().trim().isEmpty()
        || product.getTarget() == null || product.getTarget().trim().isEmpty()) {

      return "redirect:/admin/product?error=true";

    } else {

      String imgproduct = this.uploadService.handleSaveUploadFile(file, "client/img");

      product.setImage(imgproduct);
      this.productService.handleSaveProduct(product);
      return "redirect:/admin/product";
    }

  }

}
