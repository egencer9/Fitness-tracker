package com.ege.fitness_tracker.service;

import com.ege.fitness_tracker.domain.CreateSetRequest;
import com.ege.fitness_tracker.domain.CreateSetResponse;
import com.ege.fitness_tracker.entity.SetEntity;

import java.util.List;

public interface SetService {
    CreateSetResponse createSet(CreateSetRequest createSetRequest);  // Return CreateSetResponse
    SetEntity getSetById(Long id);
    List<SetEntity> getAllSets();
    SetEntity updateSet(Long id, CreateSetRequest request);
    void deleteSet(Long id);
}
