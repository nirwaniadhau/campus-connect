package com.example.event_management_system_backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private Integer maxSeats;
    private Integer availableSeats;
    private LocalDateTime registrationDeadline;
    private BigDecimal fee;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime eventDate;



    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
