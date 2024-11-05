<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.InventoryModel" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventario</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css?">
</head>
<body>

    <% List inventories  = (List) request.getAttribute("inventories"); %>

    <div class="fondo">
        <form action="">
            <div class="general">
            <h1 class="tabla"> Inventario sucursal</h1>
            <table>

                <tr>
                    <th>producto</th>
                    <th>color</th>
                    <th>imei </th>
                    <th>codigo</th>
                    <th>fechaven</th>
                    <th>cant</th>
                </tr>
                <% for (int i = 0; i < inventories.size(); i++) { %>
                <% InventoryModel inventory = (InventoryModel) inventories.get(i); %>
                <tr>
                    <td><%= inventory.getProducto() %></td>
                    <td><%= inventory.getColor() %></td>
                    <td><%= inventory.getImei() %></td>
                    <td><%= inventory.getCodigo() %></td>
                     <td><%= inventory.getFechaLimiteVentas() %></td>
                     <td><%= inventory.getNumeroExistencias() %></td
                </tr>
                <% } %>
            </table><a href="queries"><nav class="buscar">Buscar</nav></a>
            </table><a href=""><nav class="agregar">Agregar</nav></a>
            </table><a href=""><nav class="actualizar">Actualizar</nav></a>
            </div>

        </form>
    </div>


</body>
</html>