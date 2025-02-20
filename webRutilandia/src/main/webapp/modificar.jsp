<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Usuario</title>
</head>
<body>
	
	<h2>Modificar Perfil</h2>

    <%-- Mensajes de error o éxito --%>
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>

    <c:if test="${not empty mensaje}">
        <p style="color:green;">${mensaje}</p>
    </c:if>

    <form action="/modificar" method="POST">
    
    <input type="hidden" name="_method" value="PUT">
        <!-- Nombre -->
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${usuario.nombre}">

        <!-- Apellido 1 -->
        <label for="apellido1">Primer Apellido:</label>
        <input type="text" id="apellido1" name="apellido1" value="${usuario.apellido1}">

        <!-- Apellido 2 -->
        <label for="apellido2">Segundo Apellido:</label>
        <input type="text" id="apellido2" name="apellido2" value="${usuario.apellido2}">

        <!-- Teléfono -->
        <label for="telefono">Teléfono:</label>
        <input type="tel" id="telefono" name="telefono" value="${usuario.telefono}">

        <!-- Email (Solo lectura) -->
        <label for="email">Correo Electrónico:</label>
        <input type="email" id="email" name="email" value="${usuario.email}" readonly>

        <!-- Nueva Contraseña -->
        <label for="contrasenia">Nueva Contraseña:</label>
        <input type="password" id="contrasenia" name="contrasenia">

        <!-- Confirmar Nueva Contraseña -->
        <label for="repContrasenia">Confirmar Nueva Contraseña:</label>
        <input type="password" id="repContrasenia" name="repContrasenia">

        <!-- Contraseña Actual (Obligatoria si se cambia la contraseña) -->
        <label for="contrasenia">Contraseña Actual:</label>
        <input type="password" id="contrasenia" name="contrasenia">
        
        

        <!-- Botón de Modificar -->
        <button type="submit">Modificar</button>
    </form>
</body>
</html>