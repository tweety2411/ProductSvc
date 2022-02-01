package com.heypli.productsvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prod")
public class ProductController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
