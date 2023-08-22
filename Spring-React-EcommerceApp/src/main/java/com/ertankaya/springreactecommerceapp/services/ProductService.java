package com.ertankaya.springreactecommerceapp.services;

import com.ertankaya.springreactecommerceapp.configs.Rest;
import com.ertankaya.springreactecommerceapp.entities.Product;
import com.ertankaya.springreactecommerceapp.entities.ProductCategory;
import com.ertankaya.springreactecommerceapp.entities.projections.IProduct;
import com.ertankaya.springreactecommerceapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public ResponseEntity saveProduct(Product product){
        try {
            Optional<Product> optionalProduct = productRepository.findByNameEquals(product.getProductName());
            if (optionalProduct.isPresent()){
                return new ResponseEntity<>(product.getProductName() + "This is used", HttpStatus.BAD_REQUEST);

            }else {
                productRepository.save(product);
                return new ResponseEntity<>("Success", HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity productList(){
        List<IProduct> carlist = productRepository.getProductsBy("Car",5);
        List<IProduct> homelist = productRepository.getProductsBy("Home",5);
        List<IProduct> electroniclist = productRepository.getProductsBy("Electronic",5);
        List<IProduct> kitchenlist = productRepository.getProductsBy("Kitchen",5);
        List<IProduct> dresslist = productRepository.getProductsBy("Dress",5);
        List<IProduct> shoeslist = productRepository.getProductsBy("Shoes",5);
        List<IProduct> foodlist = productRepository.getProductsBy("Food",5);
        Map hm = new LinkedHashMap();
        hm.put("Car",carlist);
        hm.put("Home",homelist);
        hm.put("Electronic",electroniclist);
        hm.put("Kitchen",kitchenlist);
        hm.put("Dress",dresslist);
        hm.put("Shoes",shoeslist);
        hm.put("Food",foodlist);
        return new ResponseEntity(hm,HttpStatus.OK);
    }

    public ResponseEntity allProductList(){
        List<IProduct> ls = productRepository.getProductsAllBy();
        Rest rest = new Rest(ls);
        return new ResponseEntity(rest,HttpStatus.OK);
    }

    public  boolean deleteProduct(Long pid){
        try {
            productRepository.deleteById(pid);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public Product updateProduct( Product product){
        Optional<Product> optionalProduct = productRepository.findById(product.getPid());
        if (optionalProduct.isPresent()){
            productRepository.saveAndFlush(product);
            return product;
        }
        return null;
    }

}
