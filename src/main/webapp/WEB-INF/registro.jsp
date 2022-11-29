<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
</head>
<body>
    <!-- action= ruta donde enviamos los parametros-->
    <!--method= forma como se envian get y post-->
    <!-- get muestra los paerametros 
    post envia los parametros ocultos
    -->

    <form action="ruta" method="post">
        <label for="nombre">Ingrese Nombre:</label>
        <input type="text" id="nombre" name="nombre">
        <br>
        <label for="apellido">Ingrese Apellido:</label>
        <input type="text" id="apellido" name="apellido">
        <br>
        <label for="correo">Email:</label>
        <input type="email" id="correo" name="correo" placeholder="Ingrese email">
        <br>
        <label for="pass">Password:</label>
        <input type="password" id="pass" name="pass" placeholder="Ingrese password">
        <br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>