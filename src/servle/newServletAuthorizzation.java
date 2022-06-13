package servle;

import DB.DBconnector;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet ("/newServletAuthorizzation")
public class newServletAuthorizzation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("passwor");
        HttpSession session = request.getSession();
        Users user = DBconnector.getOneUser(login, password);

        if (user != null) {
            request.getSession().setAttribute("online_user", user);
            request.getRequestDispatcher("/getLanguagesServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/LoginPassworedWhod.jsp").forward(request, response);
        }
    }
}