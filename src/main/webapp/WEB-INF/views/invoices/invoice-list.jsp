<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html><!DOCTYPE html>
               <html lang="en">
               <head>
                   <meta charset="UTF-8">
                   <meta name="viewport" content="width=device-width, initial-scale=1.0">
                   <title>factura</title>
                   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/insertPayroll.css?">
               </head>
               <body>
               <div class="tod">
                   <div class="bna">
                   <a href=""><nav class="search">Buscar</nav></a>
                    <a href="clientsRegister"><nav class="atras">Registrar</nav></a>
                    <a href="moi-java"><nav class="salir">Salir</nav></a>
                   </div>

                  <div class="fondo">
                        <div class="general">
                          <form class="pay" action="invoices" method= "post">
                           <div class="ent">
                              <table>
                                <tr>
                                 <th>fecha</th>
                                 <th>nombre</th>
                                 <th>documento</th>
                                 <th>codigo empleado</th>
                                 <th>producto</th>
                                 <th>codigo producto</th>
                                 <th>imei</th>
                                 <th>cantidad</th>
                                 <th>valor</th>
                                 <th>subtotal</th>
                                 <th>iva</th>
                                 <th>total</th>
                                </tr>

                                <tr>
                                 <td> <input type="datetime-local" name="fecha" id="fecha">  </td>
                                 <td> <input type="text" name="nombre" id="nombre"> </td>
                                 <td> <input type="long" name="documento" id="documento"> </td>
                                 <td> <input type="int" name="codigoEmpleado" id="codigoEmpleado"> </td>
                                 <td> <input type="text" name="producto" id="producto"> </td>
                                 <td> <input type="text" name="codigoProducto" id="codigoProducto"> </td>
                                 <td> <input type="long" name="imei" id="imei"> </td>
                                 <td> <input type="number" name="cantidad" id="cantidad"> </td>
                                 <td> <input type="number" name="valor" id="valor"> </td>
                                 <td> <input type="number" name="subTotal" id="subTotal"> </td>
                                 <td> <input type="number" name="iva" id="iva"> </td>
                                 <td> <input type="number" name="total" id="total"> </td>
                                </tr>
                              </table>
                           </div>

                                  <button class="en" type="submit">Enviar</button>

                          </form>



          </div>

       </div>
    </div>
  </div>





</form>
</html>
