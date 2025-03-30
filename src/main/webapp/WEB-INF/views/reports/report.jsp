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

<div class="tod">
    <div class="bna">
     <a href="payrolls"><nav class="atras">Atras</nav></a>
     <a href="moi-java"><nav class="salir">Salir</nav></a>
    </div>
    <div class="fondo">
       <div class="general">
         <form class="pay" action="reports" method= "post">
          <div class="ent">
<table>
 <tr>
   <th>Fecha</th>
      <th>Sucursal</th>
      <th>Postpago</th>
      <th>Kid contado</th>
      <th>Kid cuotas</th>
      <th>tv</th>
      <th>Otros</th>
      <th>Cant</th>
 </tr>
 <tr>
                <td> <input type="date" name="date" id="date"> </td>
                <td> <input type="text" name="sucursal" id="sucursal"> </td>
                <td> <input type="int" name="postpago" id="postpago"> </td>
                <td> <input type="int" name="kitContado" id="kitContado"> </td>
                <td> <input type="int" name="kitCuotas" id="KitCuotas"> </td>
                 <td> <input type="int" name="tv" id="tv"> </td>
                <td> <input type="text" name="otros" id="otros"> </td>
                <td> <input type="int" name="quantity" id="quantity"> </td>
               </tr>
             </table>

             </div>
             <button class="en" type="submit">Enviar</button>
          </form>


<% List reports = (List)request.getAttribute("reports"); %>

<h1 class="tabla"> Reporte de Ventas</h1>
<table>
<tr>
  <th>Fecha</th>
    <th>Sucursal</th>
    <th>Postpago</th>
    <th>Kid contado</th>
    <th>Kid cuotas</th>
    <th>tv</th>
    <th>Otros</th>
    <th>Cant</th>
 </tr>

 <% for (int i = 0; i < reports.size(); i ++) { %>
  <% ReportModel report = (ReportModel) reports.get(i); %>


 <tr>
    <td><%= report.getDate() %></td>
    <td><%= report.getSucursal() %></td>
    <td><%= report.getPostpago() %></td>
    <td><%= report.getKitContado() %></td>
    <td><%= report.getKitCuotas() %></td>
    <td><%= report.getTv() %></td>
    <td><%= report.getOtros() %></td>
    <td><%= report.getQuantity() %></td>
 </tr>

  <% } %>

</table>

</div>
</div>
</div>
</div>
</body>
</html>