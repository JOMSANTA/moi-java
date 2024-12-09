<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.InventoryModel" %>
<%@ page import="com.moi.model.ProductModel" %>

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
<a href="insertProducts"><nav class="insert">Insertar</nav></a>

<a href="moi-java"><nav class="salir">Salir</nav></a>
 </div>
<div class="fondo">
<div class="general">
<form action="">
<div class="ent">
   <table>
      <tr>
      <th>producto</th>
      <th>color</th>
      <th>imei </th>
      <th>codigo</th>
      </tr>

      <tr>
      <td> <input type="text" name="name" id="codigo"> </td>
      <td> <input type="text" name="color" id="color"> </td>
      <td> <input type="int" name="imei" id="imei"> </td>
      <td> <input type="text" name="code" id="code"> </td>
      </tr>
      </table>
      </div>

     <button class="en" type="submit">buscar</button>
       </form>

    <% List inventories  = (List) request.getAttribute("inventories"); %>

<h1 class="tabla"> Inventario sucursal</h1>
            <table>
            <tr>
                    <th>producto</th>
                    <th>color</th>
                    <th>imei </th>
                    <th>codigo</th>
                    <th>fechaven</th>
                    <th>cant</th>
                    <th>tipo</th>
                    <th>Acciones</th>

                </tr>
                <% for (int i = 0; i < inventories.size(); i++) { %>
                <% InventoryModel inventory = (InventoryModel) inventories.get(i); %>
                <tr>
                    <td><%= inventory.getProduct().getName() %></td>
                    <td><%= inventory.getProduct().getColor() %></td>
                    <td><%= inventory.getProduct().getImei() %></td>
                    <td><%= inventory.getProduct().getCode() %></td>
                     <td><%= inventory.getProduct().getComing() %></td>
                     <td><%= inventory.getQuantity() %></td>
                     <td><%= inventory.getProduct().getType() %></td>
                       <td>
                        <form action="inventories" method="post">
                         <div>
                           <input
                             type="text"
                             name="productId"
                             value=<%= inventory.getId() %>
                             hidden
                           />
                         </div>
                           <div>
                             <button
                               type="submit"
                               value="DELETE"
                             >
                               Delete
                             </button>
                           </div>
                        </form>
                       </td>
                </tr>
                <% } %>
             </table>

            </div>

         </div>

    </div>
 </div>

</body>
</html>