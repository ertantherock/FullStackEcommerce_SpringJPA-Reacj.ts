package com.ertankaya.springreactecommerceapp.restcontrollers;

import com.ertankaya.springreactecommerceapp.entities.Carts;
import com.ertankaya.springreactecommerceapp.services.CartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")
public class CartsRestController {

    final CartsService cartsService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Carts carts){
        return cartsService.add(carts);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return cartsService.list();
    }

}