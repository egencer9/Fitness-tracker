package com.ege.fitness_tracker.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateExerciseRequest {
    private Long id;
    private String name;
}
