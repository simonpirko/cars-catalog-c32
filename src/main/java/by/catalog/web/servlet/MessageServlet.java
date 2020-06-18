package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.domain.User;
import by.catalog.service.AdvertService;
import by.catalog.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MessageServlet", urlPatterns = "/MessageServlet")
public class MessageServlet extends HttpServlet {

    AdvertService advertService = new AdvertService();
    MessageService messageService = new MessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idAdvert = (long) req.getAttribute("advertId");
//        String modelFromAdvert = advertService.getModelFromAdvert(idAdvert);
//        req.setAttribute("model", modelFromAdvert);
//        String colorFromAdvert = advertService.getColorFromAdvert(idAdvert);
//        req.setAttribute("color", colorFromAdvert);
//        String nameFromAdvert = advertService.getUserNameFromAdvert(idAdvert);
//        req.setAttribute("name", nameFromAdvert);
//        String lastNameFromAdvert = advertService.getUserLastNameFromAdvert(idAdvert);
//        req.setAttribute("lastName", lastNameFromAdvert);
//        String phoneFromAdvert = advertService.getUserPhoneFromAdvert(idAdvert);
//        req.setAttribute("phone", phoneFromAdvert);
//        int yearFromAdvert = advertService.getYearFromAdvert(idAdvert);
//        req.setAttribute("year", yearFromAdvert);
//        List<Message> userMessages = advertService.getUserMessagesFromAdvert(idAdvert);
//        req.setAttribute("messges", userMessages);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addMessage = req.getParameter("addMessage");
        Advert currentAdvert = (Advert) req.getAttribute("currentAdvert");
        long idCurrentAdvert = currentAdvert.getId();
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        long idCurrentUser = currentUser.getId();
        messageService.saveMessage(idCurrentAdvert, idCurrentUser, addMessage);
        // FIXME: 6/13/20
//        advertService.addMessageToAdvertById(currentMessageId, addMessage);
        resp.sendRedirect("/advert");
    }
}
