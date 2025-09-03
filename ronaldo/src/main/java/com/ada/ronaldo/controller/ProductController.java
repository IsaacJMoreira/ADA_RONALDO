package com.ada.ronaldo.controller;

import com.ada.ronaldo.domain.product.Product;
import com.ada.ronaldo.domain.product.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ada.ronaldo.service.ProductService;

import java.util.List;

//import java.util.UUID;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProducts = this.productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProductByID(@PathVariable Integer id){
        Product oneProduct = this.productService.getProductByID(id);
        return ResponseEntity.ok(oneProduct);
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO data){
        Product newProduct = this.productService.createProduct(data);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductByID(@PathVariable Integer id, @RequestBody ProductRequestDTO data){
        Product editedProduct = this.productService.editProductByID(id, data);
        return ResponseEntity.ok(editedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductByID(@PathVariable Integer id){
        boolean Status = this.productService.deleteProductByID(id);
        if(Status){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
