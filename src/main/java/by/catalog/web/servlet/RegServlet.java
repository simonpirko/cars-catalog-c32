package by.catalog.web.servlet;

import by.catalog.domain.Car;
import by.catalog.domain.User;
import by.catalog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet (urlPatterns = "/reg", name = "RegServlet")

public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = (List) req.getSession().getAttribute("userList");
        UserService userService = new UserService();
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String phone = req.getParameter("password");
        String role = req.getParameter("role");
        List<Car> userCarList = new ArrayList<Car>();
        userList.add(new User(name, lastName, login, password, phone, role, userCarList));
            String message = "User " + login + "added!";
            req.getSession().setAttribute("message", message);
            resp.sendRedirect("/");
        }
    }

