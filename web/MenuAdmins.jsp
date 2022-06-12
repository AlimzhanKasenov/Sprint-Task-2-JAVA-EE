<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Languages" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Админ</title>
    <%@include file="Head.jsp"%>
</head>
<body>
<%@include file="BarLoginPassword.jsp"%>
<div class="mt-4 row">
  <%@include file="sidePanel.jsp"%>
  <div class="col-8 ">
      <nav class="navbar navbar-expand-lg align-top">
          <div class="container-fluid">
              <b class="navbar-brand">Languages</b>
              </button>
              <form action="AddLangusages.jsp" class="d-flex" >
                  <button class="btn btn-success align-self-center" type="submit">Add New</button>
              </form>
          </div>
      </nav>
      <table class="table table-striped w-50">
          <thead>
          <tr>
              <th scope="col">ID</th>
              <th scope="col">Name</th>
              <th scope="col">Code</th>
              <th scope="col">Operations</th>
          </tr>
          </thead>
          <tbody
          <%
              ArrayList<Languages> arr = (ArrayList<Languages>) request.getAttribute("get_languages");
                if (arr != null){
                    for (Languages languages : arr){
          %>

          <tr>
              <th scope="row"><%=languages.getId()%></th>
              <td><%=languages.getName()%></td>
              <td><%=languages.getCode()%></td>
              <td>
                  <button class="btn btn-info"><a href="AddLanguagesServlet?languages_id=<%=languages.getId()%>" methods="post">Edit</a></button>
                  <button class="btn btn-danger">Delete</button>
              </td>
          </tr>
          <%
          }
            }
          %>
      </table>
  </div>
</div>
</body>
</html>
