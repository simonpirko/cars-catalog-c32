package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.domain.User;
import by.catalog.storage.AdvertStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "getAllAdvertsServlet", urlPatterns = "/getAllAdverts")
public class GetAllUserAdverts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String currentUserLogin = currentUser.getLogin();
        AdvertStorage advertStorage = new AdvertStorage();
        List<Advert> advertsList = (List<Advert>) advertStorage.findAllAdvertsByUser(currentUserLogin);
        req.getSession().setAttribute("currentUserAdvertsList", advertsList);
        long advertsListLength = advertsList.size();
        req.getSession().setAttribute("curretAdvertsListLength", advertsListLength);
        getServletContext().getRequestDispatcher("/pages/changeAdvert.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
