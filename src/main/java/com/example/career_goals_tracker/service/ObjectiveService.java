package com.example.career_goals_tracker.service;

import com.example.career_goals_tracker.model.Objective;
import com.example.career_goals_tracker.model.Skill;
import com.example.career_goals_tracker.repository.ObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectiveService {
    @Autowired
    private ObjectiveRepository objectiveRepository;

    public List<Objective> getAllObjectives() {
        List<Objective> objectives = objectiveRepository.findAll();
        objectives.forEach(this::calculateProgress); // Update progress on fetch
        return objectives;
    }

    public Objective getObjectiveById(Long id) {
        Objective objective = objectiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objective not found"));
        calculateProgress(objective); // Update progress
        return objective;
    }

    public Objective createObjective(Objective objective) {
        calculateProgress(objective); // Set initial progress
        return objectiveRepository.save(objective);
    }

    public Objective updateObjective(Long id, Objective objectiveDetails) {
        Objective objective = getObjectiveById(id);
        objective.setTitle(objectiveDetails.getTitle());
        objective.setDescription(objectiveDetails.getDescription());
        objective.setSkills(objectiveDetails.getSkills()); // Update skills
        calculateProgress(objective); // Recalculate progress
        return objectiveRepository.save(objective);
    }

    public void deleteObjective(Long id) {
        Objective objective = getObjectiveById(id);
        objectiveRepository.delete(objective);
    }

    private void calculateProgress(Objective objective) {
        List<Skill> skills = objective.getSkills();
        if (skills == null || skills.isEmpty()) {
            objective.setProgress(0);
            return;
        }
        long completedSkills = skills.stream().filter(Skill::isCompleted).count();
        int progress = (int) ((completedSkills * 100) / skills.size());
        objective.setProgress(progress);
    }
}