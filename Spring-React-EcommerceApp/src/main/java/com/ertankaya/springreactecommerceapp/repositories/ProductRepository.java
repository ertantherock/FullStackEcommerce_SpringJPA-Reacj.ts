package com.ertankaya.springreactecommerceapp.repositories;

import com.ertankaya.springreactecommerceapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategories_NameEquals(String name);
}