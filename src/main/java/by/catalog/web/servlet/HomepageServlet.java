package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(urlPatterns = "/")
public class HomepageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdvertService advertService = new AdvertService();
        List lastAdverts = advertService.getLastAdverts();
        ArrayList advertList = new ArrayList<>(lastAdverts);
        req.setAttribute("advertList", advertList);


        List MarkList = advertService.returnSortMark();
        req.setAttribute("AllAdvertMarks", MarkList);


        Calendar calendar = new GregorianCalendar();
        Date data = calendar.getTime();


        Date time = (Date) getServletContext().getAttribute("name");
        resp.getWriter().println(time);

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(df);


        req.setAttribute("calendar", df + "  " + data);
        req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdvertService advertService = new AdvertService();
        List MarkList = advertService.returnSortMark();
        req.setAttribute("AllAdvertMarks", MarkList);
        String markCar = req.getParameter("mark");
        if (!markCar.equals("anyMark")) {
            List<Advert> advertByModel = advertService.findAdvertByMark(markCar);
            req.setAttribute("advertList", advertByModel);
//            List<String> modelByMark = advertService.returnModelByMark(markCar);
//            req.setAttribute("modelByMark", modelByMark);
//            String modelCar = req.getParameter("models");
//            if (!modelCar.equals("anyModel")) {
//                List<Advert> advertByModel1 = advertService.findAdvertByModel(markCar, modelCar);
//                req.setAttribute("advertList", advertByModel1);
//            }
        } else {
            List lastAdverts = advertService.getLastAdverts();
            ArrayList advertList = new ArrayList<>(lastAdverts);
            req.setAttribute("advertList", advertList);
        }
        req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}





