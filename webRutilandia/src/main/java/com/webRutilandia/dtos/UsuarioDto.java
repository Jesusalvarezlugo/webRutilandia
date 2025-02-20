package com.webRutilandia.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto {

    private Long id;
    private String nombre = "aaaaa";
    private String apellido1 = "aaaaa";
    private String apellido2 = "aaaaa";
    private String telefono = "aaaaa";
    private String email = "aaaaa";
    private String rol = "aaaaa";
    private String contrasenia = "aaaaa";
    private String repContrasenia = "aaaaa";
    private String apellidos = "aaaaa";
    private String token = "aaaaa";
    private String tokenRecuperacion;
    private Date fechaExpiracion;
    private Date fechaExpiracionToken;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRepContrasenia() {
        return repContrasenia;
    }

    public void setRepContrasenia(String repContrasenia) {
        this.repContrasenia = repContrasenia;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenRecuperacion() {
        return tokenRecuperacion;
    }

    public void setTokenRecuperacion(String tokenRecuperacion) {
        this.tokenRecuperacion = tokenRecuperacion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Date getFechaExpiracionToken() {
        return fechaExpiracionToken;
    }

    public void setFechaExpiracionToken(Date fechaExpiracionToken) {
        this.fechaExpiracionToken = fechaExpiracionToken;
    }

    @Override
    public String toString() {
        return "UsuarioDto [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", rol=" + rol
                + ", contrasenia=" + contrasenia + ", repContrasenia=" + repContrasenia + ", apellidos=" + apellidos
                + "]";
    }
}
