<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.AccountingModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>contabilidad</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css?">
</head>
<body>
 <div class="tod">
    <div class="bna">
     <a href="manager"><nav class="atras">Atras</nav></a>
     <a href="moi-java"><nav class="salir">Salir</nav></a>
    </div>
    <div class="fondo">
           <div class="general">
             <form class="pay" action="accounting" method= "post">
              <div class="ent">
  <table>
                 <tr>
                  <th>AAMMDD</th>
                    <th>Factura</th>
                    <th>Descripcion</th>
                    <th>Detalle</th>
                    <th>Cant</th>
                    <th>Ingresos</th>
                    <th>Egresos</th>
                    <th>Total</th>
                 </tr>

                 <tr>
                  <td> <input type="date" name="date" id="date">  </td>
                  <td> <input type="int" name="invoice" id="invoice"> </td>
                  <td> <input type="text" name="description" id="description"> </td>
                  <td> <input type="text" name="detail" id="detail"> </td>
                  <td> <input type="int" name="quantity" id="quantity"> </td>
                  <td> <input type="int" name="income" id="income"> </td>
                  <td> <input type="int" name="expenses" id="expenses"> </td>
                  <td> <input type="int" name="total" id="total"> </td>
                 </tr>
               </table>
            </div>

            <button class="en" type="submit">Enviar</button>

             </form>

<% List accounting = (List)  request.getAttribute("accounting"); %>

<h1 class="tabla"> Contabilidad</h1>


<table>
 <tr>
   <th>AAMMDD</th>
   <th>Factura</th>
   <th>Descripcion</th>
   <th>Detalle</th>
   <th>Cant</th>
   <th>Ingresos</th>
   <th>Egresos</th>
   <th>Total</th>
 </tr>
 <% for (int i = 0; i < accounting.size(); i ++) { %>
  <% AccountingModel account = (AccountingModel) accounting.get(i); %>
 <tr>
    <td><%= account.getDate() %></td>
    <td><%= account.getInvoice() %></td>
    <td><%= account.getDescription() %></td>
    <td><%= account.getDetail() %></td>
    <td><%= account.getQuantity() %></td>
    <td><%= account.getIncome() %></td>
    <td><%= account.getExpenses() %></td>
    <td><%= account.getTotal() %></td>
 </tr>

  <% } %>

</table>

</div>
</div>
</div>
</div>
</body>
</html>