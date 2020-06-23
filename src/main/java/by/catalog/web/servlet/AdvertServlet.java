package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.domain.Message;
import by.catalog.domain.User;
import by.catalog.service.AdvertService;
import by.catalog.service.UserService;
import by.catalog.storage.MessageStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/advert")
public class AdvertServlet extends HttpServlet {
    AdvertService advertService = new AdvertService();
    UserService userService = new UserService();
    MessageStorage messageStorage = new MessageStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idAdvert = Long.parseLong( req.getParameter("id"));
        req.setAttribute("id", idAdvert);
        Advert advert = advertService.getAdvert(idAdvert);
        req.setAttribute("advert", advert);
        User user = (User) userService.returnUserById(advert.getIdUser());
        req.setAttribute("user", user);
        List<Message> userMessages = messageStorage.returnMessageByIdAdvert(idAdvert);
        req.setAttribute("messages", userMessages);
        req.getServletContext().getRequestDispatcher("/pages/advert.jsp").forward(req, resp);
    }
}

