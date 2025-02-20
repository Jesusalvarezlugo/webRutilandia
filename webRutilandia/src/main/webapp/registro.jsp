<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de registro</title>
</head>
<body>
	<body>
	<form action="/registrar" method="POST">
        
        <!-- Nombre -->
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        
        <!-- Apellido 1 -->
        <label for="apellido1">Primer Apellido:</label>
        <input type="text" id="apellido1" name="apellido1" required>
        
        <!-- Apellido 2 -->
        <label for="apellido2">Segundo Apellido:</label>
        <input type="text" id="apellido2" name="apellido2" required>
        
        <!-- Email -->
        <label for="email">Correo Electrónico:</label>
        <input type="email" id="email" name="email" required>
        
        <!-- Teléfono -->
        <label for="telefono">Teléfono:</label>
        <input type="tel" id="telefono" name="telefono" required>
        
        <!-- Contraseña -->
        <label for="contrasenia">Contraseña:</label>
        <input type="password" id="contrasenia" name="contrasenia" required>
        
        <!-- Confirmar Contraseña -->
        <label for="repContrasenia">Repetir Contraseña:</label>
        <input type="password" id="repContrasenia" name="repContrasenia" required>

        <!-- Rol (Admin o Usuario) -->
        <label for="rol">Rol:</label>
        <select id="rol" name="rol" required>
            <option value="usuario">Usuario</option>
            <option value="admin">Administrador</option>
        </select>
        
        <!-- Botón de Registro -->
        <button type="submit">Registrarse</button>
    
    </form>
</body>
</html>