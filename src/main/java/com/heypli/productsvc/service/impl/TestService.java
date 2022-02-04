package com.heypli.productsvc.service.impl;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String test() {
        return "hi";
    }

    public String fail() throws InterruptedException {
        Thread.sleep(5000);
        return "timeout";
    }


}
