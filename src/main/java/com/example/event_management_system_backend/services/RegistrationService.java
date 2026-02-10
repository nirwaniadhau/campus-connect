package com.example.event_management_system_backend.services;


import com.example.event_management_system_backend.Entities.*;
import com.example.event_management_system_backend.Repo.ClubRepo;
import com.example.event_management_system_backend.Repo.EventRepo;
import com.example.event_management_system_backend.Repo.RegistrationRepo;
import com.example.event_management_system_backend.Repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final EventRepo eventRepo;
    private final ClubRepo clubRepo;
    private final UserRepo userRepo;
    private final RegistrationRepo registrationRepo;

    public RegistrationService(EventRepo eventRepo, ClubRepo clubRepo, UserRepo userRepo, RegistrationRepo registrationRepo) {
        this.eventRepo = eventRepo;
        this.clubRepo = clubRepo;
        this.userRepo = userRepo;
        this.registrationRepo = registrationRepo;
    }


    @Transactional
    public Registration register(Long userId, Long eventId){
        User user= userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Event event = eventRepo.findById(eventId)
                .orElseThrow(()-> new RuntimeException("Event not found"));

        if(registrationRepo.existsByuserAndEvent(user,event)){
            throw new RuntimeException("User has already registered for this event");
        }

        if(event.getAvailableSeats()<=0){
            throw  new RuntimeException("Seats are full");
        }

        event.setAvailableSeats(event.getAvailableSeats()-1);

        Registration registration= new Registration();
        registration.setUser(user);
        registration.setEvent(event);
        registration.setStatus(RegistrationStatus.CONFIRMED);
        registration.setPaymentStatus(PaymentStatus.SUCCESS);
        eventRepo.save(event);
        return registrationRepo.save(registration);

    }

    public List<Registration> getAllRegistrations() {
        List<Registration> registered= registrationRepo.findAll();
        return registered;
    }
}
