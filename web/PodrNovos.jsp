<%@ page import="model.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новости</title>
    <%@include file="Head.jsp"%>
</head>
<body>
<%@include file="BarOsnov.jsp"%>
<div class="row p-3 mb-2">
    <%
    ArrayList<News> podr = (ArrayList<News>) request.getAttribute("podrNov");
        if (podr != null){
            for (News i : podr){
    %>
    <div class="col-8 ">
        <div class="card px-0">
            <h3 class=""><%=i.getTitle()%></h3>
            <i class="text-muted"><%=i.getPost_date()%></i>
            <p class="card-text"><%=i.getShort_content() + " " + i.getPublication_id().getName()%></p>
            <img src="<%=i.getPicture_url()%>" class="card-img-top">
            <div class="card-body">
                <b class="text-primary"><%=i.getShort_content()%></b>
                <p class="card-text"><%=i.getContent()%></p>
            </div>
        </div>
    </div>
    <div class="col-4">
        <div class="bg-primary text-white card">
            <i><H4 class="mx-3">About <%=i.getPublication_id().getName()%></H4></i>
            <p class="mx-3"><%=i.getPublication_id().getDescription()%></p>
            <i><H4 class="mx-3">Rating : <%=i.getPublication_id().getRating()%></H4></i>
        </div>
    </div>
    <%
            }
        }
    %>
</div>

</body>
</html>
