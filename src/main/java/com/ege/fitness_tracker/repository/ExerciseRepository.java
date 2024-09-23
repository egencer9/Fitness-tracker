package com.ege.fitness_tracker.repository;

import com.ege.fitness_tracker.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {
}
