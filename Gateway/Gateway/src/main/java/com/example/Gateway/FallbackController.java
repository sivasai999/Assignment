package com.example.Gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/orderFallback")
    public String orderFallback() {
        return "Order Service is temporarily unavailable.";
    }

    @GetMapping("/userFallback")
    public String userFallback() {
        return "User Service is temporarily unavailable.";
    }

    @GetMapping("/productFallback")
    public String productFallback() {
        return "Product Service is temporarily unavailable.";
    }
}
