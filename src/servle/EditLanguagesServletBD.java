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

@WebServlet ("/EditLanguagesServletBD")
public class EditLanguagesServletBD extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String id = request.getParameter("butt");
        Long lon = Long.parseLong(id);
        String name = request.getParameter("name");
        String code = request.getParameter("code");

        Languages lan = DBconnector.getOneLanguages(lon);
        Languages languagesAdd = new Languages(lan.getId(), name, code);
        languagesAdd.setName(name);
        languagesAdd.setName(code);
        DBconnector.editLanguages(languagesAdd);
        request.getRequestDispatcher("/getLanguagesServlet").forward(request, response);
    }
}
