package com.example.marcybackend.model;

import com.example.marcybackend.model.Client;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "decodeur", schema = "marcy_bd")
public class Decodeur {

    @Id
    private Long id;
    private String ip;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client; // Référence à la table Client

    @ManyToMany
    @JoinTable(
            name = "decodeur_chaine",
            schema = "marcy_bd",
            joinColumns = @JoinColumn(name = "decodeur_id"),
            inverseJoinColumns = @JoinColumn(name = "chaine_id")
    )
    @JsonManagedReference
    private List<Chaine> chaines; // Liste des chaînes associées au décodeur

    // Constructeur
    public Decodeur(Long id, String ip, Client client, List<Chaine> chaines) {
        this.id = id;
        this.ip = ip;
        this.client = client;
        this.chaines = chaines;
    }

    public Decodeur() {}

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Chaine> getChaines() {
        return chaines;
    }

    public void setChaines(List<Chaine> chaines) {
        this.chaines = chaines;
    }
}
