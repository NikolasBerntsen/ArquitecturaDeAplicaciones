package com.example.microservicio.controllers;

import com.example.microservicio.dto.LoginDTO;
import com.example.microservicio.dto.UserDTO;
import com.example.microservicio.messagingPublicar.UserCreatedEvent;
import com.example.microservicio.messagingPublicar.UserEventPublisher;
import com.example.microservicio.model.User;
import com.example.microservicio.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ControllerUser {

    @Autowired
    private UserService userService;
    @Autowired
    private UserEventPublisher userEventPublisher;
    private static final Logger log = LoggerFactory.getLogger(ControllerUser.class);


    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO dto) {

        User user = userService.createUser(dto);

        UserCreatedEvent event = new UserCreatedEvent(
                user.getId(),
                user.getNombreUsuario(),
                user.getMail()
        );

        userEventPublisher.publishUserCreated(event);

        log.info("Publicando evento user.created: {}", event);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public User getUser(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }
}