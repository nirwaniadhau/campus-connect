package com.example.event_management_system_backend.services;


import com.example.event_management_system_backend.Entities.Event;
import com.example.event_management_system_backend.Repo.EventRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/events")
@Service
public class EventService {

    private final EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public Event createEvent(Event event) {
        event.setAvailableSeats(event.getMaxSeats());
        if(event.getMaxSeats()<=0){
            throw new RuntimeException("Maxseats should be greater than 0");
        }
        Event savedEvent=eventRepo.save(event);

        return savedEvent;
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}
