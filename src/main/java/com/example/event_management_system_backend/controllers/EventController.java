package com.example.event_management_system_backend.controllers;

import com.example.event_management_system_backend.Entities.Event;
import com.example.event_management_system_backend.Repo.EventRepo;
import com.example.event_management_system_backend.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RequestMapping("/events")
@RestController
public class EventController {

    @Autowired
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){

        Event savedEvent=eventService.createEvent(event);
        return new ResponseEntity<>(savedEvent,HttpStatus.CREATED);
    }

    @GetMapping("/getAllevents")
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> event=eventService.getAllEvents();
        return new ResponseEntity<>(event,HttpStatus.OK);
    }
}
