package com.ege.fitness_tracker.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateSessionResponse {
    private Long sessionId;
    private String responseMessage;
    private LocalDateTime localDateTime;
}
