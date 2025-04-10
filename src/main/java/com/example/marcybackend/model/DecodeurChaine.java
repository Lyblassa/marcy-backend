package com.example.marcybackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "decodeur_chaine", schema = "marcy_bd")
public class DecodeurChaine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "decodeur_id", referencedColumnName = "id")
    private Decodeur decodeur;

    @ManyToOne
    @JoinColumn(name = "chaine_id", referencedColumnName = "id")
    private Chaine chaine;

    // Constructeurs, getters et setters
    public DecodeurChaine() {}

    public DecodeurChaine(Decodeur decodeur, Chaine chaine) {
        this.decodeur = decodeur;
        this.chaine = chaine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Decodeur getDecodeur() {
        return decodeur;
    }

    public void setDecodeur(Decodeur decodeur) {
        this.decodeur = decodeur;
    }

    public Chaine getChaine() {
        return chaine;
    }

    public void setChaine(Chaine chaine) {
        this.chaine = chaine;
    }
}
