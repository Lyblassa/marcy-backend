package com.example.marcybackend.service;

import com.example.marcybackend.dto.UserDTO;
import com.example.marcybackend.exceptions.InvalidDataException;
import com.example.marcybackend.exceptions.NotFoundException;
import com.example.marcybackend.model.Role;
import com.example.marcybackend.model.User;
import com.example.marcybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(Long id) throws NotFoundException {
        return this.userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Aucun utilisateur n'a été trouvé avec l'ID " + id + ".")
        );
    }

    public User createUser(User user) {
        // Attribuer le rôle "client" par défaut
        if (user.getRole() == null) {
            user.setRole("client");  // Rôle par défaut
        }

        return userRepository.save(user);  // Enregistrer l'utilisateur dans la base de données
    }


    public void updateUser(User user){
        this.userRepository.save(user);
    }

    public User login(String email, String password) throws NotFoundException {
        return userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new NotFoundException("Email ou mot de passe incorrect."));
    }

    public UserDTO mapToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    public List<UserDTO> getAllUsersDTO() {
        List<UserDTO> dtos = new ArrayList<>();
        this.userRepository.findAll().forEach(user -> dtos.add(mapToDTO(user)));
        return dtos;
    }

    public UserDTO getUserDTOById(Long id) {
        return mapToDTO(getUserById(id));
    }

    public UserDTO loginAndGetDTO(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Email ou mot de passe incorrect."));
    }

}
