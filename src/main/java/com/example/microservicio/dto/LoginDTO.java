package com.example.microservicio.dto;

public class LoginDTO {

    private String mail;
    private String contrasena;

    public LoginDTO() {}

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}