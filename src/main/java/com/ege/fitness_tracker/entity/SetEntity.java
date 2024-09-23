package com.ege.fitness_tracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "set_of_exercise")
@Getter
@Setter
public class SetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int reps; // Add this if you want to use repetitions
    private int weight;
    private int rpe;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private ExerciseEntity exercise;
}
