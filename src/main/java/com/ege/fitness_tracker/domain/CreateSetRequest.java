package com.ege.fitness_tracker.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSetRequest {
    private int reps;
    private int weight;
    private int rpe;
    private String comment;
    private Long exerciseId;
}
