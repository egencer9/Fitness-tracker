package com.ege.fitness_tracker.service;

import com.ege.fitness_tracker.domain.CreateSessionRequest;
import com.ege.fitness_tracker.domain.CreateSessionResponse;
import com.ege.fitness_tracker.entity.SessionEntity;

import java.util.List;

public interface SessionService {
    CreateSessionResponse createSession(CreateSessionRequest createSessionRequest);  // Return CreateSessionResponse
    SessionEntity getSessionById(Long id);
    List<SessionEntity> getAllSessions();
    SessionEntity updateSession(Long id, CreateSessionRequest request);
    void deleteSession(Long id);
}
