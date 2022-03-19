package com.efuture.product.response;

public class BaseResponse {

  private String status;
  private String statusCode;
  private String message;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public BaseResponse(String status, String statusCode, String message) {
    this.status = status;
    this.statusCode = statusCode;
    this.message = message;
  }
}
