package com.ege.fitness_tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity

@Getter
@Setter
@Table(name = "session")
@NoArgsConstructor
@AllArgsConstructor
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // E.g., "Push 1"

    private LocalDate sessionDate;  // Date of the session

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<ExerciseEntity> exerciseEntities;

    // Getters and setters
}
