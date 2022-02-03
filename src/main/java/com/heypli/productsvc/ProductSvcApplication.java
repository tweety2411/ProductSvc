package com.heypli.productsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
//@ConfigurationPropertiesScan("com.heypli.productsvc.config")
public class ProductSvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductSvcApplication.class);
    }
}
