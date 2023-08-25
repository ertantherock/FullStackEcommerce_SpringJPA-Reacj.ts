package com.ertankaya.springreactecommerceapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Carts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    private String userEmail;

    @ManyToMany
    private List<Product> products;

}