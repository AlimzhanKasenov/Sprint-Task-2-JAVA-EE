<%@ page import="model.Languages" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменене</title>
  <%@include file="Head.jsp"%>
</head>
<body>
<%@include file="BarLoginPassword.jsp"%>
<div class="mt-4 row">
<%@include file="sidePanel.jsp"%>
<div class="container col-8">
    <div class="row mt-5">
        <div class="col-sm-12">
        <%
            request.setCharacterEncoding("utf8");
            Languages languages = (Languages) request.getAttribute("one_language");
        %>
    <form action="EditLanguagesServletBD" method="get">
        <div class="form-group">
            <label> Name </label>
            <input type="text" name="name" class="form-control w-50" value="<%=languages.getName()%>">
        </div>
        <div class="form-group mt-3">
            <label> Code </label>
            <input type="text" name="code" class="form-control w-50" value="<%=languages.getCode()%>">
        </div>
        <button name="butt" value="<%=languages.getId()%>" class="btn btn-danger">Save</button>
    </form>
        </div>
    </div>
</div>
</body>
</html>
