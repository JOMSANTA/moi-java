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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/insertPayroll.css">
</head>
<body>
 <div class="tod">
      <div class="bna">

      <a href="moi-java"><nav class="salir">Salir</nav></a>
      </div>
  <div class="fondo">
      <div class="general">
        <form class="login-form" action="inventories" method="get" >
           <div class="ent">
             <table>

                            <tr>
                                <th>producto</th>
                                <th>color</th>
                                <th>imei </th>
                                <th>codigo</th>
                                <th>fechaven</th>
                                <th>cant</th>
                                <th>tipo</th>


                            </tr>
                             <tr>

                              <td> <input type="text" name="product" id="product"> </td>
                              <td> <input type="text" name="color" id="color"> </td>
                              <td> <input type="long" name="imei" id="imei"> </td>
                              <td> <input type="int" name="code" id="code"> </td>
                              <td> <input type="date" name="coming" id="coming"> </td>
                              <td> <input type="int" name="quantity" id="quantity"> </td>
                              <td> <input type="text" name="type" id="type"> </td>
                             </tr>

             </table>
           </div>
              <button class="en" type="submit">Enviar</button>
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

                </tr>
                <% } %>

            </table>




      </div>
  </div>

</body>
</html>