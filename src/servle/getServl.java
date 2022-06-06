package servle;

import DB.DBconnector;
import model.Languages;
import model.News;
import model.Publications;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/getServl")
    public class getServl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<News> arr = DBconnector.getNews();
        ArrayList<Publications> publ = DBconnector.getPublications();
        ArrayList<Languages> a = DBconnector.getLanguages();
        request.setAttribute("publ", publ);
        request.setAttribute("novosti", arr);
        request.setAttribute("lang", a);
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}