package com.microservice.category.client;

import com.microservice.category.controller.sto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-product", url = "localhost:8090")
public interface ProductClient {
    /** DTO=Objeto de tranferencia de datos */
    @GetMapping("/api/product/search-by-category/{categoryId}")
    List<ProductDTO> findAllProductByCategory(@PathVariable Long categoryId);
}
