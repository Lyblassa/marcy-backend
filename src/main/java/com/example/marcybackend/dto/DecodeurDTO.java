package com.example.marcybackend.dto;

public class DecodeurDTO {

    private String ip;
    private Long clientId;

    // Constructeur
    public DecodeurDTO(String ip, Long clientId) {
        this.ip = ip;
        this.clientId = clientId;
    }

    // Getters et setters
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
