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

@WebServlet(urlPatterns = "/changeAdvertisement")
public class ChangeAdvertisement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdvertService advertService = new AdvertService();
        List<Advert> allAdvert = advertService.getAllAdvert();
        req.setAttribute("allAdvert", allAdvert);
        getServletContext().getRequestDispatcher("/pages/changeAdvertisement.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
