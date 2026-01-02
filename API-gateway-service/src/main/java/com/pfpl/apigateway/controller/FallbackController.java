package com.pfpl.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FallbackController {

	@GetMapping("/fallback/auth")
	public Mono<Map<String, String>> authServiceFallback() {
		Map<String, String> response = new HashMap<>();
		response.put("message", "Auth Service is temporarily unavailable");
		response.put("status", "503");
		return Mono.just(response);
	}

	@GetMapping("/public")
	public String gatewayavailable() {

		return "Gateway service available";
	}

	@GetMapping("/fallback/product")
	public Mono<Map<String, String>> productServiceFallback() {
		Map<String, String> response = new HashMap<>();
		response.put("message", "Product Service is temporarily unavailable");
		response.put("status", "503");
		return Mono.just(response);
	}

	@GetMapping("/fallback/order")
	public Mono<Map<String, String>> orderServiceFallback() {
		Map<String, String> response = new HashMap<>();
		response.put("message", "Order Service is temporarily unavailable");
		response.put("status", "503");
		return Mono.just(response);
	}
}
