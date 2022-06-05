package servle;

import DB.DBconnector;
import model.Languages;
import model.News;

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
        ArrayList<Languages> arr = DBconnector.gerLanguages();
        request.setAttribute("lang", arr);
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<News> arr = DBconnector.gerNews();
        request.setAttribute("novosti", arr);
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
