<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.InventoryModel" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventario</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css?">
</head>
<body>
<div class="tod">
<div class="bna">
<a href="searchs"><nav class="insert">Buscar</nav></a>
 <a href=""><nav class="atras">Atras</nav></a>
<a href="moi-java"><nav class="salir">Salir</nav></a>
 </div>
<div class="fondo">
<div class="general">
<form action="inventories" method="post">
<div class="ent">
   <table>
      <tr>
      <th>producto</th>
      <th>color</th>
      <th>imei </th>
      <th>codigo</th>
      <th>vencimiento</th>
      <th>cant </th>
      <th>tipo</th>
      </tr>

      <tr>
      <td> <input type="text" name="name" id="name"> </td>
      <td> <input type="text" name="color" id="color"> </td>
      <td>
          <div id="imeiContainer">
              <input type="text" name="imeiProducto" placeholder="IMEI">
          </div>
          <button type="button" onclick="addImeiField()">Agregar otro IMEI</button>
      </td>

      <td> <input type="text" name="code" id="code"> </td>
      <td> <input type="date" name="coming" id="coming"> </td>
      <td> <input type="number" name="quantity" id="quantity"> </td>
      <td> <input type="text" name="type" id="type"> </td>
      </tr>
      </table>
      </div>

     <button class="en" type="submit">insertar</button>
       </form>

       <%-- Mensaje de exito --%>
       <%
           String successMessage = (String) session.getAttribute("success");
           if (successMessage != null) {
       %>
           <div style="color: green; font-weight: bold; margin: 10px 0;"><%= successMessage %></div>
       <%
               session.removeAttribute("success");
           }
       %>

       <%-- Mensaje de error--%>
       <%
           String errorMessage = (String) request.getAttribute("error");
           if (errorMessage != null) {
       %>
           <div style="color: red; font-weight: bold; margin: 10px 0;"><%= errorMessage %></div>
       <%
           }
       %>



<h1 class="tabla"> Inventario sucursal</h1>
            <table>
            <tr>
                    <th>producto</th>
                    <th>color</th>
                    <th>imei  </th>
                    <th>codigo</th>
                    <th>vencimiento</th>
                    <th>cant</th>
                    <th>tipo</th>


                </tr>
<%
    List<InventoryModel> inventories = (List<InventoryModel>) request.getAttribute("inventories");
    if (inventories != null && !inventories.isEmpty()) {
        for (InventoryModel inventory : inventories) {
%>
    <tr>
        <td><%= inventory.getName() %></td>
        <td><%= inventory.getColor() %></td>
        <td>
            <%
                List<String> imeis = inventory.getImeis();
                if (imeis != null && !imeis.isEmpty()) {
                    for (String im : imeis) {
            %>
                        <div><%= im %></div>
            <%
                    }
                } else {
            %>
                    <div>Sin IMEIs</div>
            <%
                }
            %>
        </td>
        <td><%= inventory.getCode() %></td>
        <td><%= inventory.getComing() %></td>
        <td><%= inventory.getQuantity() %></td>
        <td><%= inventory.getType() %></td>
    </tr>
<%
        }
    } else {
%>
    <tr><td colspan="8">No hay productos en el inventario.</td></tr>
<%
    }
%>
</table>
</div>
</div>
</div>

<!-- JS para agregar campos IMEI -->
<script>
    function addImeiField() {
        const container = document.getElementById("imeiContainer");
        const input = document.createElement("input");
        input.type = "text";
        input.name = "imeiProducto";
        input.placeholder = "IMEI";
        container.appendChild(document.createElement("br"));
        container.appendChild(input);
    }
</script>
</body>
</html>