package com.example.event_management_system_backend.controllers;


import com.example.event_management_system_backend.Entities.Club;
import com.example.event_management_system_backend.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/clubs")
@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;

    @PostMapping("/create")
    public ResponseEntity<Club> createClub(@RequestBody Club club){
       Club savedClub= clubService.createClub(club);

        return new ResponseEntity<>(savedClub, HttpStatus.CREATED);
    }

    @GetMapping("/getAllclubs")
    public ResponseEntity<List<Club>> getAllClubs(){
       List<Club> allClubs= clubService.getAllClubs();
       return new ResponseEntity<>(allClubs,HttpStatus.OK);
    }


}
