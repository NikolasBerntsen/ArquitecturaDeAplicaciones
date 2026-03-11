package com.example.microservicio.service;

import com.example.microservicio.dto.LoginDTO;
import com.example.microservicio.dto.UserDTO;
import com.example.microservicio.model.User;
import com.example.microservicio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO) {

        User user = new User();

        user.setNombre(userDTO.getNombre());
        user.setNombreUsuario(userDTO.getNombreUsuario());
        user.setContrasena(userDTO.getContrasena());
        user.setMail(userDTO.getMail());

        return userRepository.save(user);
    }

    public User login(LoginDTO loginDTO) {

        Optional<User> user = userRepository.findByMail(loginDTO.getMail());

        if (user.isPresent()) {

            if (user.get().getContrasena().equals(loginDTO.getContrasena())) {
                return user.get();
            }

        }

        return null;
    }
}