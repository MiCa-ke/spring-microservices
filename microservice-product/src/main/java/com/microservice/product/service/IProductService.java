package com.microservice.product.service;

import com.microservice.product.entities.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    boolean existsById(Long id);
    List<Product> findByCategoryId(Long courseId);
    void deleteById(Long id);
}
