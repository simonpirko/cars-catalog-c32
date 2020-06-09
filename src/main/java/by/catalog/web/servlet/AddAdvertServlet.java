package by.catalog.web.servlet;

import by.catalog.domain.User;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addAdvert", name = "AddAdvertServlet")

public class AddAdvertServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/addAdvert.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdvertService advertService = new AdvertService();
        User currentUSer = (User) req.getSession().getAttribute("currentUSer");
        String model = req.getParameter("model");
        String color = req.getParameter("color");
        int year = Integer.parseInt(req.getParameter("year"));
        double prise = Double.parseDouble(req.getParameter("prise"));
        long id_user = currentUSer.getId();
        advertService.saveAdvert(model, color, year, prise, id_user);
        req.setAttribute("messageAccount", "Advert successfully added");
        getServletContext().getRequestDispatcher("pages/account.jsp").forward(req, resp);
    }
}
