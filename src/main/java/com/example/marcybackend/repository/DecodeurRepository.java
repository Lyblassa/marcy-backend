package com.example.marcybackend.repository;

import com.example.marcybackend.model.Decodeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecodeurRepository extends JpaRepository<Decodeur, Long> {
    List<Decodeur> findByClientId(Long clientId);
}
