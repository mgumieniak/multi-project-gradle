package com.service.gateway.proxies;

import com.service.gateway.proxies.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final WebClient client;

    public ProductService(WebClient client) {
        this.client = client;
    }


    public Mono<Product> getAllProducts(){
        Mono<ClientResponse> response = client.get()
                .uri("lb://product-service" + "/api/products")
                .exchange();
        return response.flatMap(resp -> {
            switch (resp.statusCode()) {
                case OK:
                    return resp.bodyToMono(Product.class);
                case NOT_FOUND:
                    return Mono.error(new OrderNotFoundException());
                default:
                    return Mono.error(new RuntimeException("Unknown" + resp.statusCode()));
            }
        });
    }
}
