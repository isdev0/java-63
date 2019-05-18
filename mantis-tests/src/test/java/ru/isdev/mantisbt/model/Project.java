package ru.isdev.mantisbt.model;

public class Project {

    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public Project withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project withDescription(String description) {
        this.description = description;
        return this;
    }
}
