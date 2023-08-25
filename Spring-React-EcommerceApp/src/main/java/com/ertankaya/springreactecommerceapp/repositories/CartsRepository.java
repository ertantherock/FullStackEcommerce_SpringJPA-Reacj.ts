package com.ertankaya.springreactecommerceapp.repositories;

import com.ertankaya.springreactecommerceapp.entities.Carts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartsRepository extends JpaRepository<Carts, Long> {
}