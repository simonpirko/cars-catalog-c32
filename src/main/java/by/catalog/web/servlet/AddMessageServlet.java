package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AddMessageServlet", urlPatterns = "/addMessageServlet")
public class AddMessageServlet extends HttpServlet {

    AdvertService advertService = new AdvertService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addMessage = req.getParameter("addMessage");
        Advert currentAdvert = (Advert) req.getAttribute("currentAdvert");
        long currentMessageId = (long) req.getAttribute("currentAdvertId");
        // FIXME: 6/13/20
//        advertService.addMessageToAdvertById(currentMessageId, addMessage);
        resp.sendRedirect("/advert");
    }
}
