package com.webRutilandia.controladores;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webRutilandia.dtos.UsuarioDto;
import com.webRutilandia.servicios.UsuarioServicio;
import com.webRutilandia.util.Utilidades;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;
    
   
    // Constructor para inyectar UsuarioServicio
    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

   

    /**
     * Método para traer los parametros del formulario y enviar a la api los datos para que los guarde en base de datos
     * @param usuario
     * @param contrasenia
     * @param session
     * @return
     */
    @PostMapping("/registrar")
    public String registrarUsuario(@RequestParam("nombre") String nombre,
                                   @RequestParam("apellido1") String apellido1,
                                   @RequestParam("apellido2") String apellido2,
                                   @RequestParam("email") String email,
                                   @RequestParam("telefono") String telefono,
                                   @RequestParam("rol") String rol,
                                   @RequestParam("contrasenia") String contrasenia,
                                   HttpSession session) {
        // Crear el objeto DTO con los datos recibidos
        UsuarioDto usuarioNuevo = new UsuarioDto();
        usuarioNuevo.setNombre(nombre);
        usuarioNuevo.setApellidos(apellido1 + " " + apellido2); // Concatenación de apellidos
        usuarioNuevo.setEmail(email);
        usuarioNuevo.setTelefono(telefono);
        usuarioNuevo.setRol(rol);
        usuarioNuevo.setContrasenia(Utilidades.encriptarContrasenia(contrasenia)); // Encriptar contraseña

        try {
            // Llamar al servicio para registrar el usuario
            usuarioServicio.enviarRegistroUsuario(usuarioNuevo, session);
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // Si ocurre algún error, redirige a una página de error
        }

        // Redirigir a la página de éxito después de un registro exitoso
        return "redirect:/login.jsp"; // Nombre de la página de éxito (exito.jsp)
    }
    
    @PutMapping("/modificar")
    public String modificarUsuario(@RequestParam("nombre") String nombre,
                                   @RequestParam("apellido1") String apellido1,
                                   @RequestParam("apellido2") String apellido2,
                                   @RequestParam("email") String email,
                                   @RequestParam("telefono") String telefono,
                                   @RequestParam(value = "nuevaContrasenia", required = false) String nuevaContrasenia,
                                   @RequestParam(value = "repNuevaContrasenia", required = false) String repNuevaContrasenia,
                                   @RequestParam(value = "contraseniaActual", required = false) String contraseniaActual,
                                   HttpSession session) throws IOException, URISyntaxException {

        // Obtener el usuario desde la sesión para realizar la modificación
        UsuarioDto usuario = (UsuarioDto) session.getAttribute("usuario");

        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido1: " + apellido1);
        System.out.println("Apellido2: " + apellido2);
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + telefono);
        
        // Si no hay usuario en sesión, redirigir a login
        if (usuario == null) {
            return "redirect:/login.jsp"; // Si el usuario no está autenticado, redirige al login
        }

        // Validar si el email está siendo usado por otro usuario
        if (!email.equals(usuario.getEmail()) && usuarioServicio.emailExiste(email)) {
            return "redirect:/errorEmailExistente.jsp"; // Redirige a una página de error si el email ya existe
        }
        
        // Si se quiere cambiar la contraseña
        if (nuevaContrasenia != null && !nuevaContrasenia.isEmpty()) {
            // Verificar que se haya proporcionado la contraseña actual
            if (contraseniaActual == null || contraseniaActual.isEmpty()) {
                return "redirect:/errorContraseniaIncorrecta.jsp";
            }
            // Verificar que la contraseña actual sea correcta
            if (!usuarioServicio.verificarContrasenia(usuario.getEmail(), contraseniaActual)) {
                return "redirect:/errorContraseniaIncorrecta.jsp";
            }
            // Verificar que la nueva contraseña coincida con su confirmación
            if (!nuevaContrasenia.equals(repNuevaContrasenia)) {
                return "redirect:/errorContraseniaNoCoincide.jsp";
            }
            // Encriptar la nueva contraseña y actualizar
            usuario.setContrasenia(Utilidades.encriptarContrasenia(nuevaContrasenia));
        }

        // Actualizar los demás campos del usuario
        usuario.setNombre(nombre);
        usuario.setApellidos(apellido1 + " " + apellido2);
        usuario.setEmail(email);
        usuario.setTelefono(telefono);

        // Enviar los datos a la API para actualizar el usuario
        try {
            String respuesta = usuarioServicio.actualizarUsuario(usuario);
            if ("success".equals(respuesta)) {
                return "redirect:/exito.jsp"; // Actualización exitosa
            } else {
                return "redirect:/errorActualizacion.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error.jsp";
        }
    }


}
