package by.catalog.web.servlet;

import by.catalog.domain.User;
import by.catalog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeUserDataServlet", urlPatterns = "/changeUserData")
public class ChangeUserDataServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String currentUserName = currentUser.getName();
        req.setAttribute("currentUserName", currentUserName);
        req.getServletContext().getRequestDispatcher("/pages/changeUserData.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String newName = req.getParameter("newName");
        String newLastName = req.getParameter("newLastName");
        String newLogin = req.getParameter("newLogin");
        String newPass = req.getParameter("newPass");
        String newPhone = req.getParameter("newPhone");
        if (newName != null) {
            currentUser.setName(newName);
        }
        if (newLastName != null) {
            currentUser.setLastName(newLastName);
        }
        if (newLogin != null) {
            currentUser.setLogin(newLogin);
        }
        if (newPass != null) {
            currentUser.setPassword(newPass);
        }
        if (newPhone != null) {
            currentUser.setPhone(newPhone);
        }
        userService.updateUser(currentUser);
        resp.sendRedirect("/changeUserData");
//        getServletContext().getRequestDispatcher("/pages/changeUserData.jsp").forward(req, resp);
    }
}

