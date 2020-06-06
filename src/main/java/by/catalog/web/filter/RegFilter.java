package by.catalog.web.filter;

import by.catalog.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "RegServlet")

public class RegFilter extends HttpFilter {
    UserService userService = new UserService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String login = req.getParameter("login");
        if (!userService.checkUserByLogin(login)) {
            chain.doFilter(req, res);
        } else {
            String message = "User exists. Try another login";
            req.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, res);
        }
    }
}
