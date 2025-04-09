package com.example.marcybackend.controller;

import com.example.marcybackend.dto.ClientDTO;
import com.example.marcybackend.model.Chaine;
import com.example.marcybackend.service.ChaineService;
import com.example.marcybackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chaines")
@CrossOrigin(origins = "http://localhost:4200")

public class ChaineController {

    @Autowired
    private ChaineService chaineService;

    // Récupérer toutes les chaines
    @GetMapping
    public List<Chaine> getChaines() {
        return chaineService.getChaines();
    }



}
