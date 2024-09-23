package com.ege.fitness_tracker.controller;

import com.ege.fitness_tracker.domain.CreateSetRequest;
import com.ege.fitness_tracker.domain.CreateSetResponse;
import com.ege.fitness_tracker.entity.SetEntity;
import com.ege.fitness_tracker.service.SetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/set")
@RequiredArgsConstructor
public class SetController {

    private final SetService setService;

    // Create a new set
    @PostMapping
    public ResponseEntity<CreateSetResponse> createSet(@RequestBody CreateSetRequest request) {
        CreateSetResponse response = setService.createSet(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get a set by ID
    @GetMapping("/{id}")
    public ResponseEntity<SetEntity> getSetById(@PathVariable Long id) {
        SetEntity set = setService.getSetById(id);
        return ResponseEntity.ok(set);
    }

    // Get all sets
    @GetMapping
    public ResponseEntity<List<SetEntity>> getAllSets() {
        List<SetEntity> sets = setService.getAllSets();
        return ResponseEntity.ok(sets);
    }

    // Update a set
    @PutMapping("/{id}")
    public ResponseEntity<SetEntity> updateSet(
            @PathVariable Long id,
            @RequestBody CreateSetRequest request) {
        SetEntity updatedSet = setService.updateSet(id, request);
        return ResponseEntity.ok(updatedSet);
    }

    // Delete a set
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSet(@PathVariable Long id) {
        setService.deleteSet(id);
        return ResponseEntity.noContent().build();
    }
}
