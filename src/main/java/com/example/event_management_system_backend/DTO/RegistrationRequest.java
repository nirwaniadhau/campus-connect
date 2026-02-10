package com.example.event_management_system_backend.DTO;


import lombok.Data;

@Data
public class RegistrationRequest {
    private Long userId;
    private Long eventId;
}
