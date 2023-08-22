package com.ertankaya.springreactecommerceapp.services;

import com.ertankaya.springreactecommerceapp.entities.Admin;
import com.ertankaya.springreactecommerceapp.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    final AdminRepository adminRepository;

    public ResponseEntity adminLogin(Admin admin) {
        Optional<Admin> optionalAdmin = adminRepository.findByEmailEqualsIgnoreCaseAndPasswordEqualsIgnoreCase(admin.getEmail(), admin.getPassword());

        if (optionalAdmin.isPresent()){
            return new ResponseEntity<>("success", HttpStatus.OK);

        }else {
            return new ResponseEntity<>("Mail or Password is not matched", HttpStatus.BAD_REQUEST);

        }
    }
}
