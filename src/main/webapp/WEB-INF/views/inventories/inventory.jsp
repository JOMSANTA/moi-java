<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventario</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventory.css">
</head>
<body>
    <div class="fondo">
        <form action="">
            <div class="general">
            <h1 class="tabla"> Inventario sucursal</h1>
            <table>
                <tr>

                    <th>nombre producto</th>
                    <th>color</th>
                    <th>imei producto</th>
                    <th>codigo</th>
                    <th>fecha ven</th>
                    <th>cant</th>

                </tr>
                <tbody>
                <tr>
                    <td placeholder="nombre"></td>
                    <td placeholder="color"></td>
                    <td placeholder="imei"></td>
                    <td placeholder="codigo"></td>
                    <td placeholder="fechaV"></td>
                    <td placeholder="cant"></td>



                </tr>
                </tbody>




            </table>
            </div>
        </form>
    </div>


</body>
</html>