package com.example.marcybackend.model;

import jakarta.persistence.*;

@Entity
public class Notification {

    @Id
    private Long id;
    private String message;
    private String type;

    // Constructeur
    public Notification(Long id, String message, String type) {
        this.id = id;
        this.message = message;
        this.type = type;
    }

    public Notification() {}

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
