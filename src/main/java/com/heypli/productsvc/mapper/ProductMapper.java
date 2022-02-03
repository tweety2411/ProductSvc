package com.heypli.productsvc.mapper;

import com.heypli.productsvc.domain.request.ProductInfoRequest;
import com.heypli.productsvc.domain.response.ProductInfoResponse;
import com.heypli.productsvc.support.ProdDataBase;

import java.util.List;

@ProdDataBase
public interface ProductMapper {

    void insertProd(ProductInfoRequest param) throws Exception;

    List<ProductInfoResponse> selectProdList(ProductInfoRequest param) throws Exception;

    ProductInfoResponse selectProdInfo(ProductInfoRequest param) throws Exception;
}
