package com.efuture.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.efuture.product.entities.ProductCategory;

public interface ProductCatagoryRepository extends JpaRepository<ProductCategory, Long> {

}
