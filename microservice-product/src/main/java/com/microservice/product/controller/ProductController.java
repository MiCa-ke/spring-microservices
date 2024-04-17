package com.microservice.product.controller;

import com.microservice.product.entities.Product;
import com.microservice.product.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody Product product){
        productService.save(product);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findById(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        if (productService.existsById(id)) {
            product.setId(id);
            productService.save(product);
            return ResponseEntity.ok("producto actualizado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria no encontrada");
        }
    }

    @GetMapping("/search-by-category/{categoryId}")
    public ResponseEntity<?> findByIdCategory(@PathVariable Long categoryId){
        return ResponseEntity.ok(productService.findByCategoryId(categoryId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}
