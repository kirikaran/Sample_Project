package com.efuture.product.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.efuture.product.entities.Product;
import com.efuture.product.repositories.ProductCatagoryRepository;
import com.efuture.product.repositories.ProductCommentRepository;
import com.efuture.product.repositories.ProductRepository;
import com.efuture.product.request.dto.ProductRequestDto;
import com.efuture.product.response.dto.ProductCommentResponse;
import com.efuture.product.response.dto.ProductResposeDto;
import com.efuture.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductCatagoryRepository productCatagoryRepository;

  @Autowired
  private ProductCommentRepository productCommentRepository;

  @Transactional
  public void saveProduct(ProductRequestDto productRequestDto) {
    Product product = new Product();
    BeanUtils.copyProperties(productRequestDto, product);
    product.setLaunchDate(productRequestDto.getLaunchDate());
    product.setName(productRequestDto.getName());
    product.setDescription(productRequestDto.getDescription());
    product.setPrice(productRequestDto.getPrice());
    product.setStatus(productRequestDto.getStatus());
    product.setProductCategory(
        productCatagoryRepository.getById(productRequestDto.getProductCategoryId()));
    productRepository.save(product);
  }

  @Transactional(readOnly = true)
  public boolean isProductNameExists(String name) {
    return productRepository.existsByNameIgnoreCase(name);
  }

  @Transactional(readOnly = true)
  public boolean isUpdateProductNameExists(Long id, String name) {
    return productRepository.existsByIdAndNameIgnoreCase(id, name);
  }

  @Transactional
  public void updateProduct(ProductRequestDto productRequestDto) {
    Product product = productRepository.getById(productRequestDto.getId());
    BeanUtils.copyProperties(productRequestDto, product);
    product.setLaunchDate(productRequestDto.getLaunchDate());
    product.setName(productRequestDto.getName());
    product.setDescription(productRequestDto.getDescription());
    product.setPrice(productRequestDto.getPrice());
    product.setStatus(productRequestDto.getStatus());
    product.setProductCategory(
        productCatagoryRepository.getById(productRequestDto.getProductCategoryId()));
    productRepository.save(product);
  }

  @Transactional(readOnly = true)
  public boolean isProductExits(Long id) {
    return productRepository.existsById(id);
  }

  @Transactional
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  @Transactional(readOnly = true)
  public boolean checkStatus(Long id) {
    if (productRepository.getById(id).getStatus() == 'D') {
      return false;
    }
    return true;
  }

  @Transactional(readOnly = true)
  public List<ProductResposeDto> getProductsByProductCategoryName(String productCategoryName) {
    return setProductsDatas(
        productRepository.findByProductCategoryNameIgnoreCase(productCategoryName));
  }

  private List<ProductResposeDto> setProductsDatas(List<Product> productList) {
    List<ProductResposeDto> productResposeDtoList = new ArrayList<>();
    productList.forEach(products -> {
      ProductResposeDto productResposeDto = new ProductResposeDto();
      productResposeDto.setProductName(products.getName());
      productResposeDto.setPrice(products.getPrice());
      productResposeDto.setProductDescription(products.getDescription());
      productResposeDto.setStatus(products.getStatus());
      List<ProductCommentResponse> productCommentResponseList = new ArrayList<>();
      if (productCommentRepository.existsByProductId(products.getId())) {
        productCommentRepository.findByProductId(products.getId()).forEach(productComments -> {
          ProductCommentResponse productCommentResponseDto = new ProductCommentResponse();
          productCommentResponseDto.setComment(productComments.getComment());
          productCommentResponseDto.setCreatedAt(productComments.getCreatedAt());
          productCommentResponseDto.setUpdatedAt(productComments.getUpdatedAt());
          productCommentResponseList.add(productCommentResponseDto);
        });
      }
      productResposeDto.setProductComments(productCommentResponseList);
      productResposeDtoList.add(productResposeDto);
    });
    return productResposeDtoList;
  }


  @Transactional(readOnly = true)
  public List<ProductResposeDto> getProductsByProductPrice(Double price) {
    return setProductsDatas(productRepository.findByPriceGreaterThanEqual(price));
  }
}
