package com.ege.fitness_tracker.service;

import com.ege.fitness_tracker.domain.CreateExerciseRequest;
import com.ege.fitness_tracker.domain.CreateExerciseResponse;
import com.ege.fitness_tracker.entity.ExerciseEntity;

import java.util.List;

public interface ExerciseService {
    CreateExerciseResponse createExercise(Long sessionId, CreateExerciseRequest request);  // Return CreateExerciseResponse
    ExerciseEntity getExerciseById(Long id);
    List<ExerciseEntity> getAllExercises();
    ExerciseEntity updateExercise(Long id, CreateExerciseRequest request);
    void deleteExercise(Long id);
}
