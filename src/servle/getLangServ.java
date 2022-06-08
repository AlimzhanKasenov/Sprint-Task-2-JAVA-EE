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

@WebServlet ("/getLangServ")
public class getLangServ extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lan = request.getParameter("lang_id");
        Long l = Long.parseLong(lan);

        ArrayList<News> news = DBconnector.getSortNow(l);
        ArrayList<Publications> publ = DBconnector.getPublications();
        ArrayList<Languages> a = DBconnector.getLanguages();
        request.setAttribute("publ", publ);
        request.setAttribute("lang", a);
        request.setAttribute("newsSort", news);
        request.getRequestDispatcher("/sortNews.jsp").forward(request, response);


    }
}