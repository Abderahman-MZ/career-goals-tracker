package com.example.career_goals_tracker.controller;

import com.example.career_goals_tracker.model.Skill;
import com.example.career_goals_tracker.service.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @Operation(summary = "Get all skills")
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    @Operation(summary = "Get a skill by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Skill found"),
            @ApiResponse(responseCode = "404", description = "Skill not found")
    })
    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @Operation(summary = "Create a new skill")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Skill createSkill(@RequestBody Skill skill) {
        return skillService.createSkill(skill);
    }

    @Operation(summary = "Update an existing skill")
    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        return skillService.updateSkill(id, skill);
    }

    @Operation(summary = "Delete a skill")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }
}