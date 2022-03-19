package com.efuture.product.service.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Specifying custom messages
 *
 */
@Component
@PropertySource("classpath:MessagesAndCodes.properties")
public class StatusCodeBundle {
  // Common Success code
  @Value("${code.success.common}")
  private String commonSuccessCode;

  // Product
  @Value("${message.success.save.product}")
  private String saveProductSuccessMessage;

  @Value("${message.validation.productName.alreadyExists}")
  private String productNameAlreadyExistMessage;

  @Value("${code.validation.product.notExists}")
  private String productNotExistCode;

  @Value("${message.validation.product.notExists}")
  private String productNotExistMessage;

  @Value("${code.validation.productName.alreadyExists}")
  private String productNameAlreadyExistCode;

  @Value("${message.success.update.product}")
  private String updateProductSuccessMessage;

  @Value("${code.validation.productStatus.notCorrect}")
  private String productStatusNotCorrectCode;

  @Value("${message.validation.productStatus.notCorrect}")
  private String productStatusNotCorrectMessage;

  @Value("${message.success.delete.product}")
  private String deleteProductSuccessMessage;

  @Value("${message.success.get.product}")
  private String getProductSuccessMessage;

  public String getCommonSuccessCode() {
    return commonSuccessCode;
  }

  public void setCommonSuccessCode(String commonSuccessCode) {
    this.commonSuccessCode = commonSuccessCode;
  }

  public String getSaveProductSuccessMessage() {
    return saveProductSuccessMessage;
  }

  public void setSaveProductSuccessMessage(String saveProductSuccessMessage) {
    this.saveProductSuccessMessage = saveProductSuccessMessage;
  }

  public String getProductNameAlreadyExistMessage() {
    return productNameAlreadyExistMessage;
  }

  public void setProductNameAlreadyExistMessage(String productNameAlreadyExistMessage) {
    this.productNameAlreadyExistMessage = productNameAlreadyExistMessage;
  }

  public String getProductNameAlreadyExistCode() {
    return productNameAlreadyExistCode;
  }

  public void setProductNameAlreadyExistCode(String productNameAlreadyExistCode) {
    this.productNameAlreadyExistCode = productNameAlreadyExistCode;
  }

  public String getProductNotExistCode() {
    return productNotExistCode;
  }

  public void setProductNotExistCode(String productNotExistCode) {
    this.productNotExistCode = productNotExistCode;
  }

  public String getUpdateProductSuccessMessage() {
    return updateProductSuccessMessage;
  }

  public void setUpdateProductSuccessMessage(String updateProductSuccessMessage) {
    this.updateProductSuccessMessage = updateProductSuccessMessage;
  }

  public String getProductNotExistMessage() {
    return productNotExistMessage;
  }

  public void setProductNotExistMessage(String productNotExistMessage) {
    this.productNotExistMessage = productNotExistMessage;
  }

  public String getProductStatusNotCorrectCode() {
    return productStatusNotCorrectCode;
  }

  public void setProductStatusNotCorrectCode(String productStatusNotCorrectCode) {
    this.productStatusNotCorrectCode = productStatusNotCorrectCode;
  }

  public String getProductStatusNotCorrectMessage() {
    return productStatusNotCorrectMessage;
  }

  public void setProductStatusNotCorrectMessage(String productStatusNotCorrectMessage) {
    this.productStatusNotCorrectMessage = productStatusNotCorrectMessage;
  }

  public String getDeleteProductSuccessMessage() {
    return deleteProductSuccessMessage;
  }

  public void setDeleteProductSuccessMessage(String deleteProductSuccessMessage) {
    this.deleteProductSuccessMessage = deleteProductSuccessMessage;
  }

  public String getGetProductSuccessMessage() {
    return getProductSuccessMessage;
  }

  public void setGetProductSuccessMessage(String getProductSuccessMessage) {
    this.getProductSuccessMessage = getProductSuccessMessage;
  }
}
