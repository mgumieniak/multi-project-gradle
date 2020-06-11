package com.order.orderservice.web.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("api/orders")
public class OrderController {

    @GetMapping
    public String getOrders(){
        log.info("Get orders");
        return "sth";
    }
}
