package by.catalog.web.servlet;

import by.catalog.domain.Advert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "ChangeAdvertServlet", urlPatterns = "/changeAdvert")
public class ChangeAdvertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int advertNumber = (int) req.getSession().getAttribute("advertNumber");
        List<Advert> currentUserAdverts = (List<Advert>) req.getSession().getAttribute("currentUserAdverts");
        Advert advert = currentUserAdverts.get(advertNumber);
        req.getSession().setAttribute("currentAdvert", advert);
        req.getServletContext().getRequestDispatcher("/pages/changeAdvert").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Advert> currentUserAdverts = (List<Advert>) req.getSession().getAttribute("currentUserAdverts");
        int advertNumber = (int) req.getSession().getAttribute("advertNumber");
        Advert advert = currentUserAdverts.get(advertNumber);
        int paramForChange = (int) req.getSession().getAttribute("name");
        switch (paramForChange) {
            case 1:
                advert.setModelCar("");
            case 2:
            case 3:
            case 4:
            case 5:

        }
    }
}
