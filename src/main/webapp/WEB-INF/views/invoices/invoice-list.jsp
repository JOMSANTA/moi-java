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
                                 <input type="datetime-local" name="fecha" id="fecha"><br>
                                  <input type="text" name="nombre" id="nombre" placeholder="Nombre cliente"><br>
                                  <input type="number" name="documento" id="documento" placeholder="Documento"><br>
                                  <input type="number" name="codEmpleado" id="codEmpleado" placeholder="Codigo empleado"><br>
                                  <input type="text" name="producto" id="producto" placeholder="Nombre producto"><br>
                                  <input type="text" name="codigoProducto" id="codigoProducto" placeholder="Codigo producto"><br>
                                  <input type="number" name="imei" id="imei" placeholder="imei"><br>
                                  <input type="number" name="cantidad" id="cantidad" placeholder="Cantidad"><br>
                                  <input type="number" name="valor" id="valor" placeholder="Precio"><br>
                                  <input type="number" name="subTotal" id="subTotal" placeholder="Subtotal"><br>
                                  <input type="number" name="iva" id="iva" placeholder="iva"><br>
                                  <input type="number" name="total" id="total" placeholder="Total"><br>


                            <div>
                                  <button class="en" type="submit">Enviar</button>
                                  <button class="rs" type="reset">Reset</button>
                           </div></div>

</form>
</html>