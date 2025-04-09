package com.example.marcybackend.controller;

import com.example.marcybackend.dto.ClientDTO;
import com.example.marcybackend.model.Client;
import com.example.marcybackend.model.User;
import com.example.marcybackend.service.ClientService;
import com.example.marcybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    // Récupérer tous les clients
    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    // Récupérer un client par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.getClientById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Créer un client et l'associer à un utilisateur existant
    @PostMapping("/create/{userId}")
    public ResponseEntity<Client> createClient(@PathVariable Long userId, @RequestBody Client client) {
        try {
            // Appeler le service pour créer le client et l'associer à l'utilisateur
            Client newClient = clientService.createClient(userId, client);
            return ResponseEntity.status(HttpStatus.CREATED).body(newClient);  // Retourner une réponse avec le client créé
        } catch (RuntimeException e) {
            // Si l'utilisateur n'existe pas, retourner un code 400 BAD REQUEST
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Mettre à jour un client existant
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        try {
            Client client = clientService.updateClient(id, updatedClient);
            return ResponseEntity.ok(client);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Supprimer un client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
