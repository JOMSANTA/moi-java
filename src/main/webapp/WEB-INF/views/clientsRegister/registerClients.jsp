<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>cliente</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/clientsRegister.css">
</head>
<body>
  <div class="fondo">
    <form action="/validar">
    <div class="general">
        <h1 class="factura">Cliente</h1>
        <input type="number" name="idcliente_num_documento" id="idcliente_num_documento" placeholder="id Cliente numero documento"><br>
        <input type="text" name="nombre_cliente" id="nombre_cliente" placeholder="Nombre Cliente"><br>
        <input type="text" name="apellido" id="apellido" placeholder="Apellido"><br>
        <input type="email" name="correo" id="correo" placeholder="Correo electronico"><br>
        <input type="text" name="direccion" id="direccion" placeholder="Direccion residencia"><br>
        <input type="reset" ><br>
        <input type="submit" value="Enviar"></div>
   </div>

</body>
</form>
</html>