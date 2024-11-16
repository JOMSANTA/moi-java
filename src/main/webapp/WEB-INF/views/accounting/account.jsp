<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.AccountingModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>contabilidad</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css?">
</head>
<body>

<% List accounting = (List)  request.getAttribute("accounting"); %>

<div class="fondo">
<div class="general">
<h1 class="tabla">Contabilidad</h1>
<table>
 <tr>
   <th>AAMMDD</th>
   <th>Factura</th>
   <th>Descripcion</th>
   <th>Detalle</th>
   <th>Cant</th>
   <th>Ingresos</th>
   <th>Egresos</th>
   <th>Total</th>
 </tr>
 <% for (int i = 0; i < accounting.size(); i ++) { %>
  <% AccountingModel account = (AccountingModel) accounting.get(i); %>
 <tr>
    <td><%= account.getFecha() %></td>
    <td><%= account.getFactura() %></td>
    <td><%= account.getDescripcion() %></td>
    <td><%= account.getDetalle() %></td>
    <td><%= account.getCantidad() %></td>
    <td><%= account.getIngresos() %></td>
    <td><%= account.getEgresos() %></td>
    <td><%= account.getTotal() %></td>
 </tr>

  <% } %>

</table>

</div>

</div>

</body>
</html>