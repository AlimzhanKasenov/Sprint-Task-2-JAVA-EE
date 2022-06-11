package servle;

import DB.DBconnector;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet ("/newServletAuthorizzation")
public class newServletAuthorizzation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("passwor");
        ArrayList<Users> arr = DBconnector.authorization();
        for (Users u : arr){
            if (u.getLogin().equals(login) && u.getPassword().equals(password)){
                request.setAttribute("users", u);
                request.getRequestDispatcher("/ЗАполнить как войтдёт").forward(request, response);
            }
        }
        request.setAttribute("user", "true");
        request.getRequestDispatcher("/LoginPassworedWhod.jsp").forward(request, response);
    }
}
