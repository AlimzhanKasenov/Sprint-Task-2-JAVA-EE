<%@ page import="model.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новости</title>
    <%@include file="Head.jsp"%>
</head>
<body>
    <%@include file="BarOsnov.jsp"%>
    <form>
        <div class="row row-cols-1 row-cols-md-2 g-4">
            <div class="col mx-3">
                <div class="card">
                    <img src="https://cdn.nur.kz/images/1120x630/2f01a333ea687848.webp?version=3" class="card-img-top">
                    <%
                        ArrayList<News> a = (ArrayList<News>) request.getAttribute("novosti");
                        if (a != null){
                            for (News i : a){
                    %>
                    <div class="card-body">
                        <b class="text-primary"><%=i.getTitle()%></b>
                        <h3 class=""><%=i.getShort_content()%></h3>
                        <i class="text-muted"><%=i.getPost_date()%></i>
                        <p class="card-text"><%=i.getContent()%></p>
                        <b><a class="nav-link text-primary mx-2" href="#">Кнопка</a></b>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </form>
</body>
</html>