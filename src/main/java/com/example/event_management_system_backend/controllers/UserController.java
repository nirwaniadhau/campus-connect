package com.example.event_management_system_backend.controllers;


import com.example.event_management_system_backend.Entities.User;
import com.example.event_management_system_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userSerive;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
       User savedUser= userSerive.createUser(user);

       return  new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUser(){
        List<User> users= userSerive.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}
