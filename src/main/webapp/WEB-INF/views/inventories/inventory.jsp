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
      <td> <input type="int" name="imei" id="imei"> </td>
      <td> <input type="text" name="code" id="code"> </td>
      <td> <input type="date" name="coming" id="coming"> </td>
      <td> <input type="int" name="quantity" id="quantity"> </td>
      <td> <input type="text" name="type" id="type"> </td>
      </tr>
      </table>
      </div>

     <button class="en" type="submit">insertar</button>
       </form>

    <% List inventories  = (List) request.getAttribute("inventories"); %>

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
                    <th>Acciones</th>

                </tr>
                    <% for (int i = 0; i < inventories.size(); i ++) { %>
                 <% InventoryModel inventory = (InventoryModel) inventories.get(i); %>

            <tr>
                    <td><%= inventory.getName() %></td>
                    <td><%= inventory.getColor() %></td>
                    <td><%= inventory.getImei() %></td>
                    <td><%= inventory.getCode() %></td>
                     <td><%= inventory.getComing() %></td>
                     <td><%= inventory.getQuantity() %></td>
                     <td><%= inventory.getType() %></td>
                       <td>
                           <form action="inventories" method="post">
                               <input type="hidden" name="action" value="delete">
                               <input type="hidden" name="id" value="<%= inventory.getIdProduct() %>">
                               <div>
                                   <button type="submit">Delete</button>
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