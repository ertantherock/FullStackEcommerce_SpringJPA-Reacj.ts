package com.ertankaya.springreactecommerceapp.entities;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private Long pid;

    private String text;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] image;
}
