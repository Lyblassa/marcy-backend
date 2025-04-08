package com.example.marcybackend.controller;

import com.example.marcybackend.dto.DecodeurDTO;
import com.example.marcybackend.model.Chaine;
import com.example.marcybackend.model.Decodeur;
import com.example.marcybackend.service.ChaineService;
import com.example.marcybackend.service.DecodeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decodeurs")
@CrossOrigin(origins = "http://localhost:4200")
public class DecodeurController {

    @Autowired
    private DecodeurService decodeurService;

    @Autowired
    private ChaineService chaineService;

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

    @GetMapping("/{decoderId}/chaines")
    public List<Chaine> getChainsForDecoder(@PathVariable Long decoderId) {
        return decodeurService.getChannelsForDecoder(decoderId);  // Appel à ton service pour récupérer les chaînes
    }

    // Dans le contrôleur
    @GetMapping("/id/{ip}")
    public Long getDecoderIdByIp(@PathVariable String ip) {
        return decodeurService.getDecoderIdByIp(ip);  // Service pour obtenir l'ID par IP
    }


}
