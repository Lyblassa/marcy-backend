package com.example.marcybackend.controller;

import com.example.marcybackend.dto.ClientDTO;
import com.example.marcybackend.model.Client;
import com.example.marcybackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Créer un client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    // Supprimer un client
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    // Trouver un client par email
    @GetMapping("/email/{email}")
    public Client findClientByEmail(@PathVariable String email) {
        return clientService.findClientByEmail(email);
    }
}
