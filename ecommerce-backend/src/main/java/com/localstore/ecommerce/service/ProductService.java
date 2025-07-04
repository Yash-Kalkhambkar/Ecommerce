package com.localstore.ecommerce.service;

import com.localstore.ecommerce.entity.Product;
import com.localstore.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
    
    public List<String> getAllCategories() {
        return productRepository.findDistinctCategories();
    }
    
    public List<Product> searchProducts(String category, String name) {
        return productRepository.findProductsWithFilters(category, name);
    }
    
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}