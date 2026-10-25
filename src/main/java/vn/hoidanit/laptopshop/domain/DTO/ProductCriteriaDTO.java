package vn.hoidanit.laptopshop.domain.DTO;

import java.util.List;
import java.util.Optional;

public class ProductCriteriaDTO {
  private Optional<String> page;
  private Optional<String> name;
  private Optional<List<String>> factory;
  private Optional<String> price;
  private Optional<String> flexRadioDefault;
  private Optional<List<String>> target;

  public Optional<String> getName() {
    return name;
  }

  public void setName(Optional<String> name) {
    this.name = name;
  }

  public Optional<List<String>> getFactory() {
    return factory;
  }

  public void setFactory(Optional<List<String>> factory) {
    this.factory = factory;
  }

  public Optional<String> getPrice() {
    return price;
  }

  public void setPrice(Optional<String> price) {
    this.price = price;
  }

  public Optional<String> getFlexRadioDefault() {
    return flexRadioDefault;
  }

  public void setFlexRadioDefault(Optional<String> flexRadioDefault) {
    this.flexRadioDefault = flexRadioDefault;
  }

  public Optional<List<String>> getTarget() {
    return target;
  }

  public void setTarget(Optional<List<String>> target) {
    this.target = target;
  }

  public Optional<String> getPage() {
    return page;
  }

  public void setPage(Optional<String> page) {
    this.page = page;
  }

}
