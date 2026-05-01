<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.ClientModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>cliente</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/clientsRegister.css?">
</head>
<body>
<% if (request.getAttribute("errorMessage") != null) { %>
<p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
<% } else if (request.getAttribute("successMessage") != null) { %>
<p style="color: green;"><%= request.getAttribute("successMessage") %></p>
<% } %>
  <div class="fondo">
    <form action= "clients" method= "post">
   <div class="general">
        <h1 class="factura">Cliente</h1>
        <input type="number" name="idClient" id="idClient" placeholder="Numero documento"><br>
        <input type="text" name="name" id="name" placeholder="Nombre Cliente"><br>
        <input type="text" name="lastName" id="lastName" placeholder="Apellido"><br>
        <input type="number" name="cel" id="cel" placeholder= "celular"><br>
        <input type="email" name="email" id="email" placeholder="Correo electronico"><br>
        <input type="text" name="adress" id="adress" placeholder="Direccion residencia"><br>
        <input type="submit" value="Enviar" class= "en"><br>
        <input type="reset"  value= "Reset" class= "rs"></div>


   </div>
</form>

</body>

</html>