package com.example.marcybackend.service;

import com.example.marcybackend.dto.ClientDTO;
import com.example.marcybackend.model.Client;
import com.example.marcybackend.model.User;
import com.example.marcybackend.repository.ClientRepository;
import com.example.marcybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    // Récupérer tous les clients
    public List<ClientDTO> getAllClients() {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        List<ClientDTO> clientDTOs = new ArrayList<>();

        for (Client client : clients) {
            String email = client.getUser() != null ? client.getUser().getEmail() : "Pas d'email";
            // Créez un DTO pour chaque client
            ClientDTO clientDTO = new ClientDTO(
                    client.getId(),
                    client.getNom(),
                    client.getPrenom(),
                    client.getNumeroTelephone(),
                    client.getAdresse(),
                    email
            );
            clientDTOs.add(clientDTO);
        }

        return clientDTOs;
    }


    // Récupérer un client par son ID
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    // Méthode pour créer un client pour un utilisateur spécifique
    public Client createClient(Long userId, Client client) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            client.setUser(user); // Associer l'utilisateur au client
            return clientRepository.save(client); // Enregistrer le client et l'associer à l'utilisateur
        } else {
            throw new RuntimeException("Utilisateur non trouvé avec l'ID " + userId); // Gérer le cas où l'utilisateur n'existe pas
        }
    }

    // Mettre à jour un client
    public Client updateClient(Long id, Client updatedClient) {
        if (clientRepository.existsById(id)) {
            updatedClient.setId(id);
            return clientRepository.save(updatedClient);
        }
        throw new RuntimeException("Client not found for ID: " + id);
    }

    // Supprimer un client
    public void deleteClient(Long id) {
        Optional<Client> clientOpt = clientRepository.findById(id);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            User user = client.getUser();

            if (user != null) {
                userRepository.delete(user);
            }

            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Client not found for ID: " + id);
        }
    }

}
