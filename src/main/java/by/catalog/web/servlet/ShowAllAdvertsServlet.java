package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllAdvertsServlet", urlPatterns = "/index")
public class ShowAllAdvertsServlet extends HttpServlet {

    AdvertService advertService = new AdvertService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Advert> allAdverts = advertService.findAllAdverts();
        req.setAttribute("allAdverts", allAdverts);
        resp.sendRedirect("/index");
    }
}
