package com.example.marcybackend.controller;

import com.example.marcybackend.dto.DecodeurDTO;
import com.example.marcybackend.model.Chaine;
import com.example.marcybackend.model.Decodeur;
import com.example.marcybackend.service.ChaineService;
import com.example.marcybackend.service.DecodeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Obtenir les décodeurs disponibles
    @GetMapping("/available")
    public List<Decodeur> getAvailableDecoders() {
        return decodeurService.getAvailableDecoders();
    }

    @PostMapping("/{clientId}/assign/{decodeurId}")
    public ResponseEntity<Decodeur> assignDecodeurToClient(@PathVariable Long clientId, @PathVariable Long decodeurId) {
        try {
            Decodeur decodeur = decodeurService.assignDecodeurToClient(clientId, decodeurId);
            return ResponseEntity.status(HttpStatus.OK).body(decodeur);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    // Retirer un décodeur d'un client
    @DeleteMapping("/{clientId}/delete/{decodeurId}")
    public ResponseEntity<Decodeur> removeDecodeurFromClient(@PathVariable Long clientId, @PathVariable Long decodeurId) {
        try {
            Decodeur updatedDecodeur = decodeurService.removeDecodeurFromClient(clientId, decodeurId);  // Récupérer le décodeur mis à jour
            return ResponseEntity.status(HttpStatus.OK).body(updatedDecodeur);  // Retourner le décodeur mis à jour
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Si l'erreur se produit
        }
    }


}
