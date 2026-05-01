<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>adminAuthorized</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userAuthorized.css">
</head>

<!-- Mostrar error básico -->
<c:if test="${not empty error}">
    <div class="error-message">${error}</div>
</c:if>

<!-- Mostrar errores generales -->
<c:if test="${not empty errorsMessage}">
    <div class="error-message">${errorsMessage}</div>
</c:if>

<!-- Mostrar errores individuales -->
<c:if test="${not empty errors}">
    <ul class="error-list">
        <c:forEach var="err" items="${errors}">
            <li>${err}</li>
        </c:forEach>
    </ul>
</c:if>

<!-- Mostrar mensaje de éxito -->
<c:if test="${not empty successMessage}">
    <div class="success-message">${successMessage}</div>
</c:if>


<body>
 <div class="fondo">
     <form class="authorized-form" action="adminsAuthorized" method="post">
     <div class="general">
         <h1 class="autorizar">Autorizar administracion</h1>
         <input type="text" name="first_name" id="first_name" placeholder="Nombre"><br>
         <input type="text" name="last_name" id="last_ name" placeholder="Apellido"><br>
         <input type="text" name="username" id="username" placeholder="nombre de usuario"><br>
         <input type="password" name="password" id="password" placeholder="contraseña"><br>
         <input type="reset" ><br>
         <input type="submit" value="Enviar"></div>
    </div>

</body>
</html>