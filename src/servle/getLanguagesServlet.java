package servle;

import DB.DBconnector;
import model.Languages;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet ("/getLanguagesServlet")
public class getLanguagesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users = (Users) request.getSession().getAttribute("online_user");
        if (users != null) {
            ArrayList<Languages> languages = DBconnector.getLanguages();
            request.setAttribute("get_languages", languages);
            request.getRequestDispatcher("/MenuAdmins.jsp").forward(request, response);
        }else {
            response.sendRedirect("/LoginPassworedWhod.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users = (Users) request.getSession().getAttribute("online_user");
        if (users != null) {
            ArrayList<Languages> languages = DBconnector.getLanguages();
            request.setAttribute("get_languages", languages);
            request.getRequestDispatcher("/MenuAdmins.jsp").forward(request, response);
        } else {
            response.sendRedirect("/LoginPassworedWhod.jsp");
        }
    }
}
