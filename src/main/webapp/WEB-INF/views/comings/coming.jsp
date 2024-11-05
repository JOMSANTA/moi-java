<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.InventoryModel" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>vencimientos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css">
</head>
<body>

<% List inventories  = (List) request.getAttribute("inventories"); %>

    <div class="fondo">
        <form action="">
            <div class="general">
               <h1 class="tabla"> Vencimientos</h1>
                <table>
                  <tr>

                    <th>fecha vencimiento</th>
                    <th>imei producto</th>
                    <th> producto</th>
                  </tr>
                   <% for (int i = 0; i < inventories.size(); i++) { %>
                                <% InventoryModel inventory = (InventoryModel) inventories.get(i); %>
                                <tr>
                                    <td><%= inventory.getFechaLimiteVentas() %></td>
                                    <td><%= inventory.getImei() %></td>
                                    <td><%= inventory.getProducto() %></td>
                                </tr>
                                <% } %>




                </table>
            </div>
        </form>
    </div>


</body>
</html>