package com.ertankaya.springreactecommerceapp.entities;
import lombok.Data;


import javax.persistence.*;
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    private String name;
}