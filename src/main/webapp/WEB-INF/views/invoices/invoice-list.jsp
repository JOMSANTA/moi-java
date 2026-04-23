<%@ page import="java.util.List" %>
<%@ page import="com.moi.model.SearchModel" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Factura</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/invoices.css">
</head>

<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty loginMessage}">
    <p class="mensaje-exito">${loginMessage}</p>
</c:if>

<div class="tod">

    <!-- Barra navegación -->
    <div class="bna">
        <a href="#"><nav class="search">Buscar</nav></a>
        <a href="clients"><nav class="atras">Registrar</nav></a>
        <a href="moi-java"><nav class="salir">Salir</nav></a>
    </div>

    <div class="fondo">
        <div class="general">

            <form class="pay" action="invoices" method="post">
               <div class="encabezado-factura"><h1>Factura</h1>
               <input type="number" id="factura" name="factura" value="${nextInvoiceNumber}" readonly>


            <!--   =======================================  -->
               <div>
                   <label for="fechaHora">Fecha y hora:</label>
                   <input type="datetime-local" id="fechaHora" name="fechaHora">
               </div>

           <!--   =======================================  -->
                <div class="fila">
                    <label for="idClient">Documento:</label>
                    <input type="number" id="idClient" name="idClient" placeholder="Documento">

                    <label for="name">Cliente:</label>
                    <input type="text" id="name" name="name" placeholder="Nombre del cliente">
                </div>

                <div id="listaClientes" class="autocomplete-list"></div>
             <!--   =======================================  -->
               <div class= "fila">
                    <label for="codEmployee">Codigo empleado:</label>
                    <input type="number" id="codEmployee" name="codEmployee" placeholder="Codigo empleado">
                <!--   =======================================  -->
               <div class="ent">
                  <table>
                     <tr>
                     <th>producto</th>
                     <th>color</th>
                     <th>imei </th>
                     <th>codigo</th>
                     </tr>



                     <tr>
                     <td> <input type="text" name="name[]" class="product-name"> </td>
                     <td> <input type="text" name="color[]" class="color"> </td>
                     <td> <input type="number" name="imei[]" class="imei"> </td>
                     <td> <input type="text" name="code[]" class="code"> </td>

                     </tr>
                     </table>
                     </div>
                     <button class="en" type="submit">Buscar</button>
                     </form>
               <!--   =======================================  -->


             <!--   =======================================  -->
                <div class="fila">
                <table>
                     <tr>
                     <th>precio</th>
                     <th>cantidad</th>
                     </tr>
                     <tr>
                     <td> <input type="number" name="price[]" class="price"> </td>
                     <td> <input type="number" name="quantity[]" class="quantity"> </td>
                     </tr>
                </table>
                </div>

                <div class="fila totales">
                    <label>Subtotal:</label>
                    <input type="number" id="subtotal" name="subtotal" readonly>

                    <label>IVA:</label>
                    <input type="number" id="iva" name="iva" readonly>

                    <label>Total:</label>
                    <input type="number" id="total" name="total" readonly>
                </div>

                <div class="botones">
                    <button type="submit">Enviar</button>
                    <button type="reset">Reset</button>
                </div>

            </form>

        </div>
    </div>
</div>

</body>
<script>
    document.getElementById("fechaHora").value = new Date().toISOString().slice(0,16);
</script>
</html>
