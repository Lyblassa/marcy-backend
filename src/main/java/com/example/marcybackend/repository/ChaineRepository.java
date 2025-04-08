package com.example.marcybackend.repository;

import com.example.marcybackend.model.Chaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChaineRepository extends CrudRepository<Chaine, Long> {
    List<Chaine> findByDecodeursId(Long decoderId);
}

