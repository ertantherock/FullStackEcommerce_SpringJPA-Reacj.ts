package com.ertankaya.springreactecommerceapp.repositories;

import com.ertankaya.springreactecommerceapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}