package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.domain.User;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditAdvertEditDescriptionServlet", urlPatterns = "/editAdvert/editDescription")
public class EditAdvertEditDescriptionServlet extends HttpServlet {
    private final AdvertService advertService = new AdvertService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idAdvert = Long.parseLong(req.getParameter("id"));
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.setAttribute("id", idAdvert);
        Advert advert = advertService.getAdvert(idAdvert);
        req.setAttribute("advert", advert);
        String editDescription = req.getParameter("editDescription");
        if (editDescription != null) {
            req.setAttribute("choiceDescription", true);
        }
        String specificationAdvert = req.getParameter("specificationAdvert");
        if (req.getSession().getAttribute("admin") != null && specificationAdvert != null) {
            advertService.editSpecification(idAdvert, specificationAdvert);
        } else if (specificationAdvert != null) {
            advertService.editSpecificationByIdAdvert(idAdvert, currentUser.getId(), specificationAdvert);
            } else {
            getServletContext().getRequestDispatcher("/pages/editAdvert.jsp").forward(req, resp);
        }
        resp.sendRedirect("/editAdvert?id=" + idAdvert);
    }

}
