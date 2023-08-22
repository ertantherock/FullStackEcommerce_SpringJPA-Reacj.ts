package com.ertankaya.springreactecommerceapp.restcontrollers;

import com.ertankaya.springreactecommerceapp.entities.ProductCategory;
import com.ertankaya.springreactecommerceapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class CategoryRestController {

    final CategoryService categoryService;

    @PostMapping("/productSave")
    public ResponseEntity productSave( @RequestBody ProductCategory productCategory){
        return categoryService.categorySave(productCategory);

    }

    @GetMapping("/productDelete/{cid}")
    public boolean productDelete(@PathVariable Long cid){
        return categoryService.categoryDelete(cid);
    }

    @PostMapping("/updateProduct")
    public ProductCategory productUpdate(@RequestBody ProductCategory productCategory) {
        return categoryService.update(productCategory);
    }

}
