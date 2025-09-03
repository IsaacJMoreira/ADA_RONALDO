package com.ada.ronaldo.repository;

import com.ada.ronaldo.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository <Product, Integer> {
}
