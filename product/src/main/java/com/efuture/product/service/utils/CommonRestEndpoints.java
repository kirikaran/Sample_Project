package com.efuture.product.service.utils;

public final class CommonRestEndpoints {

  public static final String SERVER_BASE_URL = "/api/v1/";

  public static final String PRODUCT_API = SERVER_BASE_URL + "product";

  public static final String PRODUCT_API_BY_ID = SERVER_BASE_URL + "product" + "/{id}";

  public static final String GET_PRODUCTS_API_BY_CATEGORYNAME =
      SERVER_BASE_URL + "product" + "/category" + "/{productCategoryName}";

  public static final String GET_PRODUCTS_API_BY_PRICE = SERVER_BASE_URL + "product" + "/price";
}
