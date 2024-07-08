<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>vencimientos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comings.css">
</head>
<body>
    <div class="fondo">
        <form action="">
            <div class="general">
            <h1 class="tabla"> Vencimientos</h1>
            <table>
                <tr>

                    <th>fecha vencimiento</th>
                    <th>imei producto</th>
                    <th>nombre producto</th>
                </tr>
                <tbody>
                <tr>
                    <td placeholder="dd-mm-aaaa"></td>
                    <td placeholder="imei"></td>
                    <td placeholder="nombre"></td>


                </tr>
                </tbody>




            </table>
            </div>
        </form>
    </div>


</body>
</html>