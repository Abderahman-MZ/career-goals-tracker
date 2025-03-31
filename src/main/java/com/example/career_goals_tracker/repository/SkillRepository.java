package com.example.career_goals_tracker.repository;

import com.example.career_goals_tracker.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}