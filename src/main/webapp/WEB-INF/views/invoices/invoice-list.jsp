<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html><!DOCTYPE html>
               <html lang="en">
               <head>
                   <meta charset="UTF-8">
                   <meta name="viewport" content="width=device-width, initial-scale=1.0">
                   <title>factura</title>
                   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/invoices.css?">
               </head>
               <body>
                 <div class="fondo">
                   <form action="invoices" method="post">
                    <div class="margin-bottom--12 content-center">
                               <%-- Check if loginMessage attribute exists --%>
                               <% if (request.getAttribute("loginMessage") != null) { %>
                               <p style="color:#0000ff ";>
                                   <%= request.getAttribute("loginMessage")  %>
                               </p>
                                   <% } %>
                               </div>
                   <div class="general">
                       <h1 class="factura">Factura</h1>

                       <label for="fecha">Fecha</label>
                       <input type="datetime-local" name="fecha" id="fecha" placeholder="fecha"><br>
                       <input type="text" name="nombre" id="nombre" placeholder="Nombre cliente"><br>
                       <input type="number" name="documento" id="documento" placeholder="Numero documento"><br>
                       <input type="int" name="codigoEmpleado" id="codigoEmpleado"placeholder="codigoEmpleado"><br>
                       <input type="text" name="producto" id="producto"placeholder="Nombre del producto"><br>
                       <input type="text" name="codigoProducto" id="codigoProducto" placeholder="codigo del producto"><br>
                       <input type="number" name="imei" id="imei"placeholder="imei"><br>
                       <input type="number" name="cantidad" id="cantidad" placeholder="cantidad"><br>
                       <input type="number" name="valor" id="valorUnitario" placeholder="valor unitario"><br>
                       <input type="number" name="subTotal" id="subTotal" placeholder="sub total"><br>
                       <input type="number" name="iva" id="iva" placeholder="iva"><br>
                       <input type="number" name="total" id="total" placeholder="total"><br>
                       <input class="env" type="submit" value="Enviar"><br>
                       <input type="reset" >


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
