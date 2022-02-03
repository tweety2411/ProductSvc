package com.heypli.productsvc.exception;

public class ProductNotFoundException extends RuntimeException {

    private String message;

    public ProductNotFoundException() {
        this.message = "Product Not Found.";
    }

    public String getMessage() {
        return message;
    }
}
