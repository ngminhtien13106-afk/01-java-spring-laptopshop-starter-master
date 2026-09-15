package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
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
  public String getHomeDashboard(Model model) {
    List<Product> products = this.productService.getAllProducts();
    model.addAttribute("products", products);
    return "admin/product/managementProduct";
  }

  // create Product
  @RequestMapping("/admin/product/createPage")
  public String createProductPage(Model model) {
    model.addAttribute("newProduct", new Product());
    return "admin/product/createProduct";

  }

  @RequestMapping(value = "/admin/product/createSuccess", method = RequestMethod.POST)
  public String createProductPage(@ModelAttribute("newProduct") @Valid Product product,
      BindingResult newProductbBindingResult,
      @RequestParam("file") MultipartFile file) {

    List<FieldError> errors = newProductbBindingResult.getFieldErrors();
    for (FieldError error : errors) {
      System.out.print(">>>" + error.getField() + error.getDefaultMessage());
    }

    if (newProductbBindingResult.hasErrors()) {
      return "admin/product/createProduct";
    }

    String imgproduct = this.uploadService.handleSaveUploadFile(file, "images/product");
    product.setImage(imgproduct);
    this.productService.handleSaveProduct(product);
    return "redirect:/admin/product";

  }

  // view
  @RequestMapping("/admin/product/view/{productid}")
  public String viewProductPage(Model model, @PathVariable long productid) {

    model.addAttribute("newProduct", productService.getProductId(productid));
    return "admin/product/viewProduct";
  }

  // update

  @RequestMapping("/admin/product/update/{productid}")
  public String updateProductPage(Model model, @PathVariable long productid) {

    model.addAttribute("newProduct", productService.getProductId(productid));
    model.addAttribute("productId", productid);
    return "admin/product/updateProduct";
  }

  @RequestMapping(value = "/admin/product/UpdateSuccess/{productId}", method = RequestMethod.POST)
  public String updateProductPage(@ModelAttribute("newProduct") @Valid Product product,
      BindingResult newProductbBindingResult,
      @PathVariable long productId,
      @RequestParam("file") MultipartFile file,
      Model model) {

    if (newProductbBindingResult.hasErrors()) {
      model.addAttribute("newProduct", product);
      model.addAttribute("productId", productId);
      return "/admin/product/updateProduct";
    }
    Product product2 = this.productService.getProductId(productId);
    if (!file.isEmpty()) {
      String imgproduct = this.uploadService.handleSaveUploadFile(file, "images/product");

      product2.setImage(imgproduct);
    }
    product2.setName(product.getName());
    product2.setPrice(product.getPrice());
    product2.setDetailDesc(product.getDetailDesc());
    product2.setShortDesc(product.getShortDesc());
    product2.setQuantity(product.getQuantity());
    product2.setFactory(product.getFactory());
    product2.setTarget(product.getTarget());

    this.productService.handleSaveProduct(product2);
    return "redirect:/admin/product";

  }

  // delete
  @RequestMapping("/admin/product/delete/{productid}")
  public String deleteProductpage(Model model, @PathVariable long productid) {
    model.addAttribute("productId", productid);
    return "admin/product/deleteProduct";
  }

  @RequestMapping(value = "/admin/product/deleteSuccess/{productId}", method = RequestMethod.POST)
  public String deleteProductPage(@PathVariable long productId) {
    Product product = this.productService.getProductId(productId);
    this.productService.handleDeleteProduct(product.getId());
    return "redirect:/admin/product";

  }

}
