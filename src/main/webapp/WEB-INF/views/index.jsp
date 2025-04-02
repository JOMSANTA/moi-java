<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}">
    <title>Inicio</title>

</head>

<body>
  <form class= "login-form" action="login" method="post">
  <div class="general">
  <div class="arriba">
    <div class="distribuidor">
      <h2 class="buimon">Buimon ltda</h2>
      <h1 class="tienda">Tienda de tecnologia</h1>
     <img src="${pageContext.request.contextPath}/img/logo_buimon.png" alt="" width="" class="log">
      <h2 class="grupo">Grupo empresarial</h2>
    </div>
  </div>
  <div class="medio">
    <section class="sucursal">
      <img src="${pageContext.request.contextPath}/img/logo_ruta.png" alt="" width="220px" class="ruta">
      <h2 class="suc">sucursal</h2>
    </section>
    <section class="empleados">
      <a href="login"><nav class="as"><h2 class="ase">as</h2></nav></a>
      <a href="loginAdm"><nav class="ad"><h2 class="adm">ad</h2></nav></a>
    </section>
  </div>
  <div class="abajo">
    <a href="userOptions" ><nav class="entrar"><h2 class="ent">Ingrese a la tienda</h2></nav></a>
  </div>
  </div>




   </form>

</body>