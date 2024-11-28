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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css">
</head>
<body>

            <form class="login-form" action="inventories" method="get" >
            <a class= "tex">Ingresa los datos:<a>
              <div class="field">
                <label for="name">Producto :  </label>
                <input
                  type="text"
                  name="name"
                  placeholder="Ingresa un nombre de producto a buscar"
                />
              </div>
              <div class="field">
                  <label for="color">Color   :  </label>
                  <input
                    type="text"
                    name="color"
                    placeholder="Ingresa un color de producto a buscar"
                  />
                </div>
                <div class="field">
                    <label for="imei">Imei     :  </label>
                     <input
                      type="long"
                       name="imei"
                       placeholder="ingresa el imei a buscar"
                        />
                </div>

                <div class="bt padding-top--12">
                  <button
                    class="btn btn-darken btn-inline login-btn"
                    type="submit"
                  >
                    Buscar
                  </button>
                </div>
            </form>

    <% List inventories  = (List) request.getAttribute("inventories"); %>


    <div class="fondo">     <form action="">
            <div class="general">
            <div class="btn">


            <a href="administratorOptions"><nav class="atras">Atras</nav></a>
            <a href="moi-java"><nav class="salir">Salir</nav></a>
            </div>
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
                    <td></td>
                     <td></td>
                     <td></td>
                      <td></td>
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


            </div>

        </form>

    </div>


</body>
</html>