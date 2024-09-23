package com.ege.fitness_tracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "exercise")
@Getter
@Setter
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Many-to-One relationship with SessionEntity
    @ManyToOne
    @JoinColumn(name = "session_id")  // This column will be in the 'exercise' table
    private SessionEntity session;  // Add this field to resolve the 'mappedBy' error

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SetEntity> sets;
}
