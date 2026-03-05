package com.example.event_management_system_backend.Repo;


import com.example.event_management_system_backend.Entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepo extends JpaRepository<Club,Long> {
}
