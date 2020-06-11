package com.spring.product_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("order-service")
public interface OrderClients {
    @GetMapping("/api/orders")
    String getOrders();
}
