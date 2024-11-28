<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Administrar</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager.css">
</head>
<body>
 <div class="general">
   <div class="opc"></div>
    <a href= "promotions"><div class="edith">Editar Promociones</div></a>
    <a href= "emails"><div class="email">Correos y pedidos</div></a>
    <a href= "reports"><div class="report">Reportes</div></a>
    <a href= "accounting"><div class="accounting">Contabilidad</div></a>
    <a href= "payrolls"><div class="pay">Nominas</div></a>
    <a href= "employees"><div class="empl">Empleados</div></a>
    <a href= "employeesAuthorized"><div class="autho">Autorizacion de empleados</div></a>
    <a href= "adminsAuthorized"><div class="autho">Autorizacion de administracion</div></a>
  </div>
 </div>

</body>
</html>