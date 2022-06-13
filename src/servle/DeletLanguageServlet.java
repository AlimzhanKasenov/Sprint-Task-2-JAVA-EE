package servle;

import DB.DBconnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet ("/DeletLanguageServlet")
public class DeletLanguageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String languages_id = request.getParameter("languages_id");
        Long id = Long.parseLong(languages_id);
        DBconnector.deleteLanguages(id);
        request.getRequestDispatcher("/getLanguagesServlet").forward(request, response);
    }
}
