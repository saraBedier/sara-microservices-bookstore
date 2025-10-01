package com.sara.bookstore.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/gateway/hello")
    public String hello() {
        return "Hello from API Gateway!";
    }
}
