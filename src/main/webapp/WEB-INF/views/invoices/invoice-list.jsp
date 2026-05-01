<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
               <html lang="en">
               <head>
                   <meta charset="UTF-8">
                   <meta name="viewport" content="width=device-width, initial-scale=1.0">
                   <title>factura</title>
                   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/invoices.css">
               </head>
               <body>
               <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
               <c:if test="${not empty loginMessage}">
                   <p style="color:green;">${loginMessage}</p>
               </c:if>

               <div class="tod">
                   <div class="bna">
                   <a href=""><nav class="search">Buscar</nav></a>
                    <a href="clients"><nav class="atras">Registrar</nav></a>
                    <a href="moi-java"><nav class="salir">Salir</nav></a>
                   </div>

                  <div class="fondo">

                          <form class="pay" action="invoices" method= "post">
                          <div class="general">


                     <h1 class="factura">Factura</h1>
                     <input type="text" name="idProduct[]" placeholder="Producto 1">
                     <input type="number" name="quantity[]" placeholder="Cantidad">
                     <input type="number" name="price[]" placeholder="Precio">
                     <input type="text" name="imei[]" placeholder="IMEI">


                            <div>
                                  <button class="en" type="submit">Enviar</button>
                                  <button class="rs" type="reset">Reset</button>
                           </div></div>

</form>
</html>