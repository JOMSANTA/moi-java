<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.PayrollModel" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>insertPayroll</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/insertPayroll.css">

</head>
<body>
 <div class="tod">
    <div class="bna">
     <a href="payrolls"><nav class="atras">Atras</nav></a>
     <a href="moi-java"><nav class="salir">Salir</nav></a>
    </div>
    <div class="fondo">
       <div class="general">
         <form class="pay" action="payrollsInsert" method= "post">
          <div class="ent">
             <table>
               <tr>
                <th>fecha</th>
                <th>codigo</th>
                <th>nombre</th>
                <th>basico</th>
                <th>prepago</th>
                <th>postpago</th>
                <th>detalle</th>
                <th>otros</th>
                <th>subtotal</th>
                <th>total</th>
               </tr>

               <tr>
                <td> <input type="date" name="date" id="date">  </td>
                <td> <input type="text" name="codigo" id="codigo"> </td>
                <td> <input type="text" name="nombre" id="nombre"> </td>
                <td> <input type="int" name="basico" id="basico"> </td>
                <td> <input type="int" name="prepago" id="prepago"> </td>
                <td> <input type="int" name="postpago" id="postpago"> </td>
                <td> <input type="text" name="detalle" id="detalle"> </td>
                <td> <input type="int" name="otros" id="otros"> </td>
                <td> <input type="int" name="subtotal" id="subtotal"> </td>
                <td> <input type="int" name="total" id="total"> </td>
               </tr>
             </table>
          </div>

                 <button class="en" type="submit">Enviar</button>

         </form>

                     <% List payrollsInsert = (List)  request.getAttribute("payrollsInsert"); %>


                      <h1 class="tabla"> Nominas</h1>


             <table>
               <tr>
                 <th>fecha</th>
                 <th>codigo</th>
                 <th>nombre</th>
                 <th>basico</th>
                 <th>prepago</th>
                 <th>postpago</th>
                 <th>detalle</th>
                 <th>otros</th>
                 <th>subtotal</th>
                 <th>total</th>
               </tr>
                  <% for (int i = 0; i < payrollsInsert.size(); i ++) { %>
                  <% PayrollModel payroll = (PayrollModel) payrollsInsert.get(i); %>
               <tr>
                 <td><%= payroll.getDate() %></td>
                 <td><%= payroll.getCodigo() %></td>
                 <td><%= payroll.getNombre() %></td>
                 <td><%= payroll.getBasico() %></td>
                 <td><%= payroll.getPrepago() %></td>
                 <td><%= payroll.getPostpago() %></td>
                 <td><%= payroll.getDetalle() %></td>
                 <td><%= payroll.getOtros() %></td>
                 <td><%= payroll.getSubtotal() %></td>
                 <td><%= payroll.getTotal() %></td>
               </tr>
                   <% } %>

             </table>

          </div>

       </div>
    </div>
  </div>
</body>
</html>