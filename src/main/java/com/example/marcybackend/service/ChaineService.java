package com.example.marcybackend.service;

import com.example.marcybackend.model.Chaine;
import com.example.marcybackend.repository.ChaineRepository;
import com.example.marcybackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChaineService {

    @Autowired
    private ChaineRepository chaineRepository;

    // Exemple dans le service pour récupérer les chaînes associées à un décodeur via la table decodeur_chaine

public List<Chaine> getChaines() {
    return (List<Chaine>) chaineRepository.findAll();
}
}
