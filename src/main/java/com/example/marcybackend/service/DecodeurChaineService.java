package com.example.marcybackend.service;

import com.example.marcybackend.model.Chaine;
import com.example.marcybackend.model.Decodeur;
import com.example.marcybackend.model.DecodeurChaine;
import com.example.marcybackend.repository.ChaineRepository;
import com.example.marcybackend.repository.DecodeurChaineRepository;
import com.example.marcybackend.repository.DecodeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecodeurChaineService {
    @Autowired
    private ChaineRepository chaineRepository;

    @Autowired
    private DecodeurRepository decodeurRepository;

    @Autowired
    private DecodeurChaineRepository decodeurChaineRepository;

    // Ajouter une chaîne au décodeur
    public DecodeurChaine addChaineToDecodeur(Long decodeurId, Long chaineId) {
        Decodeur decodeur = decodeurRepository.findById(decodeurId).orElseThrow(() -> new RuntimeException("Décodeur non trouvé"));
        Chaine chaine = chaineRepository.findById(chaineId).orElseThrow(() -> new RuntimeException("Chaîne non trouvée"));

        DecodeurChaine decodeurChaine = new DecodeurChaine(decodeur, chaine);
        return decodeurChaineRepository.save(decodeurChaine);
    }

    // Supprimer une chaîne du décodeur
    public void removeChaineFromDecodeur(Long decodeurId, Long chaineId) {
        DecodeurChaine decodeurChaine = decodeurChaineRepository.findByDecodeurAndChaine(decodeurId, chaineId)
                .orElseThrow(() -> new RuntimeException("Association décodeur-chaine non trouvée"));

        decodeurChaineRepository.delete(decodeurChaine);
    }

}
