<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*"%>


<html>
<head>
    <title>Mi Página con Imagen</title>
    <style>
            /* Aseguramos que la imagen ocupe toda la pantalla */
            body, html {
                height: 100%;
                margin: 0;
            }

            .full-screen-image {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                object-fit: cover; /* La imagen cubre el área sin distorsionarse */
            }
        </style>
</head>
<body>

    <img src="webapp/img/promo.jpg" alt="Descripción de la imagen" />
</body>
</html>