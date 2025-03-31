package com.example.career_goals_tracker.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "objectives")
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int progress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "objective_skills",
        joinColumns = @JoinColumn(name = "objective_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    public Objective() {}
    public Objective(String title, String description, int progress) {
        this.title = title;
        this.description = description;
        this.progress = progress;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getProgress() { return progress; }
    public void setProgress(int progress) { this.progress = progress; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public List<Skill> getSkills() { return skills; }
    public void setSkills(List<Skill> skills) { this.skills = skills; }
}