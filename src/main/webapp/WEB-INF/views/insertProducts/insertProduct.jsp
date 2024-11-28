<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Producto</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/insertProducts.css?">
</head>
<body>
  <div class="fondo">
    <form action="insertProducts" method="post" >
    <div class="general">
        <h1 class="producto">Producto</h1>
        <input type="text" name="producto" id="producto" placeholder="producto"><br>
        <input type="text" name="color" id="color" placeholder="color producto"><br>
        <input type="int" name="numeroExistencias" id="numeroExistencias" placeholder="cantidad"><br>
        <input type="text" name="codigo" id="codigo" placeholder="codigo Producto"><br>
        <input type="long" name="imei" id="imei" placeholder="imei"><br>
        <label for="fechaLimiteVenta">limite de venta</label>
        <input type="date" name="fechaLimiteVenta" id="fechaLimiteVenta"><br>
        <input type="text" name="tipoDeProducto" id="tipoDeProducto" placeholder="tipo Producto"><br>
        <input class="env" type="submit" value="Enviar"><br>
         <input type="reset"><br>


<div class="ex">
 <a href="inventories"><nav class="Atras">Atras</nav></a>
 <a href="moi-java"><nav class="Salir">Salir</nav></a>
 </div>

</div>
   </form>
</body>
</html>