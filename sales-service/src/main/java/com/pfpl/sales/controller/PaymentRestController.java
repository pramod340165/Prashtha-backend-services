package com.pfpl.sales.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class PaymentRestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/info")
    public ResponseEntity<String> showPaymentInfo() {
       return ResponseEntity.ok("FROM PAYMENT SERVICE, Port# is: " + port);
    }
    @PostMapping
    public String createOrder(@RequestHeader("Authorization") String token) {
        return "Order placed successfully";
    }

    @GetMapping
    public String orderHistory() {
        return "Order history";
    }
}