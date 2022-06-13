package servle;

import DB.DBconnector;
import model.Languages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet ("/EditLanguagesServlet")
public class EditLanguagesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String languages_id = request.getParameter("languages_id");
        Long langId = Long.parseLong(languages_id);
        Languages languages = DBconnector.getOneLanguages(langId);
        request.setAttribute("one_language", languages);
        request.getRequestDispatcher("/editLanguages.jsp").forward(request, response);
    }
}
