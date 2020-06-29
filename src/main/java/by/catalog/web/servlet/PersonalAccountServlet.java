package by.catalog.web.servlet;

import by.catalog.domain.User;
import by.catalog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/pers")
public class PersonalAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        long id = currentUser.getId();
        User user = userService.returnUserById(id);
        req.setAttribute("user", user);
        String messageUpdate = (String) req.getSession().getAttribute("messageUpdate");
        req.setAttribute("messageUpdate", messageUpdate);
        req.getSession().removeAttribute("messageUpdate");
        getServletContext().getRequestDispatcher("/pages/pers.jsp").forward(req, resp);


    }


}



