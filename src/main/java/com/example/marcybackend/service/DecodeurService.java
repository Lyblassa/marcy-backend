package com.example.marcybackend.service;

import com.example.marcybackend.model.Client;
import com.example.marcybackend.model.Decodeur;
import com.example.marcybackend.model.Chaine;
import com.example.marcybackend.repository.ClientRepository;
import com.example.marcybackend.repository.DecodeurRepository;
import com.example.marcybackend.repository.ChaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecodeurService {

    @Autowired
    private DecodeurRepository decodeurRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ChaineRepository chaineRepository;

    // Obtenir les décodeurs d'un client
    public List<Decodeur> getDecodeursForClient(Long clientId) {
        return decodeurRepository.findByClientId(clientId);
    }

    // Redémarrer un décodeur (ici, c'est un exemple de logique, vous pouvez ajouter un vrai mécanisme de redémarrage)
    public Decodeur restartDecodeur(Long decodeurId) {
        Decodeur decodeur = decodeurRepository.findById(decodeurId).orElseThrow(() -> new RuntimeException("Decodeur not found"));
        // Exemple de logique pour redémarrer
        // Vous pouvez ajouter un champ pour l'état du décodeur et le mettre à jour ici
        decodeur.setIp("Redémarrage"); // Simuler le redémarrage
        return decodeurRepository.save(decodeur);
    }

    // Ajouter une chaîne à un décodeur
    public void addChaineToDecodeur(Long decodeurId, Long chaineId) {
        Decodeur decodeur = decodeurRepository.findById(decodeurId).orElseThrow(() -> new RuntimeException("Decodeur not found"));
        Chaine chaine = chaineRepository.findById(chaineId).orElseThrow(() -> new RuntimeException("Chaine not found"));
        decodeur.getChaines().add(chaine); // Ajouter la chaîne au décodeur
        decodeurRepository.save(decodeur);
    }

    // Retirer une chaîne d'un décodeur
    public void removeChaineFromDecodeur(Long decodeurId, Long chaineId) {
        Decodeur decodeur = decodeurRepository.findById(decodeurId).orElseThrow(() -> new RuntimeException("Decodeur not found"));
        Chaine chaine = chaineRepository.findById(chaineId).orElseThrow(() -> new RuntimeException("Chaine not found"));
        decodeur.getChaines().remove(chaine); // Retirer la chaîne du décodeur
        decodeurRepository.save(decodeur);
    }

    public Long getDecoderIdByIp(String ip) {
        Decodeur decoder = decodeurRepository.findByIp(ip);
        if (decoder != null) {
            return decoder.getId();
        }
        throw new RuntimeException("Decoder not found for IP: " + ip);
    }

    // Récupérer les chaînes associées à un décodeur via son ID
    public List<Chaine> getChannelsForDecoder(Long decoderId) {
        // Appel au repository Chaine pour récupérer les chaînes par decoderId
        return chaineRepository.findByDecodeursId(decoderId);
    }

    // Retirer un décodeur d'un client
    public Decodeur removeDecodeurFromClient(Long clientId, Long decodeurId) {
        Decodeur decodeur = decodeurRepository.findById(decodeurId)
                .orElseThrow(() -> new RuntimeException("Decodeur not found"));

        // Vérifier si le décodeur est associé au client
        if (decodeur.getClient() != null && decodeur.getClient().getId().equals(clientId)) {
            decodeur.setClient(null);  // Dissocier le client
            return decodeurRepository.save(decodeur);  // Sauvegarder l'association
        } else {
            throw new RuntimeException("Le décodeur n'est pas associé à ce client");
        }
    }

    // Obtenir les décodeurs non assignés à un client
    public List<Decodeur> getAvailableDecoders() {
        return decodeurRepository.findByClientIdIsNull();  // Si `clientId` est null, ce décodeur est disponible
    }

    public Decodeur assignDecodeurToClient(Long clientId, Long decodeurId) {
        Decodeur decodeur = decodeurRepository.findById(decodeurId)
                .orElseThrow(() -> new RuntimeException("Decodeur not found"));

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Assigner le décodeur au client
        decodeur.setClient(client);
        return decodeurRepository.save(decodeur); // Sauvegarder l'association
    }




}
