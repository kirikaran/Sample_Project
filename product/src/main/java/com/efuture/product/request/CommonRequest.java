package com.efuture.product.request;

public class CommonRequest<T> {
  private T request;

  public T getRequest() {
    return request;
  }

  public void setRequest(T request) {
    this.request = request;
  }
}
