package com.example.marcybackend.repository;

import com.example.marcybackend.model.Chaine;
import com.example.marcybackend.model.Decodeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DecodeurRepository extends CrudRepository<Decodeur, Long> {
    List<Decodeur> findByClientId(Long clientId);

    Decodeur findByIp(String ip);
}
