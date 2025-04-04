package com.example.marcybackend.service;

import com.example.marcybackend.model.Notification;
import com.example.marcybackend.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Créer une notification
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Récupérer une notification par ID
    public Notification getNotification(Long id) {
        return notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
    }
}

