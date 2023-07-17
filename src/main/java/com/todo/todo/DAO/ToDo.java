package com.todo.todo.DAO;

import jakarta.persistence.Column;

public class ToDo {
    private Integer id;
    private String description;
    private boolean active;

    public ToDo() {
    }

    public ToDo(Integer id, String description, boolean isActive) {
        this.id = id;
        this.description = description;
        this.active = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
