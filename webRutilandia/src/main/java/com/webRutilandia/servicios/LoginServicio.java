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
    @Autowired 
    UsuarioServicio usuarioServicio;

    public String iniciarSesion(String email, String contrasenia, HttpSession sesion) throws URISyntaxException, IOException {
        UsuarioDto usuarioLogin = new UsuarioDto();
        usuarioLogin.setEmail(email);
        usuarioLogin.setContrasenia(contrasenia);
        
        // Enviar los datos a la API para autenticación y obtener el token
        String token = apiServicio.enviarLoginUsuario(usuarioLogin);

        if (token != null) {
            System.out.println("¡Inicio de sesión exitoso!");
            sesion.setAttribute("token", token);
            // Llamar al método en UsuarioServicio para obtener los detalles completos del usuario
            UsuarioDto usuarioCompleto = usuarioServicio.obtenerDetallesUsuario(email, token);
            if (usuarioCompleto != null) {
                sesion.setAttribute("usuario", usuarioCompleto);
            } else {
                System.out.println("[ERROR] No se pudieron obtener los detalles del usuario.");
                return "redirect:/login?error";
            }
            return "redirect:/index.jsp";
        } else {
            System.out.println("[ERROR] Credenciales incorrectas o fallo en la API.");
            return "redirect:/login?error";
        }
    }
}
