<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.PayrollModel" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payroll</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/payroll.css">

</head>


<body>
<div class="bna">
<a href="payrollsInsert"><nav class="insert">Insertar</nav></a>
<a href="manager"><nav class="atras">Atras</nav></a>
<a href="moi-java"><nav class="salir">Salir</nav></a>
</div>
<% List payrolls = (List)  request.getAttribute("payrolls"); %>

<div class="fondo">
<div class="general">
<h1 class="tabla"> Nominas</h1>
<table>
 <tr>
   <th>fecha</th>
      <th>codigo empleado</th>
      <th>nombre</th>
      <th>basico</th>
      <th>prepago</th>
      <th>postpago</th>
      <th>detalle</th>
      <th>otros</th>
      <th>subtotal</th>
       <th>total</th>
 </tr>
 <% for (int i = 0; i < payrolls.size(); i ++) { %>
 <% PayrollModel payroll = (PayrollModel) payrolls.get(i); %>
 <tr>
    <td><%= payroll.getDate() %></td>
        <td><%= payroll.getCodigo() %></td>
        <td><%= payroll.getNombre() %></td>
        <td><%= payroll.getBasico() %></td>
        <td><%= payroll.getPrepago() %></td>
        <td><%= payroll.getPostpago() %></td>
        <td><%= payroll.getDetalle() %></td>
        <td><%= payroll.getOtros() %></td>
        <td><%= payroll.getSubtotal() %></td>
        <td><%= payroll.getTotal() %></td>
 </tr>
  <% } %>

</table>

</div>

</div>
</body>
</html>