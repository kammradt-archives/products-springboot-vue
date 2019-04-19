package com.kammradt.apirest.repository;

import com.kammradt.apirest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);
}
