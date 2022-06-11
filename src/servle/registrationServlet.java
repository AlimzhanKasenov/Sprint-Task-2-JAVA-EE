package servle;

import DB.DBconnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/registrationServlet")
public class registrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/RegistrationUser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String notification;

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String name = request.getParameter("name");

        if (password.equals(repassword) & password != null & repassword != null) {
            boolean verification = DBconnector.getUserVerification(login);
            if (verification == false) {
                boolean addUser = DBconnector.addUser(login, password, name);
                    if (addUser == true) {
                        response.sendRedirect("/addUserNotification.jsp");
                }
            } else {
                notification = "Логин занят";
                request.setAttribute("notification_login", notification);
                notification = null;
                request.getRequestDispatcher("/RegistrationUser.jsp").forward(request, response);
            }
        } else {
            notification = "Пароли не совпадают";
            request.setAttribute("notification_password", notification);
            notification = null;
            request.getRequestDispatcher("/RegistrationUser.jsp").forward(request, response);
        }
    }
}