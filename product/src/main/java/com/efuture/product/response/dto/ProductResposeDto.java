package com.efuture.product.response.dto;

import java.util.List;

public class ProductResposeDto {

  private String productName;
  private String productDescription;
  private Double price;
  private char status;
  private List<ProductCommentResponse> productComments;

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public char getStatus() {
    return status;
  }

  public void setStatus(char status) {
    this.status = status;
  }

  public List<ProductCommentResponse> getProductComments() {
    return productComments;
  }

  public void setProductComments(List<ProductCommentResponse> productComments) {
    this.productComments = productComments;
  }
}
