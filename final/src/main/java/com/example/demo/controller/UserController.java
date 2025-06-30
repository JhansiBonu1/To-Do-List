package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
 //import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:5173",allowCredentials = "true")
@RequestMapping("/api/user")

public class UserController {
    
   @Autowired
   UserService uservice;

    @PostMapping("/register")
    ResponseEntity<?> r1(@RequestBody Users user)
    {
        
      String resp=uservice.registerUser(user);
      if(resp.equals("User registered successfully"))
      {
         // return ResponseEntity.ok("User registered successfully");
         return ResponseEntity.status(HttpStatus.CREATED).body("User Registered successfully");
      }
      return ResponseEntity.status(HttpStatus.CONFLICT).body("email already exists");

    }

    @PostMapping("/login")
    ResponseEntity<?> l1(@RequestBody Users user)
    {
       String res=uservice.userLogin(user);
       if(res=="Login successfull")
       {
         return ResponseEntity.ok(res);
       }
       return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }

}
