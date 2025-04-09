<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
               <html lang="en">
               <head>
                   <meta charset="UTF-8">
                   <meta name="viewport" content="width=device-width, initial-scale=1.0">
                   <title>factura</title>
                   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/invoices.css?">
               </head>
               <body>
               <div class="tod">
                   <div class="bna">
                   <a href=""><nav class="search">Buscar</nav></a>
                    <a href="clientsRegister"><nav class="atras">Registrar</nav></a>
                    <a href="moi-java"><nav class="salir">Salir</nav></a>
                   </div>

                  <div class="fondo">

                          <form class="pay" action="invoices" method= "post">
                          <div class="general">


                                 <h1 class="factura">Factura</h1>
                                 <input type="datetime-local" name="fecha" id="fecha">
                                  <input type="text" name="nombre" id="nombre" placeholder="Nombre cliente">
                                  <input type="number" name="documento" id="documento" placeholder="Documento">
                                  <input type="number" name="codEmpleado" id="codEmpleado" placeholder="Codigo empleado">
                                  <input type="text" name="producto" id="producto" placeholder="Nombre producto">
                                  <input type="text" name="codigoProducto" id="codigoProducto" placeholder="Codigo producto">
                                  <input type="number" name="imei" id="imei" placeholder="imei">
                                  <input type="number" name="cantidad" id="cantidad" placeholder="Cantidad">
                                  <input type="number" name="valor" id="valor" placeholder="Precio">
                                  <input type="number" name="subTotal" id="subTotal" placeholder="Subtotal">
                                  <input type="number" name="iva" id="iva" placeholder="iva">
                                  <input type="number" name="total" id="total" placeholder="Total">


                            <div>
                                  <button class="en" type="submit">Enviar</button>
                                  <button class="rs" type="reset">Reset</button>
                           </div></div>

</form>
</html>