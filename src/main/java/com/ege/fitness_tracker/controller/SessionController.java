package com.ege.fitness_tracker.controller;

import com.ege.fitness_tracker.domain.CreateSessionRequest;
import com.ege.fitness_tracker.domain.CreateSessionResponse;
import com.ege.fitness_tracker.entity.SessionEntity;
import com.ege.fitness_tracker.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    // Get all Sessions
    @GetMapping
    public List<SessionEntity> getAll() {
        return sessionService.getAllSessions();
    }

    // Create a new session
    @PostMapping("/create")
    public ResponseEntity<CreateSessionResponse> create(@RequestBody CreateSessionRequest request) {
        CreateSessionResponse response = sessionService.createSession(request);

        if (response.getSessionId() != null) { // Check if session was created successfully
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    // Update session by ID
    @PutMapping("/{id}")
    public ResponseEntity<SessionEntity> update(@PathVariable Long id, @RequestBody CreateSessionRequest request) {
        try {
            SessionEntity updatedSession = sessionService.updateSession(id, request);
            return ResponseEntity.ok(updatedSession);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    // Get the session by id
    @GetMapping("/{id}")
    public ResponseEntity<SessionEntity> getById(@PathVariable Long id) {
        try {
            SessionEntity customer = sessionService.getSessionById(id);
            return ResponseEntity.ok(customer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            sessionService.deleteSession(id);
            return ResponseEntity.ok("Session deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found.");
        }
    }

    


}
