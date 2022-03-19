package com.efuture.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.efuture.product.enums.RequestStatus;
import com.efuture.product.request.CommonRequest;
import com.efuture.product.request.dto.ProductRequestDto;
import com.efuture.product.response.BaseResponse;
import com.efuture.product.response.dto.ContentResponse;
import com.efuture.product.service.ProductService;
import com.efuture.product.service.utils.CommonRestEndpoints;
import com.efuture.product.service.utils.StatusCodeBundle;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private StatusCodeBundle messageBundle;

  private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

  @PostMapping(value = CommonRestEndpoints.PRODUCT_API)
  public ResponseEntity<BaseResponse> createProduct(
      @RequestBody CommonRequest<ProductRequestDto> productRequestDto) {
    if (productService.isProductNameExists(productRequestDto.getRequest().getName())) {
      return ResponseEntity.badRequest()
          .body(new BaseResponse(RequestStatus.FAILURE.getStatus(),
              messageBundle.getProductNameAlreadyExistCode(),
              messageBundle.getProductNameAlreadyExistMessage()));
    }
    logger.info("product createProduct(), Product: {" + productRequestDto.toString() + "}");
    productService.saveProduct(productRequestDto.getRequest());
    return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
        messageBundle.getCommonSuccessCode(), messageBundle.getSaveProductSuccessMessage()));
  }

  @PutMapping(value = CommonRestEndpoints.PRODUCT_API)
  public ResponseEntity<BaseResponse> updateProduct(
      @RequestBody CommonRequest<ProductRequestDto> productRequestDto) {
    if (productService.isProductExits(productRequestDto.getRequest().getId())) {
      if (!productService.isUpdateProductNameExists(productRequestDto.getRequest().getId(),
          productRequestDto.getRequest().getName())) {
        return ResponseEntity.badRequest()
            .body(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                messageBundle.getProductNameAlreadyExistCode(),
                messageBundle.getProductNameAlreadyExistMessage()));
      }
      logger.info("product updateProduct(), Product: {" + productRequestDto.toString() + "}");
      productService.updateProduct(productRequestDto.getRequest());
      return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
          messageBundle.getCommonSuccessCode(), messageBundle.getUpdateProductSuccessMessage()));
    }
    return ResponseEntity.badRequest().body(new BaseResponse(RequestStatus.FAILURE.getStatus(),
        messageBundle.getProductNotExistCode(), messageBundle.getProductNotExistMessage()));
  }

  @DeleteMapping(value = CommonRestEndpoints.PRODUCT_API_BY_ID)
  public ResponseEntity<BaseResponse> deleteProductById(@PathVariable Long id) {
    if (productService.isProductExits(id)) {
      if (productService.checkStatus(id)) {
        return ResponseEntity.badRequest()
            .body(new BaseResponse(RequestStatus.FAILURE.getStatus(),
                messageBundle.getProductStatusNotCorrectCode(),
                messageBundle.getProductStatusNotCorrectMessage()));
      }
      productService.deleteProduct(id);
      return ResponseEntity.ok(new BaseResponse(RequestStatus.SUCCESS.getStatus(),
          messageBundle.getCommonSuccessCode(), messageBundle.getDeleteProductSuccessMessage()));
    }
    return ResponseEntity.badRequest().body(new BaseResponse(RequestStatus.FAILURE.getStatus(),
        messageBundle.getProductNotExistCode(), messageBundle.getProductNotExistMessage()));
  }

  @GetMapping(value = CommonRestEndpoints.GET_PRODUCTS_API_BY_CATEGORYNAME)
  public ResponseEntity<Object> getProductsByProductCategoryName(
      @PathVariable String productCategoryName) {
    return ResponseEntity.ok(new ContentResponse<>("products",
        productService.getProductsByProductCategoryName(productCategoryName),
        RequestStatus.SUCCESS.getStatus(), messageBundle.getCommonSuccessCode(),
        messageBundle.getGetProductSuccessMessage()));
  }

  @GetMapping(value = CommonRestEndpoints.GET_PRODUCTS_API_BY_PRICE)
  public ResponseEntity<Object> getProductsByPrice() {
    return ResponseEntity.ok(new ContentResponse<>("products",
        productService.getProductsByProductPrice((double) 500), RequestStatus.SUCCESS.getStatus(),
        messageBundle.getCommonSuccessCode(), messageBundle.getGetProductSuccessMessage()));
  }
}
