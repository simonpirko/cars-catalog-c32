package by.catalog.web.servlet;

import by.catalog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/destroyProfile")
public class DestroyProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("admin") != null) {
            UserService userService = new UserService();
            Long idDel = (Long) req.getSession().getAttribute("idDel");
            userService.destroyUser(idDel);
            resp.sendRedirect("/changeProfile");
        }
    }
}
