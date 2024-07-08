<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html><!DOCTYPE html>
               <html lang="en">
               <head>
                   <meta charset="UTF-8">
                   <meta name="viewport" content="width=device-width, initial-scale=1.0">
                   <title>factura</title>
                   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/invoices.css">
               </head>
               <body>
                 <div class="fondo">
                   <form action="http://localhost:5000/invoices" method="post">
                   <div class="general">
                       <h1 class="factura">Factura</h1>

                       <label for="fecha_factura">Fecha factura</label>
                       <input type="datetime-local" name="fechaFactura" id="fechaFactura" placeholder="fecha factura"><br>
                       <input type="number" name="idCliente" id="idCliente" placeholder="id cliente"><br>
                       <input type="text" name="nombreCliente" id="nombreCliente" placeholder="Nombre cliente"><br>
                       <input type="number" name="idProducto" id="idProducto" placeholder="id producto"><br>
                       <input type="text" name="nombreProducto" id="nombreProducto"placeholder="nombre producto"><br>
                       <input type="text" name="imeiProducto" id="imeiProducto"placeholder="imei"><br>
                       <input type="number" name="cantidadProductos" id="cantidadProductos" placeholder="cantidad producto"><br>
                       <input type="number" name="valorUnitario" id="valorUnitario" placeholder="valor_unitario"><br>
                       <input type="number" name="subTotal" id="subTotal" placeholder="sub total"><br>
                       <input type="number" name="iva" id="iva" placeholder="iva"><br>
                       <input type="number" name="total" id="total" placeholder="total"><br>
                       <input type="reset" ><br>
                       <input type="submit" value="Enviar">

                     </div>
                      </div>

               </body>
               </form>
               </html>

      </div>
       </div>

</body>
</form>
</html>
