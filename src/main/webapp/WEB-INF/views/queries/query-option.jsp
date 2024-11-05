<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>consultas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/query.css?">
</head>
<body>
<div class="fondo">
    <form action="/buscar" method="get">
        <div class="query">
            <h1 class="Buscar">Buscar</h1>
            <input type="text" name="nombreProducto" id="nombreProducto" placeholder="nombre Producto"><br>
            <input type="text" name="colorProducto" id="colorProducto" placeholder="color producto"><br>
            <input type="number" name="imeiProducto" id="imeiProducto" placeholder="imei Producto"><br>
            <input type="text" name="codigoProducto" id="codigoProducto" placeholder="codigo Producto"><br>
            <input type="reset"><br>
            <input type="submit" value="Buscar"><br>
          </div>

       </div>
       </form>
</body>
</html>