package com.example.marcybackend.repository;

import com.example.marcybackend.model.DecodeurChaine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface DecodeurChaineRepository extends CrudRepository<DecodeurChaine, Long> {

    // Requête JPQL personnalisée pour trouver une association décodeur-chaine spécifique
    @Query("SELECT dc FROM DecodeurChaine dc WHERE dc.decodeur.id = :decodeurId AND dc.chaine.id = :chaineId")
    Optional<DecodeurChaine> findByDecodeurAndChaine(Long decodeurId, Long chaineId);
}
