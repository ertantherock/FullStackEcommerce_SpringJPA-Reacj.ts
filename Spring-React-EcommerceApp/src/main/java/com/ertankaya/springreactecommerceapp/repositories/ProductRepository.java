package com.ertankaya.springreactecommerceapp.repositories;

import com.ertankaya.springreactecommerceapp.entities.Product;
import com.ertankaya.springreactecommerceapp.entities.projections.IProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNameEquals(String productName);


    @Query(value = "select p.productName,p.detail,p.price, c.cname from category c inner join product p on c.cid = p.cid where c.cname = ?1 order by p.price asc limit ?2", nativeQuery = true)
    List<IProduct> getProductsBy(String cname, int limit);

    @Query(value = "select p.productName,p.detail,p.price, c.categoryName,pi.text,pi.pid from category c inner join product p on c.cid = p.cid inner join product_image pi on p.pid = pi.pid", nativeQuery = true)
    List<IProduct> getProductsAllBy();
}