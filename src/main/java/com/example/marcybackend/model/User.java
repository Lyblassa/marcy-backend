package com.example.marcybackend.model;

import jakarta.persistence.*;

@Entity
@Table(name="user", schema = "marcy_bd")
public class User {

    @Id
    private Long id;
    private String email;
    private String motDePasse;
    private String role;  // Peut être 'client' ou 'administrateur'

    // Constructeur
    public User(Long id, String email, String motDePasse, String role) {
        this.id = id;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public User() {}

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
