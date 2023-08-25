package com.ertankaya.springreactecommerceapp.restcontrollers;

import com.ertankaya.springreactecommerceapp.entities.User;
import com.ertankaya.springreactecommerceapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {

    final UserService userService;
    final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody User user){

        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody User user) throws Exception {
        Authentication authentication;
        try{
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (BadCredentialsException ex){
            throw new Exception("Invalid credentials");
        }

        return new ResponseEntity(user,HttpStatus.OK);
    }


}