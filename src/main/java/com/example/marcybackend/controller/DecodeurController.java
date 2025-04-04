package com.example.marcybackend.controller;

import com.example.marcybackend.dto.DecodeurDTO;
import com.example.marcybackend.model.Decodeur;
import com.example.marcybackend.service.DecodeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decodeurs")
public class DecodeurController {

    @Autowired
    private DecodeurService decodeurService;

    // Assigner un décodeur à un client
    @PostMapping
    public Decodeur assignDecodeurToClient(@RequestBody Decodeur decodeur) {
        return decodeurService.assignDecodeurToClient(decodeur);
    }

    // Obtenir les décodeurs d'un client
    @GetMapping("/client/{clientId}")
    public List<Decodeur> getDecodeursForClient(@PathVariable Long clientId) {
        return decodeurService.getDecodeursForClient(clientId);
    }

    // Redémarrer un décodeur
    @PostMapping("/{id}/restart")
    public Decodeur restartDecodeur(@PathVariable Long id) {
        return decodeurService.restartDecodeur(id);
    }
}
