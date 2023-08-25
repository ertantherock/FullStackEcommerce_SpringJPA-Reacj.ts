package com.ertankaya.springreactecommerceapp.entities;

import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Size(min = 2, max = 150)
    @NotEmpty
    @NotNull
    private String name;

    @Size(min = 2, max = 150)
    @NotEmpty
    @NotNull
    private String surname;

    @Max(120)
    @Column(nullable = false)
    @Min(15)
    private int age;

    @Size(min = 5, max = 150)
    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String email;

    @Size(min = 5, max = 150)
    @NotEmpty
    @NotNull
    private String password;


    @ManyToMany
    private List<Role> roles;
}