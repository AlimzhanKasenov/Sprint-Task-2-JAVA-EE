package servle;

import DB.DBconnector;
import model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet ("/podrNovos")
public class podrNovos extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nov_id = request.getParameter("nov_id");
        Long id = Long.parseLong(nov_id);

        ArrayList<News> arr = DBconnector.getOneNov(id);
        request.setAttribute("podrNov", arr);
        request.getRequestDispatcher("/PodrNovos.jsp").forward(request, response);
    }
}
