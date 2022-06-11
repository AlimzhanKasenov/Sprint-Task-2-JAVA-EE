<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="Head.jsp"%>
<head>
    <title>Регистрация</title>
</head>
<body>
    <%@include file="BarOsnov.jsp"%>
    <form action="registrationServlet" method="post" class="w-50 mx-auto mt-4">
        <div class="form-floating mb-3">
        <% String notificationLogin = (String) request.getAttribute("notification_login");
                if (notificationLogin != null){
        %>
            <div class="alert alert-warning" role="alert">
                <%=notificationLogin%>
            </div>
            <% notificationLogin = null;
                } %>
            <input name="login" type="text" class="form-control mt-3" id="floatingInputLogin" placeholder="Логин">
            <label for="floatingInputLogin">Логин</label>
        </div>
        <div class="form-floating mb-3">
        <% String notificationPassword = (String) request.getAttribute("notification_password");
            if (notificationPassword != null){
        %>
            <div class="alert alert-warning" role="alert">
                <%=notificationPassword%>
            </div>
                <% notificationPassword = null;
            } %>
        <div class="form-floating mb-3">
            <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Пароль">
            <label for="floatingPassword">Пароль</label>
        </div>
        <div class="form-floating mb-3">
            <input name="repassword" type="password" class="form-control" id="floatingPassword2" placeholder="Повторите Пароль">
            <label for="floatingPassword2">Повторите Пароль</label>
        </div>
        <div class="form-floating mb-3">
            <input name="name" type="text" class="form-control" id="floatingInputName" placeholder="Имя">
            <label for="floatingInputName">Полное Имя</label>
        </div>
        <button type="submit" class="btn btn-dark">Registration</button>
    </form>
</body>
</html>
