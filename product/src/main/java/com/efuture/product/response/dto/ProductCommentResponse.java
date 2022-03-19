package com.efuture.product.response.dto;

import java.sql.Timestamp;

public class ProductCommentResponse {

  private String comment;
  private Timestamp createdAt;
  private Timestamp updatedAt;

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp timestamp) {
    this.createdAt = timestamp;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
}
