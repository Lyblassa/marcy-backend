package com.example.marcybackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="chaine", schema = "marcy_bd")
public class Chaine {

    @Id
    private Long id;
    private String nom;

    @ManyToMany(mappedBy = "chaines")
    @JsonBackReference
    private List<Decodeur> decodeurs;

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

    public List<Decodeur> getDecodeurs() {return decodeurs;}

    public void setDecodeurs(List<Decodeur> decodeurs){ this.decodeurs = decodeurs ;}
}
