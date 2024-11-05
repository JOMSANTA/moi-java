<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.PayrollModel" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payroll</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css?">

</head>
<body>

<% List payrolls = (List)  request.getAttribute("payrolls"); %>

<div class="fondo">
<div class="general">
<h1 class="tabla"> Nominas</h1>
<table>
 <tr>
   <th>documento</th>
   <th>codigo</th>
   <th>nombre</th>
   <th>basico</th>
   <th>prepago</th>
   <th>postpago</th>
   <th>otros</th>
   <th>subtotal</th>
    <th>total</th>
 </tr>
 <% for (int i = 0; i < payrolls.size(); i ++) { %>
 <% PayrollModel payroll = (PayrollModel) payrolls.get(i); %>
 <tr>
    <td><%= payroll.getDocumento() %></td>
    <td><%= payroll.getCodigo() %></td>
    <td><%= payroll.getNombre() %></td>
    <td><%= payroll.getBasico() %></td>
    <td><%= payroll.getPrepago() %></td>
    <td><%= payroll.getPostpago() %></td>
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