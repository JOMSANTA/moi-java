<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.InventoryModel" %>
<%@ page import="com.moi.model.SearchModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buscar</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css?">
</head>
<body>

<div class="tod">
<div class="bna">

 <a href="inventories"><nav class="atras">Atras</nav></a>
<a href="moi-java"><nav class="salir">Salir</nav></a>
 </div>
<div class="fondo">
<div class="general">
<form action="searchs" method="post">
<div class="ent">
   <table>
      <tr>
      <th>producto</th>
      <th>color</th>
      <th>imei </th>
      <th>codigo</th>


      </tr>

      <tr>
      <td> <input type="text" name="name" id="name"> </td>
      <td> <input type="text" name="color" id="color"> </td>
      <td> <input type="int" name="imei" id="imei"> </td>
      <td> <input type="text" name="code" id="code"> </td>

      </tr>
      </table>
      </div>

     <button class="en" type="submit">Buscar</button>
       </form>




<h1 class="tabla"> Busqueda</h1>
            <table>
            <tr>
                    <th>producto</th>
                    <th>color</th>
                    <th>imei </th>
                    <th>codigo</th>
                    <th>vencimiento</th>
                    <th>cant</th>
                    <th>tipo</th>
            </tr>
 <%
                    List<SearchModel> searchs = (List<SearchModel>) request.getAttribute("searchs");
                    if (searchs != null && !searchs.isEmpty()) {
                        for (SearchModel search : searchs) {
                %>
                         <tr>
                                 <td><%= search.getName() %></td>
                                 <td><%= search.getColor() %></td>
                                 <td><%= search.getImei() %></td>
                                 <td><%= search.getCode() %></td>
                                  <td><%= search.getComing() %></td>
                                  <td><%= search.getQuantity() %></td>
                                  <td><%= search.getType() %></td>

                             </tr>

                             <%
                                                     }
                                                 } else {
                                             %>
                                                 <tr><td colspan="7">No se encontraron resultados</td></tr>

                             <% } %>
                          </table>

            </div>

         </div>

    </div>
 </div>

</body>
</html>