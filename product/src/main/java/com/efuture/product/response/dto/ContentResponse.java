package com.efuture.product.response.dto;

import java.util.HashMap;
import java.util.Map;
import com.efuture.product.response.BaseResponse;

public class ContentResponse<T> extends BaseResponse {
  private Map<String, T> result = new HashMap<>();

  public ContentResponse(String key, T dto, String status, String statusCode, String message) {
    super(status, statusCode, message);
    result.put(key, dto);
  }

  public Map<String, T> getResult() {
    return result;
  }

  public void setResult(Map<String, T> result) {
    this.result = result;
  }

}
