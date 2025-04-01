package com.example.career_goals_tracker.controller;

import com.example.career_goals_tracker.model.Objective;
import com.example.career_goals_tracker.service.ObjectiveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objectives")
public class ObjectiveController {
    @Autowired
    private ObjectiveService objectiveService;

    @Operation(summary = "Get all objectives")
    @GetMapping
    public List<Objective> getAllObjectives() {
        return objectiveService.getAllObjectives();
    }

    @Operation(summary = "Get an objective by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Objective found"),
            @ApiResponse(responseCode = "404", description = "Objective not found")
    })
    @GetMapping("/{id}")
    public Objective getObjectiveById(@PathVariable Long id) {
        return objectiveService.getObjectiveById(id);
    }

    @Operation(summary = "Create a new objective")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Objective createObjective(@RequestBody Objective objective) {
        return objectiveService.createObjective(objective);
    }

    @Operation(summary = "Update an existing objective")
    @PutMapping("/{id}")
    public Objective updateObjective(@PathVariable Long id, @RequestBody Objective objective) {
        return objectiveService.updateObjective(id, objective);
    }

    @Operation(summary = "Delete an objective")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteObjective(@PathVariable Long id) {
        objectiveService.deleteObjective(id);
    }
}