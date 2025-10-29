package com.pfpl.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRouting {
	  @Bean
	    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
	       return builder.routes()
	      .route("paymentId", r->r.path("/payment/**").uri("lb://sales-service")) //static routing
	      .route("orderId", r->r.path("/order/**").uri("lb://ORDER-SERVICE")) //dynamic routing
	      .build();
	    }
}
