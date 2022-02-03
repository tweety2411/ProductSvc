package com.heypli.productsvc.service.impl;

import com.heypli.productsvc.common.response.CommonDataResponse;
import com.heypli.productsvc.common.response.CommonListResponse;
import com.heypli.productsvc.common.response.CommonResponse;
import com.heypli.productsvc.domain.request.ProductInfoRequest;
import com.heypli.productsvc.domain.response.ProductInfoResponse;
import com.heypli.productsvc.exception.CommonException;
import com.heypli.productsvc.mapper.ProductMapper;
import com.heypli.productsvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public CommonResponse createProd(ProductInfoRequest param) throws Exception {
        productMapper.insertProd(param);
        return CommonResponse.success();
    }

    @Override
    public CommonListResponse<ProductInfoResponse> getProdList(ProductInfoRequest param) throws Exception {
        List<ProductInfoResponse> list;
        try {

            list = productMapper.selectProdList(param);
        } catch (Exception e) {
            throw new CommonException(e.getMessage());
        }

        return new CommonListResponse<>(list);
    }

    @Override
    public CommonDataResponse<ProductInfoResponse> getProdInfo(ProductInfoRequest param) throws Exception {

        ProductInfoResponse result = productMapper.selectProdInfo(param);

        return new CommonDataResponse<ProductInfoResponse>(result);
    }
}
