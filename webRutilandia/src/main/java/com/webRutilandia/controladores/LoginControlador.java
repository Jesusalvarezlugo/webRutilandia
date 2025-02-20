package com.webRutilandia.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webRutilandia.servicios.LoginServicio;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginControlador {

    private final LoginServicio loginServicio;

    // Inyectar el servicio LoginServicio, no ApiServicio
    @Autowired
    public LoginControlador(LoginServicio loginServicio) {
        this.loginServicio = loginServicio;
    }

    @PostMapping("/iniciarSesion")
    public String iniciarSesion(@RequestParam("email") String email,
                                @RequestParam("contrasenia") String contrasenia,
                                HttpSession sesion) {
        try {
            // Usar loginServicio para iniciar sesión
             loginServicio.iniciarSesion(email, contrasenia, sesion);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login?error";
        }
        
        return "redirect:/exito.jsp";
    }
}
