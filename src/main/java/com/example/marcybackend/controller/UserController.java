package com.example.marcybackend.controller;

import com.example.marcybackend.dto.UserDTO;
import com.example.marcybackend.model.User;
import com.example.marcybackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/marcy/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService ;

    public UserController(UserService userService){
        this.userService = userService ;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAllUsersDTO();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUserDTOById(id);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody User user){
        User insertedUser = this.userService.insertUser(user);
        return ResponseEntity.ok(userService.mapToDTO(insertedUser));
    }

    @PutMapping
    public UserDTO updateUser(@PathVariable int id, @RequestBody User user){
        if(id != user.getId()){
            throw new IllegalArgumentException("L'ID spécifié dans l'URL ne correspond pas à celui du membre fourni.");
        }
        this.userService.updateUser(user);
        return userService.mapToDTO(user);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String motDePasse = credentials.get("motDePasse");
        return userService.loginAndGetDTO(email, motDePasse);
    }



}
