<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page language="java" import="java.util.*, java.text.SimpleDateFormat" %>
<%@ page import="com.moi.model.InventoryModel" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>vencimientos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css">

 <style>
        .vencido { background-color: #FF6347; } /* Rojo para productos vencidos */
        .diez { background-color: #FFA500; }   /* Naranja para productos a 10 días de vencer */
        .cinco { background-color: #FFFF00; }  /* Amarillo para productos a 5 días de vencer */
    </style>

</head>
<body>

<%
    // Obtener el atributo productList desde el request
    List<InventoryModel> productList = (List<InventoryModel>) request.getAttribute("productList");

 // Obtener la fecha actual
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date currentDate = new Date(); // Fecha actual

    // Ordenar la lista por fecha de vencimiento en orden descendente
    if (productList != null && !productList.isEmpty()) {
        Collections.sort(productList, new Comparator<InventoryModel>() {
            public int compare(InventoryModel o1, InventoryModel o2) {
                try {
                    Date date1 = sdf.parse(o1.getComing());
                    Date date2 = sdf.parse(o2.getComing());
                    return date2.compareTo(date1); // Orden descendente
                } catch (Exception e) {
                    return 0;
                }
            }
        });
    }

%>
    <div class="fondo">
        <form action="comings" method= "post">
            <div class="general">
            <table><thead><tr>
            <th class= "diez">proximo 10 dias</th>
            <th class= "cinco">muy proximo 5 dias</th>
             <th class= "vencido">vencido</th></tr></thead></table>
               <h1 class="tabla"> Vencimientos</h1>
                <table>
                <thead>
                  <tr>

                    <th>fecha vencimiento</th>
                    <th>imei producto</th>
                    <th> producto</th>
                  </tr>
                </thead>

                <tbody>
 <!--iterar productos-->
                     <%
                        if (productList != null && !productList.isEmpty()) {
                          for (InventoryModel inventory : productList) {

      // Obtener la fecha de vencimiento del producto
   String comingDateStr = inventory.getComing();
    Date comingDate = null;
    String rowClass = "";

    try{
    //pasar de string a date
    comingDate = sdf.parse(comingDateStr);

    // Calcular la diferencia de días entre la fecha de vencimiento y la fecha actual
    long diffInMillies = comingDate.getTime() - currentDate.getTime();
    long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);



    // Determinar la clase según la fecha de vencimiento
    if (diffInDays < 0) {
        rowClass = "vencido";  // Producto vencido
    } else if (diffInDays <= 5) {
    rowClass = "cinco";  // Producto a 5 días de vencer
    } else if (diffInDays <= 10 && diffInDays >5) {
    rowClass = "diez";  // Producto a 10 días de vencer
    }

    }catch(Exception e) {
    //si hay error en conv fecha
    rowClass ="Vencido";
    }

    %>
  <tr class="<%= rowClass %>">
  <td><%= inventory.getComing() %></td>
  <td><%= inventory.getImei() %></td>
  <td><%= inventory.getName() %></td>
  </tr>
  <%
   }
      } else {
   %>
   <tr>
        <td colspan="3">No hay productos para mostrar</td>
     </tr>
     <%
         }
      %>
   </tbody>


        </table>
    </div>
   </form>
  </div>


</body>
</html>