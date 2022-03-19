package com.efuture.product.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.efuture.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  boolean existsByNameIgnoreCase(String name);

  boolean existsByIdAndNameIgnoreCase(Long id, String name);

  List<Product> findByProductCategoryNameIgnoreCase(String productCategoryName);

  List<Product> findByPriceGreaterThanEqual(Double price);
}
