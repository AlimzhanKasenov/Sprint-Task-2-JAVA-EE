<%@ page import="model.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новости</title>
    <%@include file="Head.jsp"%>
</head>
<body>
    <%@include file="BarOsnov.jsp"%>
    <div class="gx-3 mt-3">
    <div class="container row mx-auto gy-3">
                <%
                    ArrayList<News> a = (ArrayList<News>) request.getAttribute("novosti");
                    if (a != null){
                        for (News i : a){
                %>
                <div class="col-6 card px-0">
                    <img src="<%=i.getPicture_url()%>" class="card-img-top">
                    <div class="card-body">
                        <b class="text-primary"><%=i.getPublication_id().getName()%></b>

                        <h3 class=""><%=i.getTitle()%></h3>
                        <i class="text-muted"><%=i.getPost_date()%></i>
                        <p class="card-text"><%=i.getShort_content()%></p>
                        <b><a class="nav-link text-primary mx-2" href="podrNovos?nov_id=<%=i.getId()%>">Подробне</a></b>
                    </div>
                </div>
                <%
                        }
                    }
                %>
    </div>
    </div>
    <footer class="text-muted text-center mt-3 mb-3">Copyright (C) All Rights Reserved</footer>
</body>
</html>