package com.example.marcybackend.model;

import com.example.marcybackend.model.User;
import jakarta.persistence.*;

@Entity
@Table(name="client", schema = "marcy_bd")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;

    private String numeroTelephone;
    private String adresse;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user; // Référence à la table User

    // Constructeur
    public Client(Long id, String nom, String prenom, String numeroTelephone, String adresse, User user) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
        this.adresse = adresse;
        this.user = user;
    }

    public Client() {}

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
