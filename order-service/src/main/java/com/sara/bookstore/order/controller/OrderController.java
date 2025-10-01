package com.sara.bookstore.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RestTemplate restTemplate;
    private final String bookServiceUrl;
    private final String notificationServiceUrl;

    public OrderController(RestTemplate restTemplate,
                           @Value("${book.service.url}") String bookServiceUrl,
                           @Value("${notification.service.url}") String notificationServiceUrl) {
        this.restTemplate = restTemplate;
        this.bookServiceUrl = bookServiceUrl;
        this.notificationServiceUrl = notificationServiceUrl;
    }

    @GetMapping("/place/{bookId}")
    public String placeOrder(@PathVariable String bookId) {
        // Call Book Service
        String bookResponse = restTemplate.getForObject(bookServiceUrl + "/" + bookId, String.class);

        // Call Notification Service
        restTemplate.postForObject(notificationServiceUrl + "/send",
                "Order placed for: " + bookResponse, String.class);

        return "Order placed for: " + bookResponse;
    }
}
