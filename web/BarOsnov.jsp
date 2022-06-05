<%@ page import="model.Languages" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar bg-light text-center mw-100">
    <div class="container-fluid ">
            <ul class="navbar-nav list-group list-group-horizontal w-25 text-center">
                <%
                    ArrayList<Languages> arr = (ArrayList<Languages>) request.getAttribute("lang");
                    if (arr != null){
                        for (Languages i : arr){
                %>
                <li class="nav-item">
                    <a class="nav-link mx-2" href="#"><%=i.getCode()%></a>
                </li>
                <%
                }
                    }%>
            </ul>
                <div class="w-50">
            <h3><b class="ml-5">WORLD NEWS PORTAL</b></h3>
        </div>
        <form class="d-flex w-25">
            <input class="form-control me-2 " type="search" placeholder="Поиск" aria-label="Поиск">
            <button class="btn btn-outline-success text-nowrap align-top" type="submit">Sign up</button>
        </form>
    </div>
</nav>
<form class="bg-dark">
    <ul class="list-group list-group-horizontal w-100 text-center ">
        <li class="nav-item mx-auto">
            <b><a class="nav-link text-light mx-2" href="#">RUS</a></b>
        </li>
    </ul>
</form>