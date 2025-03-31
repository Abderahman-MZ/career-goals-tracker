package com.example.career_goals_tracker.service;

import com.example.career_goals_tracker.model.Objective;
import com.example.career_goals_tracker.repository.ObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectiveService {
    @Autowired
    private ObjectiveRepository objectiveRepository;

    public List<Objective> getAllObjectives() {
        return objectiveRepository.findAll();
    }

    public Objective getObjectiveById(Long id) {
        return objectiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objective not found"));
    }

    public Objective createObjective(Objective objective) {
        return objectiveRepository.save(objective);
    }

    public Objective updateObjective(Long id, Objective objectiveDetails) {
        Objective objective = getObjectiveById(id);
        objective.setTitle(objectiveDetails.getTitle());
        objective.setDescription(objectiveDetails.getDescription());
        objective.setProgress(objectiveDetails.getProgress());
        return objectiveRepository.save(objective);
    }

    public void deleteObjective(Long id) {
        Objective objective = getObjectiveById(id);
        objectiveRepository.delete(objective);
    }
}