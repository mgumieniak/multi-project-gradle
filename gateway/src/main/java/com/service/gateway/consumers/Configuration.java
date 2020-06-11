package com.service.gateway.consumers;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public RouteLocator consumerProxyRouting(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/products")
                        .and()
                        .method("GET")
                        .uri("lb://product-service"))
                .build();
    }
}
