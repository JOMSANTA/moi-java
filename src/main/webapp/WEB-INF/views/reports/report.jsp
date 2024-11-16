<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.ReportModel" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reportes</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css?">
</head>
<body>

<% List reports = (List)  request.getAttribute("reports"); %>

<div class="fondo">
<div class="general">
<h1 class="tabla">Reportes</h1>
<table>
 <tr>
   <th>AAMMDD</th>
   <th>Empleado</th>
   <th>Descripcion</th>
   <th>Postpago</th>
   <th>Prepago</th>
   <th>Tv</th>
   <th>Otros</th>
 </tr>
 <% for (int i = 0; i < reports.size(); i ++) { %>
  <% ReportModel report = (ReportModel) reports.get(i); %>
 <tr>
    <td><%= report.getFecha() %></td>
    <td><%= report.getCodEmpleado() %></td>
    <td><%= report.getDescripcion() %></td>
    <td><%= report.getPostpago() %></td>
    <td><%= report.getPrepago() %></td>
    <td><%= report.getTv() %></td>
    <td><%= report.getOtros() %></td>
 </tr>

  <% } %>

</table>

</div>

</div>

</body>
</html>