package com.efuture.product.service;

import java.util.List;
import com.efuture.product.request.dto.ProductRequestDto;
import com.efuture.product.response.dto.ProductResposeDto;

public interface ProductService {

  public void saveProduct(ProductRequestDto productRequestDto);

  public void updateProduct(ProductRequestDto productRequestDto);

  public boolean isProductNameExists(String name);

  public boolean isProductExits(Long id);

  public boolean isUpdateProductNameExists(Long id, String name);

  public void deleteProduct(Long id);

  public boolean checkStatus(Long id);

  public List<ProductResposeDto> getProductsByProductCategoryName(String productCategoryName);

  public List<ProductResposeDto> getProductsByProductPrice(Double price);


}
