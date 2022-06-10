package servle;

import DB.DBconnector;
import model.Languages;
import model.News;
import model.Publications;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home")
    public class getServl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Publications> pub = DBconnector.getPublications();
        ArrayList<Languages> a = DBconnector.getLanguages();
        Cookie[] cookie = request.getCookies();
        String parameter = null;

        if (cookie!=null){
            for (Cookie c : cookie){
                if (c.getName().equals("lang")){
                    parameter = c.getValue();
                }
            }
        }
        if (parameter == null)
            parameter = "1";

        Long lid = Long.parseLong(parameter);

        ArrayList<News> arr = DBconnector.getNewsByLanguageId(lid);
        request.setAttribute("publ", pub);
        request.setAttribute("lang", a);
        request.setAttribute("novosti", arr);
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}