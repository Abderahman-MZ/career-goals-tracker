package com.example.career_goals_tracker.repository;

import com.example.career_goals_tracker.model.Objective;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectiveRepository extends JpaRepository<Objective, Long> {
}