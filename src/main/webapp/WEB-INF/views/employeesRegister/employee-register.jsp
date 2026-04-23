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
                        <td> <input type="number" name="document" id="document">  </td>
                        <td> <input type="text" name="name" id="name"> </td>
                        <td> <input type="text" name="lastname" id="lastname"> </td>
                        <td> <input type="number" name="code" id="code"> </td>
                        <td> <input type="number" name="cel" id="cel"> </td>
                        <td> <input type="text" name="email" id="email"> </td>
                        <td> <input type="text" name="role" id="role"> </td>
                        <td> <input type="date" name="birthdate" id="birthdate"> </td>
                        <td> <input type="text" name="branch" id="branch"> </td>
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
                   <td><%= employee.getDocument() %></td>
                   <td><%= employee.getName() %></td>
                   <td><%= employee.getLastname() %></td>
                   <td><%= employee.getCode() %></td>
                   <td><%= employee.getCel() %></td>
                   <td><%= employee.getEmail() %></td>
                   <td><%= employee.getRole() %></td>
                   <td><%= employee.getBirthdate() %></td>
                   <td><%= employee.getBranch() %></td
                   </tr>
                     <% } %>

              </table>

           </div>

         </div>
        </div>
      </div>


    </body>
    </html>
