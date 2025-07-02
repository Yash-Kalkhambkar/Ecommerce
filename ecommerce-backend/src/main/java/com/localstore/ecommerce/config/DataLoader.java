package com.localstore.ecommerce.config;

import com.localstore.ecommerce.entity.Product;
import com.localstore.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            loadSampleData();
        }
    }
    
    private void loadSampleData() {
        productRepository.save(new Product("iPhone 14", "Latest Apple smartphone with advanced features", 
            new BigDecimal("999.99"), 25, "https://images.unsplash.com/photo-1592750475338-74b7b21085ab?w=400", "Electronics"));
            
        productRepository.save(new Product("Samsung Galaxy S23", "Premium Android smartphone", 
            new BigDecimal("899.99"), 30, "https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?w=400", "Electronics"));
            
        productRepository.save(new Product("MacBook Pro", "Professional laptop for work and creativity", 
            new BigDecimal("1999.99"), 15, "https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=400", "Electronics"));
            
        productRepository.save(new Product("Nike Air Max", "Comfortable running shoes", 
            new BigDecimal("129.99"), 50, "https://images.unsplash.com/photo-1549298916-b41d501d3772?w=400", "Footwear"));
            
        productRepository.save(new Product("Adidas Ultraboost", "High-performance athletic shoes", 
            new BigDecimal("149.99"), 40, "https://images.unsplash.com/photo-1608231387042-66d1773070a5?w=400", "Footwear"));
            
        productRepository.save(new Product("Levi's Jeans", "Classic denim jeans", 
            new BigDecimal("79.99"), 60, "https://images.unsplash.com/photo-1542272604-787c3835535d?w=400", "Clothing"));
            
        productRepository.save(new Product("Cotton T-Shirt", "Comfortable everyday wear", 
            new BigDecimal("19.99"), 100, "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=400", "Clothing"));
            
        productRepository.save(new Product("Wireless Headphones", "High-quality audio experience", 
            new BigDecimal("199.99"), 35, "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400", "Electronics"));
            
        productRepository.save(new Product("Coffee Maker", "Brew perfect coffee at home", 
            new BigDecimal("89.99"), 20, "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?w=400", "Appliances"));
            
        productRepository.save(new Product("Backpack", "Durable travel and work backpack", 
            new BigDecimal("59.99"), 45, "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=400", "Accessories"));
    }
}