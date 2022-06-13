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


@WebServlet ("/AddLanguagesServlet")
public class AddLanguagesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nov_id = request.getParameter("languages_id");
        Long novId = Long.parseLong(nov_id);
        Languages arr = DBconnector.getOneLanguages(novId);
        request.setAttribute("one_language", arr);
        request.getRequestDispatcher("/getLanguagesServlet").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        if (name != null & code != null) {
            boolean addLanguage = DBconnector.addLanguages(name, code);
            request.getRequestDispatcher("/getLanguagesServlet").forward(request, response);
        }
    }
}
