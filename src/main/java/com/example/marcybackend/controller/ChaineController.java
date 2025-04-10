package com.example.marcybackend.controller;

import com.example.marcybackend.dto.ClientDTO;
import com.example.marcybackend.model.Chaine;
import com.example.marcybackend.service.ChaineService;
import com.example.marcybackend.service.ClientService;
import com.example.marcybackend.service.DecodeurChaineService;
import com.example.marcybackend.service.DecodeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chaines")
@CrossOrigin(origins = "http://localhost:4200")

public class ChaineController {

    @Autowired
    private ChaineService chaineService;

    @Autowired
    private DecodeurChaineService decodeurChaineService;

    // Récupérer toutes les chaines
    @GetMapping
    public List<Chaine> getChaines() {
        return chaineService.getChaines();
    }

    // Ajouter une chaîne au décodeur
    @PostMapping("/add/{decodeurId}/{chaineId}")
    public ResponseEntity<Void> addChaineToDecodeur(@PathVariable Long decodeurId, @PathVariable Long chaineId) {
        decodeurChaineService.addChaineToDecodeur(decodeurId, chaineId);
        return ResponseEntity.ok().build();
    }

    // Supprimer une chaîne du décodeur
    @DeleteMapping("/remove/{decodeurId}/{chaineId}")
    public ResponseEntity<Void> removeChaineFromDecodeur(@PathVariable Long decodeurId, @PathVariable Long chaineId) {
        decodeurChaineService.removeChaineFromDecodeur(decodeurId, chaineId);
        return ResponseEntity.noContent().build();
    }

}
