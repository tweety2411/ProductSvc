package com.heypli.productsvc.controller;

import com.heypli.productsvc.common.response.CommonDataResponse;
import com.heypli.productsvc.common.response.CommonListResponse;
import com.heypli.productsvc.common.response.CommonResponse;
import com.heypli.productsvc.domain.request.ProductInfoRequest;
import com.heypli.productsvc.domain.response.ProductInfoResponse;
import com.heypli.productsvc.exception.ProductNotFoundException;
import com.heypli.productsvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/prod")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/test")
    public String test(@RequestParam(required = false)String id) {
        if(id.equals("ex")) {
            throw new ProductNotFoundException();
        }
        return "test";
    }

    /**
     * 상품 등록
     *
     * @param param
     * @return
     */
    @PostMapping("/createProd")
    public ResponseEntity<CommonResponse> createProd(@RequestBody ProductInfoRequest param) throws Exception {

        CommonResponse res = productService.createProd(param);

        return new ResponseEntity(res, HttpStatus.OK);
    }

    @PostMapping("/getProdList")
    public ResponseEntity<CommonListResponse<ProductInfoResponse>> getProdList(@RequestBody ProductInfoRequest param) throws Exception {

        CommonListResponse<ProductInfoResponse> result = productService.getProdList(param);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/getProdInfo")
    public ResponseEntity<CommonDataResponse<ProductInfoResponse>> getProdInfo(@Valid @RequestBody ProductInfoRequest param) throws Exception {

        CommonDataResponse<ProductInfoResponse> result = productService.getProdInfo(param);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
