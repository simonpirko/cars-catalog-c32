//package by.catalog.web.servlet;
//
//import by.catalog.domain.Advert;
//import by.catalog.domain.User;
//import by.catalog.storage.AdvertStorage;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet (name = "getAllAdvertsServlet", urlPatterns = "/getAllUserAdverts")
//public class GetAllUserAdvertsServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User currentUser = (User) req.getSession().getAttribute("currentUser");
//        String currentUserLogin = currentUser.getLogin();
//        AdvertStorage advertStorage = new AdvertStorage();
//        List<Advert> advertsList = advertStorage.findAllAdvertsByUser(currentUserLogin);
//        req.setAttribute("currentUserAdvertsList", advertsList);
//        long advertsListLength = advertsList.size();
//        req.getSession().setAttribute("currentAdvertsListLength", advertsListLength);
//        getServletContext().getRequestDispatcher("/pages/changeCurrentAdvert.jsp").forward(req, resp);
//    }
//}
