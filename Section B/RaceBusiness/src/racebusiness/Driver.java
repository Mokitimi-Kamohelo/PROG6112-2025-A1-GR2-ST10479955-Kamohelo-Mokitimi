/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racebusiness;

public class Driver {
    private final String id;
    private String name;
    private String experienceLevel; // e.g., "Rookie", "Professional", "Expert"

    public Driver(String id, String name, String experienceLevel) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        if (experienceLevel == null || experienceLevel.isBlank()) throw new IllegalArgumentException("experience required");
        this.id = id;
        this.name = name;
        this.experienceLevel = experienceLevel;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        this.name = name;
    }
    public String getExperienceLevel() { return experienceLevel; }
    public void setExperienceLevel(String exp) {
        if (exp == null || exp.isBlank()) throw new IllegalArgumentException("exp required");
        this.experienceLevel = exp;
    }

    public String summary() {
        return name + " (ID: " + id + ", Experience: " + experienceLevel + ")";
    }
}

