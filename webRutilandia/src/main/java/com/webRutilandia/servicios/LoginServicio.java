package com.webRutilandia.servicios;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webRutilandia.dtos.UsuarioDto;

import jakarta.servlet.http.HttpSession;

@Service
public class LoginServicio {
    @Autowired
    private ApiServicio apiServicio;

    public String iniciarSesion(String email, String contrasenia, HttpSession sesion) throws URISyntaxException, IOException {
        UsuarioDto usuarioLogin = new UsuarioDto();
        usuarioLogin.setEmail(email);
        usuarioLogin.setContrasenia(contrasenia);

        // Enviar los datos a la API
        String token = apiServicio.enviarLoginUsuario(usuarioLogin);

        if (token != null) {
            System.out.println("¡Inicio de sesión exitoso!");
            sesion.setAttribute("token", token);
            return "redirect:/index.jsp"; // Redirigir a la página principal
        } else {
            System.out.println("[ERROR] Credenciales incorrectas o fallo en la API.");
            return "redirect:/login?error"; // Redirigir con un mensaje de error
        }
    }
}
