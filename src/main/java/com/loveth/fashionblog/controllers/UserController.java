package com.loveth.fashionblog.controllers;

import antlr.collections.List;
import com.loveth.fashionblog.dto.LoginDto;
import com.loveth.fashionblog.dto.RegistrationDto;
import com.loveth.fashionblog.dto.UserDto;
import com.loveth.fashionblog.exception.InvalidRequestException;
import com.loveth.fashionblog.http.HttpResponseEntity;
import com.loveth.fashionblog.models.User;
import com.loveth.fashionblog.services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import static java.awt.Container.log;
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<HttpResponseEntity> createUser(@RequestBody UserDto userdto) {
        return new ResponseEntity<>(userServices.createUser(userdto),new HttpHeaders(), HttpStatus.CREATED);
    }

    // not working yet
    @GetMapping("/")
    @Cacheable(value = "userDetails")
    public List<User> getAllUsers(){
        return (List<User>) userServices.getAllUsers();
    }


    @PostMapping("/login")
    public User userLogin(@RequestBody LoginDto loginDto){
       User user = userServices.loginUser(loginDto.getEmail(), loginDto.getPassword());

       if( user == null){

           log.error("Invalid email/password");
       }else {
           log.info("User successfully logged in");
       }
       return user;
    }
//
//    @PutMapping("/editProfile/{id}")
//    public  User editUserProfile(@PathVariable long id, @RequestBody RegistrationDto registrationDto) throws InvalidRequestException {
//        return userServices.editUserProfile(id, registrationDto);
//
//    }

//    @DeleteMapping("/deleteAccount/{id}")
//    public  boolean deleteUserAccount(@PathVariable long id) throws InvalidRequestException, InterruptedException {
//        userServices.deleteUserAccount(new User());
//        return true;
//    }

}
