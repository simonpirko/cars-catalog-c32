package by.catalog.web.servlet;

import by.catalog.domain.User;
import by.catalog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProfileServlet", urlPatterns = "/pers/editProfile")
public class EditProfileServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("admin") != null
                && req.getSession().getAttribute("user4Admin") == null) {
            String id = req.getParameter("id");
            if (id != null) {
                long newId = Long.parseLong(id);
                User user = userService.returnUserById(newId);
                req.getSession().setAttribute("user4Admin", user);
                req.getSession().setAttribute("check4Admin", true);
            }
        }
        req.getServletContext().getRequestDispatcher("/pages/editProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("newName");
        String newLastName = req.getParameter("newLastName");
        String newLogin = req.getParameter("newLogin");
        String newPass = req.getParameter("newPass");
        String newPhone = req.getParameter("newPhone");
        if (req.getSession().getAttribute("admin") != null) {
            User user4Admin = (User) req.getSession().getAttribute("user4Admin");
            req.getSession().setAttribute("idDel", user4Admin.getId());
            req.getSession().setAttribute("user4Admin", new User(user4Admin.getId(), newName, newLastName, newLogin, newPass, newPhone));
            userService.editUserById(new User(user4Admin.getId(), newName, newLastName, newLogin, newPass, newPhone));
            resp.sendRedirect("/changeProfile");
        } else {
            User currentUser = (User) req.getSession().getAttribute("currentUser");
            req.getSession().setAttribute("currentUser", new User(currentUser.getId(), newName, newLastName, newLogin, newPass, newPhone));
            userService.editUserById(new User(currentUser.getId(), newName, newLastName, newLogin, newPass, newPhone));
            resp.sendRedirect("/pers");
        }


        req.getSession().setAttribute("messageUpdate", "Update successfully");

    }
}

