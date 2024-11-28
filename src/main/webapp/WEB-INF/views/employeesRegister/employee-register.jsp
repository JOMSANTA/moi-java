<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>formulario empleados</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/employeesReg.css">
</head>
<body>

    <form action="employees" method="post" >
        <section class="registro" >
            <p><h1 class="titulo">Registro de empleados</h1></p>
            <input type="number" name="documento" id="documento" placeholder="numero documento"><br>
            <input type="text" name="nombres" id="nombres" placeholder="nombres"><br>
            <input type="text" name="apellidos" id="apellidos" placeholder="apellidos"><br>
            <input type="int" name="codigo" id="codigo" placeholder="codigo"><br>
            <input type="number" name="celular" id="celular" placeholder="num celular"><br>
            <input type="email" name="correo" id="correo" placeholder="correo"><br>
            <input type="text" name="cargo" id="cargo" placeholder="cargo"><br>
            <label for="fecha_nacimiento">Fecha nacimiento</label>
            <input type="date" name="fechaNacimiento" id="fechaNacimiento" placeholder="fecha nacimiento"><br>
            <input type="text" name="sucursal" id="sucursal" placeholder="sucursal"><br>
            <label>Genero</label><br>
            <label class="opcion">
            masculino<input type="radio" name="sexo" id="sexo" value="masculino">
            femenino<input type="radio" name="sexo" id="sexo" value="femenino">
            </label>
            <input class="env" type="submit" value="Enviar">
            <input type="reset" >
        </section>

    </body>
    </html>
    </form>