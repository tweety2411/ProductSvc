package com.heypli.productsvc.exception;

public class CommonException extends RuntimeException {
    private String message;

    public CommonException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
