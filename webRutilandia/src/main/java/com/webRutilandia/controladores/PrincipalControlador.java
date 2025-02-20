package com.webRutilandia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalControlador {

	@GetMapping("/")
    public String home() {
        return "index.jsp"; // Esto devuelve el archivo index.jsp
    }
}
