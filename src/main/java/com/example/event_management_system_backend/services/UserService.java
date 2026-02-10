package com.example.event_management_system_backend.services;


import com.example.event_management_system_backend.Entities.User;
import com.example.event_management_system_backend.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public List<User> getAllUser(){
        return userRepo.findAll();
    }
    public User createUser(User user) {
        return userRepo.save(user);
    }
}
