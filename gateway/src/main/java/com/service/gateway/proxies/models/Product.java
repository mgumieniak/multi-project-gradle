package com.service.gateway.proxies.models;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String code;
    private String name;
    private String description;
    private double price;
    private boolean inStock = true;
}
