package com.microservice.category.service;

import com.microservice.category.entity.Category;
import com.microservice.category.http.response.ProductByCategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    boolean existsById(Long id);
    void deleteById(Long id);
    ProductByCategoryResponse findProductByCategoryId(Long courseId);
}
