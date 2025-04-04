package com.example.marcybackend.model;

import com.example.marcybackend.model.Client;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Decodeur {

    @Id
    private Long id;
    private String ip;

    @ManyToOne
    private Client client; // Référence à la table Client

    @ManyToMany
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
