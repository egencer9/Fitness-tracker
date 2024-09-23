package com.ege.fitness_tracker.service.impls;

import com.ege.fitness_tracker.repository.SessionRepository; // Correct repository import
import com.ege.fitness_tracker.domain.CreateSessionRequest;
import com.ege.fitness_tracker.domain.CreateSessionResponse;
import com.ege.fitness_tracker.entity.SessionEntity;
import com.ege.fitness_tracker.exception.ResourceNotFoundException;
import com.ege.fitness_tracker.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Override
    public CreateSessionResponse createSession(CreateSessionRequest createSessionRequest) {
        // Create a new SessionEntity from the request
        SessionEntity sessionEntity = new SessionEntity();
        sessionEntity.setName(createSessionRequest.getSessionName());


        // Get the current date and set it to the session entity
        LocalDate sessionDate = LocalDate.now();  // Get today's date
        sessionEntity.setSessionDate(sessionDate);

        // Save the session
        SessionEntity savedSession = sessionRepository.save(sessionEntity);

        // Build and return CreateSessionResponse
        CreateSessionResponse response = new CreateSessionResponse();
        response.setSessionId(savedSession.getId());
        response.setLocalDateTime(savedSession.getSessionDate().atStartOfDay());
        response.setResponseMessage("Session created successfully");

        return response;
    }

    @Override
    public SessionEntity getSessionById(Long id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SessionEntity not found with id: " + id));
    }

    @Override
    public List<SessionEntity> getAllSessions() {
        return sessionRepository.findAll();
    }

    //TODO add response
    @Override
    public SessionEntity updateSession(Long id, CreateSessionRequest request) {
        // Retrieve the existing session by ID
        SessionEntity existingSessionEntity = getSessionById(id);

        // Update the fields of the existing session based on the request
        existingSessionEntity.setName(request.getSessionName());
        existingSessionEntity.setSessionDate(LocalDate.now());  // Update to the current date, or you can use a date from the request if applicable

        // Save the updated session entity
        return sessionRepository.save(existingSessionEntity);
    }

    @Override
    public void deleteSession(Long id) {
        SessionEntity sessionEntity = getSessionById(id);
        sessionRepository.delete(sessionEntity);
    }
}
