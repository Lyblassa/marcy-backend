package com.example.marcybackend.repository;

import com.example.marcybackend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUserEmail(String email);
}
