package com.ege.fitness_tracker.service.impls;

import com.ege.fitness_tracker.domain.CreateSetRequest;
import com.ege.fitness_tracker.domain.CreateSetResponse;
import com.ege.fitness_tracker.entity.ExerciseEntity;
import com.ege.fitness_tracker.entity.SetEntity;
import com.ege.fitness_tracker.repository.ExerciseRepository;
import com.ege.fitness_tracker.repository.SetRepository;
import com.ege.fitness_tracker.service.SetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SetServiceImpl implements SetService {

    private final SetRepository setRepository;
    private final ExerciseRepository exerciseRepository;
    @Override
    public CreateSetResponse createSet(CreateSetRequest createSetRequest) {
        // Fetch the exercise using the exercise_id (assumed to be part of the request)
        ExerciseEntity exercise = exerciseRepository.findById(createSetRequest.getExerciseId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid exercise ID"));

        // Create and populate the SetEntity
        SetEntity setEntity = new SetEntity();
        setEntity.setExercise(exercise);  // Set the exercise association
        setEntity.setReps(createSetRequest.getReps());
        setEntity.setWeight(createSetRequest.getWeight());
        setEntity.setRpe(createSetRequest.getRpe());
        setEntity.setComment(createSetRequest.getComment());

        // Save the set
        setRepository.save(setEntity);

        // Return response
        CreateSetResponse response = new CreateSetResponse();
        response.setExerciseId(exercise.getId());
        response.setResponseMessage("Set created successfully.");
        return response;
    }

    @Override
    public SetEntity getSetById(Long id) {
        Optional<SetEntity> set = setRepository.findById(id);
        return set.orElse(null);  // Return null if not found, you can change this to throw a custom exception
    }

    @Override
    public List<SetEntity> getAllSets() {
        return setRepository.findAll();
    }

    @Override
    public SetEntity updateSet(Long id, CreateSetRequest request) {
        Optional<SetEntity> optionalSet = setRepository.findById(id);

        if (optionalSet.isPresent()) {
            SetEntity setEntity = optionalSet.get();
            setEntity.setReps(request.getReps());
            setEntity.setWeight(request.getWeight());
            setEntity.setRpe(request.getRpe());
            setEntity.setComment(request.getComment());

            return setRepository.save(setEntity);
        } else {
            return null;  // Or throw an exception if the set with the given id is not found
        }
    }

    @Override
    public void deleteSet(Long id) {
        setRepository.deleteById(id);
    }
}
