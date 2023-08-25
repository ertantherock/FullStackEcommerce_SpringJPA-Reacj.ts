package com.ertankaya.springreactecommerceapp.services;
import com.ertankaya.springreactecommerceapp.entities.Carts;
import com.ertankaya.springreactecommerceapp.repositories.CartsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartsService {

    final CartsRepository cartsRepository;

    public ResponseEntity add(Carts carts){
        try{
            cartsRepository.save(carts);
            return new ResponseEntity(carts, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity list(){
        List<Carts> ls = cartsRepository.findAll();
        return new ResponseEntity(ls,HttpStatus.OK);
    }

}
