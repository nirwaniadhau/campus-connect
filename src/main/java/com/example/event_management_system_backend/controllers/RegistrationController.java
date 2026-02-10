package com.example.event_management_system_backend.controllers;

import com.example.event_management_system_backend.DTO.RegistrationRequest;
import com.example.event_management_system_backend.Entities.Registration;
import com.example.event_management_system_backend.services.RegistrationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/events")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request){
        registrationService.register(
                request.getUserId(),
                request.getEventId()
        );
        return ResponseEntity.ok("Registered Successfully");


    }

    @GetMapping("/getAllRegistrations")
    public ResponseEntity<List<Registration>> getAllRegistrations(){
        List<Registration> registered= registrationService.getAllRegistrations();
        return new ResponseEntity<>(registered,HttpStatus.OK);
    }
}
