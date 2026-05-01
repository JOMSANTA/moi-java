<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.EmployeeModel" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>formulario empleados</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css?">
</head>
<body>
<div class="tod">
    <div class="bna">
     <a href="employees"><nav class="atras">Atras</nav></a>
     <a href="moi-java"><nav class="salir">Salir</nav></a>
    </div>
    <div class="fondo">
           <div class="general">
             <form class="pay" action="employeesRegister" method= "post">
              <div class="ent">
             <Table  >
                <tr>
                 <th>documento</th>
                 <th>nombres</th>
                 <th>apellidos </th>
                 <th>codigo</th>
                 <th>celular</th>
                 <th>correo</th>
                 <th>cargo</th>
                 <th>fechaNacimiento</th>
                 <th>sucursal</th>
                </tr>

                 <tr>
                        <td> <input type="long" name="documento" id="documento">  </td>
                                                                <td> <input type="text" name="nombres" id="nombres"> </td>
                                                                <td> <input type="text" name="apellidos" id="apellidos"> </td>
                                                                <td> <input type="int" name="codigo" id="codigo"> </td>
                                                                <td> <input type="long" name="celular" id="celular"> </td>
                                                                <td> <input type="text" name="correo" id="correo"> </td>
                                                                <td> <input type="text" name="cargo" id="cargo"> </td>
                                                                <td> <input type="date" name="fechaNacimiento" id="fechaNacimiento"> </td>
                                                                <td> <input type="text" name="sucursal" id="sucursal"> </td>
                               </tr>
                             </table>
                             </div>

                  <button class="en" type="submit">Enviar</button>
             </form>

                  <% List employeesRegister = (List)  request.getAttribute("employeesRegister"); %>

                  <h1 class="tabla"> Empleados</h1>
             <table>
                  <tr>
                  <th>documento</th>
                  <th>nombres</th>
                  <th>apellidos </th>
                  <th>codigo</th>
                  <th>celular</th>
                  <th>correo</th>
                  <th>cargo</th>
                  <th>fechaNacimiento</th>
                  <th>sucursal</th>
                  </tr>

                  <% for (int i = 0; i < employeesRegister.size(); i ++) { %>
                   <% EmployeeModel employee =( EmployeeModel) employeesRegister.get(i); %>
                   <tr>
                   <td><%= employee.getDocumento() %></td>
                   <td><%= employee.getNombres() %></td>
                   <td><%= employee.getApellidos() %></td>
                   <td><%= employee.getCodigo() %></td>
                   <td><%= employee.getCelular() %></td>
                   <td><%= employee.getCorreo() %></td>
                   <td><%= employee.getCargo() %></td>
                   <td><%= employee.getFechaNacimiento() %></td>
                   <td><%= employee.getSucursal() %></td
                   </tr>
                     <% } %>

              </table>

           </div>

         </div>
        </div>
      </div>


    </body>
    </html>
