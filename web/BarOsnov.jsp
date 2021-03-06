<%@ page import="model.Languages" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Publications" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar bg-secondary text-white text-center mw-100">
    <div class="container-fluid ">
        <ul class="navbar-nav list-group list-group-horizontal w-25 text-center">
            <%
                request.setCharacterEncoding("utf8");
                ArrayList<Languages> arr = (ArrayList<Languages>) request.getAttribute("lang");
                if (arr != null){
                    for (Languages i : arr){
            %>
            <li class="nav-item">
                <a class="nav-link mx-2" href="/getLangServ?lang_id=<%=i.getId()%>"><%=i.getCode()%></a>
            </li>
            <%
                    }
                }%>
        </ul>
        <div class="w-50">
            <h3><b class="ml-5"> <a href="/" class="nav-item text-decoration-none text-reset"> WORLD NEWS PORTAL </a></b></h3>
        </div>
        <form action="LoginPassworedWhod.jsp" class="d-flex w-25">
            <input class="form-control me-2 " type="search" placeholder="Поиск" aria-label="Поиск">
            <button class="btn btn-danger text-nowrap align-top" type="submit">Sign up</button>
        </form>
    </div>
</nav>
<div class="bg-dark">
    <ul class="list-group list-group-horizontal w-100 text-center ">
        <%
            ArrayList<Publications> publ = (ArrayList<Publications>) request.getAttribute("publ");
            if (publ != null){
                for (Publications p : publ){
        %>
        <li class="nav-item mx-auto">
            <b class="nav-link text-light mx-2"><%=p.getName()%></b>
        </li>
        <%
                }
            }%>
    </ul>
</div>