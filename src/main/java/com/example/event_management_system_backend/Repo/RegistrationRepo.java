package com.example.event_management_system_backend.Repo;


import com.example.event_management_system_backend.Entities.Event;
import com.example.event_management_system_backend.Entities.Registration;
import com.example.event_management_system_backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration,Long> {

    boolean existsByuserAndEvent(User user, Event event);
}
