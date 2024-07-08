<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>producto</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/productsRegister.css">
</head>
<body>
  <div class="fondo">
    <form action="">
    <div class="general">
        <h1 class="producto">Producto</h1>
        <input type="number" name="idProducto" id="idProducto" placeholder="idProducto"><br>
        <input type="text" name="nombreProducto" id="nombreProducto" placeholder="nombre Producto"><br>
        <input type="text" name="color_producto" id="color_producto" placeholder="color producto"><br>
        <input type="number" name="precioProducto" id="precioProducto" placeholder="precio Producto"><br>
        <input type="number" name="imeiProducto" id="imeiProducto" placeholder="imei Producto"><br>
        <input type="text" name="codigoProducto" id="codigoProducto" placeholder="codigo Producto"><br>
        <label for="fechaLimiteVenta">limite de venta</label>
        <input type="date" name="fechaLimiteVenta" id="fechaLimiteVenta"><br>
        <input type="text" name="tipoProducto" id="tipoProducto" placeholder="tipo Producto"><br>
        <input type="reset"><br>
        <input type="submit" value="Enviar"><br>
        <input type="search" value="Buscar">
      </div>
   </div>
   </form>
</body>
</html>