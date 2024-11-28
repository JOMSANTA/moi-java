<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>employeeAuthorized</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userAuthorized.css?">
</head>
<body>
 <div class="fondo">
     <form action="employeesAuthorized" method="post" class="authorized-form">
     <div class="general">
         <h1 class="autorizar">Autorizar empleado</h1>
         <input type="text" name="first_name" id="first_name" placeholder="Nombre"><br>
         <input type="text" name="last_name" id="last_ name" placeholder="Apellido"><br>
         <input type="text" name="username" id="username" placeholder="nombre de usuario"><br>
         <input type="password" name="password" id="password" placeholder="contraseña"><br>
         <input type="reset" ><br>
         <input type="submit" value="Enviar"></div>
    </div>

</body>
</html>