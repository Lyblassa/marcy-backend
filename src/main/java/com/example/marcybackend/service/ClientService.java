package com.example.marcybackend.service;

import com.example.marcybackend.model.Client;
import com.example.marcybackend.repository.ClientRepository;
import com.example.marcybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    // Créer un client
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Supprimer un client
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    // Trouver un client par email de l'utilisateur
    public Client findClientByEmail(String email) {
        return clientRepository.findByUserEmail(email);
    }
}
