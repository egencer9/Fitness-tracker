package com.ege.fitness_tracker.controller;

import com.ege.fitness_tracker.domain.CreateExerciseRequest;
import com.ege.fitness_tracker.domain.CreateExerciseResponse;
import com.ege.fitness_tracker.entity.ExerciseEntity;
import com.ege.fitness_tracker.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    // Create a new exercise
    @PostMapping("/{sessionId}")
    public ResponseEntity<CreateExerciseResponse> createExercise(
            @PathVariable Long sessionId,
            @RequestBody CreateExerciseRequest request) {
        CreateExerciseResponse response = exerciseService.createExercise(sessionId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get an exercise by ID
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseEntity> getExerciseById(@PathVariable Long id) {
        ExerciseEntity exercise = exerciseService.getExerciseById(id);
        return ResponseEntity.ok(exercise);
    }

    // Get all exercises
    @GetMapping
    public ResponseEntity<List<ExerciseEntity>> getAllExercises() {
        List<ExerciseEntity> exercises = exerciseService.getAllExercises();
        return ResponseEntity.ok(exercises);
    }

    // Update an exercise
    @PutMapping("/{id}")
    public ResponseEntity<ExerciseEntity> updateExercise(
            @PathVariable Long id,
            @RequestBody CreateExerciseRequest request) {
        ExerciseEntity updatedExercise = exerciseService.updateExercise(id, request);
        return ResponseEntity.ok(updatedExercise);
    }

    // Delete an exercise
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }
}
