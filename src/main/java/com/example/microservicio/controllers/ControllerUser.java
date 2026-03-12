package com.example.microservicio.controllers;

import com.example.microservicio.dto.LoginDTO;
import com.example.microservicio.dto.UserDTO;
import com.example.microservicio.model.User;
import com.example.microservicio.repository.UserRepository;
import com.example.microservicio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ControllerUser {

    @Autowired
    private UserService userService;



    @PostMapping("/crear")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            User user = userService.createUser(userDTO);
            return ResponseEntity.ok("Creado"); // HTTP 200

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear usuario: ");
        }
    }

    @PostMapping("/login")
    public User getUser(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }



}