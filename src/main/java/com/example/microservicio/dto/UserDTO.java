package com.example.microservicio.dto;

import lombok.Data;

@Data
public class UserDTO {

    private String nombre;
    private String nombreUsuario;
    private String contrasena;
    private String mail;

}