package com.example.marcybackend.model;

import jakarta.persistence.*;

@Entity
@Table(name="user", schema = "marcy_bd")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)  // mappedBy indique que la relation est déjà définie dans Client
    private Client client;

    // Constructeur
    public User(Long id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
