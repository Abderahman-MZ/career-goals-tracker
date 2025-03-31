package com.example.career_goals_tracker.repository;

import com.example.career_goals_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}