package com.example.marcybackend.model;

import jakarta.persistence.*;

@Entity
public class Chaine {

    @Id
    private Long id;
    private String nom;

    // Constructeur
    public Chaine(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Chaine() {}

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
