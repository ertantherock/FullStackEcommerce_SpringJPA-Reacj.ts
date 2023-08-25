package com.ertankaya.springreactecommerceapp.repositories;

import com.ertankaya.springreactecommerceapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailEqualsIgnoreCase(String email);
}