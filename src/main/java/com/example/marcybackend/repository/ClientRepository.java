package com.example.marcybackend.repository;

import com.example.marcybackend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByUserEmail(String email);
    Optional<Client> findByUserId(Long userId);

}
