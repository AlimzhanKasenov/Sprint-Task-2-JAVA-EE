<%@ page import="model.Languages" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменене</title>
  <%@include file="Head.jsp"%>
</head>
<body>
<%@include file="BarLoginPassword.jsp"%>
<%@include file="sidePanel.jsp"%>

<div class="container">
    <div class="row mt-5">
        <div class="col-sm-12">
        <%
            Languages languages = (Languages) request.getAttribute("one_language");
            if (languages != null){
        %>
    <form action="EditLanguagesServlet" method="post">
        <div class="form-group">
            <label> Name </label>
            <input type="text" name="name" class="form-control" value="<% languages.getName(); %>">
        </div>
        <div class="form-group">
            <label> Code </label>
            <input type="text" name="name" class="form-control" value="<% languages.getCode(); %>">
        </div>
    </form>
            <%
                }
%>
</div>
</body>
</html>
