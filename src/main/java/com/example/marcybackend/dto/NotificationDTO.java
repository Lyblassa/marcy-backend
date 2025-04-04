package com.example.marcybackend.dto;
public class NotificationDTO {

    private String message;
    private String type;

    // Constructeur
    public NotificationDTO(String message, String type) {
        this.message = message;
        this.type = type;
    }

    // Getters et setters
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

