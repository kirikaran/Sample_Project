package com.efuture.product.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.efuture.product.entities.ProductComment;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {

  boolean existsByProductId(Long productId);

  List<ProductComment> findByProductId(Long productId);

}
