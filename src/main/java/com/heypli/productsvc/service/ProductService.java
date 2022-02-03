package com.heypli.productsvc.service;

import com.heypli.productsvc.common.response.CommonDataResponse;
import com.heypli.productsvc.common.response.CommonListResponse;
import com.heypli.productsvc.common.response.CommonResponse;
import com.heypli.productsvc.domain.request.ProductInfoRequest;
import com.heypli.productsvc.domain.response.ProductInfoResponse;

public interface ProductService {

    CommonResponse createProd(ProductInfoRequest param) throws Exception;

    CommonListResponse<ProductInfoResponse> getProdList(ProductInfoRequest param) throws Exception;

    CommonDataResponse<ProductInfoResponse> getProdInfo(ProductInfoRequest param) throws Exception;
}
