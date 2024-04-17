package com.microservice.category.service;

import com.microservice.category.client.ProductClient;
import com.microservice.category.controller.sto.ProductDTO;
import com.microservice.category.entity.Category;
import com.microservice.category.http.response.ProductByCategoryResponse;
import com.microservice.category.persistence.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Builder;

import java.util.List;

@Builder
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean existsById(Long id) {
        return categoryRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public ProductByCategoryResponse findProductByCategoryId(Long categoryId) {

        // Consultar si existe la categoria
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        // Obtener los productos
        List<ProductDTO> productDTOList = productClient.findAllProductByCategory(category.getId());

        return ProductByCategoryResponse.builder()
                .name(category.getName())
                .descripcion(category.getDescripcion())
                .productDTOList(productDTOList)
                .build();
    }
}
