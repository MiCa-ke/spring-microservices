package com.microservice.category.controller;

import com.microservice.category.entity.Category;
import com.microservice.category.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCategory(@RequestBody Category category){
        categoryService.save(category);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findById(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        if (categoryService.existsById(id)) {
            category.setId(id);
            categoryService.save(category);
            return ResponseEntity.ok("Categoría actualizada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría no encontrada");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok("Categoría eliminada correctamente");
    }

    @GetMapping("/search-product/{categoryId}")
    public ResponseEntity<?> findProductbyCategoryId(@PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.findProductByCategoryId(categoryId));
    }
}
