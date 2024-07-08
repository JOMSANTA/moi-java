<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedidos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pedidos.css">
</head>
<body>
    <div class="fondo">
    <div class="general">
        <h1 class="pedidos">Pedidos</h1>
        <h2 class="sucursal">sucursal</h2>
        <input type="date" name="fecha" id="fecha" placeholder="dd-mm-aaaa" class="fecha"><br><br>
        <input type="text" name="sucursal" id="sucursal" placeholder="nombre sucursal" class="sucursal"><br><br>
        <textarea name="asunto" id="asunto" placeholder="asunto" class="asunto"></textarea><br>
        <input type="submit" value="enviar" class="enviar">


    </div>
    </div>
</body>
</html>