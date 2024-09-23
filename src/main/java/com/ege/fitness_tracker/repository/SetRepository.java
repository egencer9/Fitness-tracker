package com.ege.fitness_tracker.repository;

import com.ege.fitness_tracker.entity.SetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetRepository extends JpaRepository<SetEntity, Long> {
}
