<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>
<%@ page import="com.moi.model.EmployeeModel" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empleados</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css">
</head>


<body>
<div class="bna">
<a href="employeesRegister"><nav class="insert">Insertar</nav></a>
<a href="manager"><nav class="atras">Atras</nav></a>
<a href="moi-java"><nav class="salir">Salir</nav></a>
</div>
<% List employees = (List)  request.getAttribute("employees"); %>

<div  class= "fondo">
<div  class= "general">

<h1 class="tabla"> Empleados</h1>

  <Table  >
   <tr>
                       <th>documento</th>
                       <th>nombres</th>
                       <th>apellidos </th>
                       <th>codigo</th>
                       <th>celular</th>
                       <th>correo</th>
                       <th>cargo</th>
                       <th>natalicio</th>
                       <th>sucursal</th>
                   </tr>
                    <% for (int i = 0; i < employees.size(); i ++) { %>
                    <% EmployeeModel employee =( EmployeeModel) employees.get(i); %>
                                   <tr>
                                       <td><%= employee.getDocument() %></td>
                                       <td><%= employee.getName() %></td>
                                       <td><%= employee.getLastname() %></td>
                                       <td><%= employee.getCode() %></td>
                                       <td><%= employee.getCel() %></td>
                                        <td><%= employee.getEmail() %></td>
                                        <td><%= employee.getRole() %></td>
                                        <td><%= employee.getBirthdate() %></td>
                                        <td><%= employee.getBranch() %></td>
                                   </tr>
                                   <% } %>




   </Table>
  </div>
  </div>
</body>
</html>