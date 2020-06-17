package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveAdvertToServlet", urlPatterns = "/saveAdvert")
public class SaveAdvertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //сюда приходит с главной страницы запрос на добавление объявления автотизованного юзера
        long advertForSaveId = (Long) req.getAttribute("advertId");
        long userToSaveAdvert = (Long) req.getAttribute("userToSaveAdvertId");
        AdvertService advertService = new AdvertService();
        Advert advertById = advertService.findAdvertById(advertForSaveId);
        advertService.saveAdvertToUserAdvertList(advertById, userToSaveAdvert);
        resp.sendRedirect("/");
    }
}