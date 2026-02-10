package com.example.event_management_system_backend.services;

import com.example.event_management_system_backend.Entities.Club;
import com.example.event_management_system_backend.Repo.ClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    private final ClubRepo clubRepo;

    public ClubService(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    public Club createClub(Club club) {

       return clubRepo.save(club);
    }

    public List<Club> getAllClubs() {

        return clubRepo.findAll();
    }
}
