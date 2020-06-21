package com.spring.product_service.web.api;

import com.spring.product_service.clients.OrderClients;
import com.spring.product_service.entities.Product;
import com.spring.product_service.exceptions.ProductNotFoundException;
import com.spring.product_service.services.ProductService;
import library.common.Library;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final OrderClients orderClients;

    @Autowired
    public ProductController(ProductService productService, OrderClients orderClients) {
        this.productService = productService;
        this.orderClients = orderClients;
    }

    @GetMapping("")
//    @HystrixCommand(commandKey = "products",fallbackMethod = "allProductsDefault")
    public List<Product> allProducts(HttpServletRequest request) {
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info(orderClients.getOrders());
        log.info("Finding all products");
        Library library = new Library();
        String auth_header = request.getHeader("AUTH_HEADER");
        log.info("AUTH_HEADER: " + auth_header);
        return productService.findAllProducts();
    }

//    public List<Product> allProductsDefault(HttpServletRequest request) {
//        log.error("Client wasn't available!");
//        return new ArrayList<>();
//    }

    @GetMapping("/{code}")
    public Product productByCode(@PathVariable String code) {
        log.info("Finding product by code :" + code);
        return productService.findProductByCode(code)
                .orElseThrow(() -> new ProductNotFoundException("Product with code [" + code + "] doesn't exist"));
    }
}
