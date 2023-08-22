package com.ertankaya.springreactecommerceapp.services;

import com.ertankaya.springreactecommerceapp.entities.ProductCategory;
import com.ertankaya.springreactecommerceapp.repositories.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    final ProductCategoryRepository productCategoryRepository;

    public ResponseEntity categorySave(ProductCategory productCategory){
        try {
            Optional<ProductCategory> optCategory = productCategoryRepository.findByCategoryNameEqualsIgnoreCase(productCategory.getCategoryName());

            if (optCategory.isPresent()){
                return new ResponseEntity<>(productCategory.getCategoryName() + " Category Already Exist " , HttpStatus.BAD_REQUEST );
            }else {
                productCategoryRepository.save(productCategory);
                return new ResponseEntity<>("Success", HttpStatus.OK);
            }
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public boolean categoryDelete(Long cid){
        try {
            productCategoryRepository.deleteById(cid);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    public ProductCategory update(ProductCategory productCategory){
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findById(productCategory.getCid());
        if (optionalProductCategory.isPresent()){
            productCategoryRepository.saveAndFlush(productCategory);
            return productCategory;
        }
        return null;
    }
}
