<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление языка</title>
    <%@include file="Head.jsp"%>
</head>
<body>
<%@include file="BarLoginPassword.jsp"%>
<div class="mt-4 row">
    <%@include file="sidePanel.jsp"%>
    <div class="col-8">
        <form action="AddLanguagesServlet" method="post">
            <div class="form-group row">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Страна</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control w-50" id="inputEmail3" placeholder="Введите страну">
                </div>
            </div>
            <br>
            <div class="form-group row">
                <label for="inputPassword3" class="col-sm-2 col-form-label">Код</label>
                <div class="col-sm-10">
                    <input type="text" name="code" class="form-control w-50" id="inputPassword3" placeholder="Введите код страны">
                </div>
            </div>
            <br>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">Создать</button>
                </div>
            </div>
        </form>
    </div>>
</div>
</body>
</html>
