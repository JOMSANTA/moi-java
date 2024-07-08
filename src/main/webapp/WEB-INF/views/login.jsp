<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta
            name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
    />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css?v=1" />
    <title>Login</title>
</head>
<body>

    <!-- Main Section -->
    <main class="main">
      <section class="section banner banner-section">
        <div class="container">

          <div class="login-card padding-horizontal--48">
            <h2>Bienvenido </h2>

            <p class="paragraph">Ingresa tus datos</p>

            <div class="margin-bottom--12 content-center">
            <%-- Check if loginMessage attribute exists --%>
            <% if (request.getAttribute("loginMessage") != null) { %>
            <p style="color:#0000ff ";>
                <%= request.getAttribute("loginMessage")  %>
            </p>
                <% } %>
            </div>

            <form class="login-form" action="login" method="post">
              <div class="field">
                <label for="username">Nombre :   </label>
                <input
                  type="text"
                  name="username"
                  placeholder="Ingresa tu nombre de usuario"
                  required
                />
              </div>
              <div class="field">
                <label for="password">Contraseña :</label>
                <input
                  type="password"
                  name="password"
                  placeholder="Ingresa tu contraseña"
                  required
                />
              </div>

                <div class="padding-top--12">
                  <button
                    class="btn btn-darken btn-inline login-btn"
                    type="submit"
                  >
                    Entrar
                  </button>
                </div>
             </form>
                <div class="footer-link padding-top--12">
          </div>
<h3>BUIMON.Ltda</h3
        </div>
      </section>
    </main>

<script src="${pageContext.request.contextPath}/js/script.js?v=1"></script>
</body>
</html>