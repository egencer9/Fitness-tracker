package com.ege.fitness_tracker.service.impls;

import com.ege.fitness_tracker.domain.CreateExerciseRequest;
import com.ege.fitness_tracker.domain.CreateExerciseResponse;
import com.ege.fitness_tracker.entity.ExerciseEntity;
import com.ege.fitness_tracker.entity.SessionEntity;
import com.ege.fitness_tracker.exception.ResourceNotFoundException;
import com.ege.fitness_tracker.repository.ExerciseRepository;
import com.ege.fitness_tracker.repository.SessionRepository;
import com.ege.fitness_tracker.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final SessionRepository sessionRepository;

    // Create a new exercise under a specific session
    public CreateExerciseResponse createExercise(Long sessionId, CreateExerciseRequest request) {
        // Check if session exists
        SessionEntity session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session not found with id: " + sessionId));

        // Create a new ExerciseEntity from the request
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setId(request.getId()); // Consider if you want to set this from the request
        exerciseEntity.setName(request.getName());
        exerciseEntity.setSession(session);

        // Save the exercise
        ExerciseEntity savedExerciseEntity = exerciseRepository.save(exerciseEntity);

        // Map the response
        CreateExerciseResponse response = new CreateExerciseResponse();
        response.setExerciseId(savedExerciseEntity.getId()); // Corrected to setExerciseId
        response.setResponseMessage("Exercise created successfully");

        return response;
    }

    public ExerciseEntity getExerciseById(Long id) {
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found with id: " + id));
    }

    public List<ExerciseEntity> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public ExerciseEntity updateExercise(Long id, CreateExerciseRequest request) {
        ExerciseEntity exerciseEntity = exerciseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found with id: " + id));

        // Update fields as needed
        if (request.getName() != null) {
            exerciseEntity.setName(request.getName());
        }

        return exerciseRepository.save(exerciseEntity);
    }

    public void deleteExercise(Long id) {
        if (!exerciseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Exercise not found with id: " + id);
        }
        exerciseRepository.deleteById(id);
    }
}
