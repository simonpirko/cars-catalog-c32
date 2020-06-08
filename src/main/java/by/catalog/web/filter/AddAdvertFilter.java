package by.catalog.web.filter;

import by.catalog.domain.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AddAdvertFilter", servletNames = "AddAdvertServlet")

public class AddAdvertFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException, NumberFormatException {

        if (req.getMethod().equals("POST")) {

            String model = req.getParameter("model");
            String color = req.getParameter("color");
            String year = req.getParameter("year");
            String prise = req.getParameter("prise");

            try {
                if (model != null || color != null || year != null || prise != null) {
                    if (Integer.parseInt(year) < 2021 && Integer.parseInt(year) > 1950 && Double.parseDouble(prise) > 0) {
                        chain.doFilter(req, res);
                    }
                } else {
                    req.setAttribute("checkAdvert", "Data not entered or entered incorrectly");
                    getServletContext().getRequestDispatcher("/pages/addAdvert.jsp").forward(req, res);
                }
            } catch (NumberFormatException e) {
                req.setAttribute("checkAdvert", "Data not entered or entered incorrectly");
                getServletContext().getRequestDispatcher("/pages/addAdvert.jsp").forward(req, res);
            }
        } else chain.doFilter(req, res);
    }
}
