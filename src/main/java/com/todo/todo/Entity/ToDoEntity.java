package com.todo.todo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private boolean active;
    public int getId() {
        return id;
    }

    public ToDoEntity() {
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
