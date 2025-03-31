package com.example.career_goals_tracker.controller;

import com.example.career_goals_tracker.model.Objective;
import com.example.career_goals_tracker.service.ObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objectives")
public class ObjectiveController {
    @Autowired
    private ObjectiveService objectiveService;

    @GetMapping
    public List<Objective> getAllObjectives() {
        return objectiveService.getAllObjectives();
    }

    @GetMapping("/{id}")
    public Objective getObjectiveById(@PathVariable Long id) {
        return objectiveService.getObjectiveById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Objective createObjective(@RequestBody Objective objective) {
        return objectiveService.createObjective(objective);
    }

    @PutMapping("/{id}")
    public Objective updateObjective(@PathVariable Long id, @RequestBody Objective objective) {
        return objectiveService.updateObjective(id, objective);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteObjective(@PathVariable Long id) {
        objectiveService.deleteObjective(id);
    }
}