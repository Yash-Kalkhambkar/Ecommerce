package com.localstore.ecommerce.service;

import com.localstore.ecommerce.entity.CartItem;
import com.localstore.ecommerce.entity.Product;
import com.localstore.ecommerce.repository.CartItemRepository;
import com.localstore.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    
    @Autowired
    private CartItemRepository cartItemRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<CartItem> getCartItems(String sessionId) {
        return cartItemRepository.findBySessionId(sessionId);
    }
    
    @Transactional
    public CartItem addToCart(String sessionId, Long productId, Integer quantity) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        
        Product product = productOpt.get();
        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        
        Optional<CartItem> existingItem = cartItemRepository.findBySessionIdAndProductId(sessionId, productId);
        
        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            return cartItemRepository.save(item);
        } else {
            CartItem newItem = new CartItem(productId, product.getName(), product.getPrice(), quantity, sessionId);
            return cartItemRepository.save(newItem);
        }
    }
    
    public CartItem updateCartItem(Long itemId, Integer quantity) {
        Optional<CartItem> itemOpt = cartItemRepository.findById(itemId);
        if (itemOpt.isEmpty()) {
            throw new RuntimeException("Cart item not found");
        }
        
        CartItem item = itemOpt.get();
        item.setQuantity(quantity);
        return cartItemRepository.save(item);
    }
    
    public void removeFromCart(Long itemId) {
        cartItemRepository.deleteById(itemId);
    }
    
    @Transactional
    public void clearCart(String sessionId) {
        cartItemRepository.deleteBySessionId(sessionId);
    }
}