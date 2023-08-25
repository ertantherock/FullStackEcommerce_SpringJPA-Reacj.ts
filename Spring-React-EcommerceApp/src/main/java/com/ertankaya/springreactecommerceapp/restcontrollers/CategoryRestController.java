package com.ertankaya.springreactecommerceapp.restcontrollers;
import com.ertankaya.springreactecommerceapp.entities.Category;
import com.ertankaya.springreactecommerceapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryRestController {

    final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Category category){
        return categoryService.save(category);
    }

    @GetMapping("/delete/{cid}")
    public ResponseEntity delete( @PathVariable Long cid){
        return categoryService.delete(cid);
    }

    @PostMapping("/update")
    public ResponseEntity update (@RequestBody Category category){
        return categoryService.update(category);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return categoryService.list();
    }

}
