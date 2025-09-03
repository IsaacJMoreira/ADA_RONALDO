package com.ada.ronaldo.service;

import com.ada.ronaldo.domain.product.Product;
import com.ada.ronaldo.domain.product.ProductRequestDTO;
import com.ada.ronaldo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductByID(Integer id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product createProduct(ProductRequestDTO data){
        Product product = new Product();
        product.setName(data.name());

        return productRepository.save(product);
    }

    public Product editProductByID(Integer id, ProductRequestDTO data){
        Optional<Product> existing = productRepository.findById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        Product product = existing.get();
        product.setName(data.name());

        return productRepository.save(product);
    }

    public boolean deleteProductByID(Integer id){
        if(!productRepository.existsById(id)){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

}
