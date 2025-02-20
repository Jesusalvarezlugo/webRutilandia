<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/iniciarSesion" method="POST">
    <label for="email">Correo electrónico:</label>
    <input type="email" id="email" name="email" required>

    <label for="contrasenia">Contraseña:</label>
    <input type="password" id="contrasenia" name="contrasenia" required>

    <button type="submit">Iniciar Sesión</button>
</form>
</body>
</html>