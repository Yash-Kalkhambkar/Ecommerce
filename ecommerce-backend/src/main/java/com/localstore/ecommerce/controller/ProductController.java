package com.localstore.ecommerce.controller;

import com.localstore.ecommerce.entity.Product;
import com.localstore.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAllProducts(@RequestParam(required = false) String category,
                                       @RequestParam(required = false) String search) {
        if (category != null || search != null) {
            return productService.searchProducts(category, search);
        }
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/categories")
    public List<String> getCategories() {
        return productService.getAllCategories();
    }
}