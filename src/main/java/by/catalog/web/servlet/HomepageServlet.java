package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(urlPatterns = "/")
public class HomepageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdvertService advertService = new AdvertService();
        String[] colorList = advertService.colorList();
        req.setAttribute("colorList", colorList);

        StringBuffer requestURL = req.getRequestURL();
        req.setAttribute("URL", requestURL);
        String queryString = req.getQueryString();
        req.setAttribute("query", queryString);
        if (queryString != null && queryString.contains("page")) {
            String newQ = queryString.substring(0, queryString.lastIndexOf("page=") + 5);
            req.setAttribute("query", newQ);
        } else if (queryString != null) {
            String newQ = queryString + "&page=";
            req.setAttribute("query", newQ);
        } else {
            String newQ = "color=anyColor&page=";
            req.setAttribute("query", newQ);
        }

        int count = 4;
        int pageS = 1;
        String page = req.getParameter("page");
        if (page != null)
            pageS = Integer.parseInt(page);

        String color = req.getParameter("color");
        if (color != null && !color.equals("anyColor")) {
            List lastAdverts = advertService.getLastAdvertsByColor(color, count, pageS);
            ArrayList advertList = new ArrayList<>(lastAdverts);
            req.setAttribute("advertList", advertList);
        } else {
            List lastAdverts = advertService.getLastAdverts(count, pageS);
            ArrayList advertList = new ArrayList<>(lastAdverts);
            req.setAttribute("advertList", advertList);
        }


        List MarkList = advertService.returnSortMark();
        req.setAttribute("AllAdvertMarks", MarkList);

        String sort = req.getParameter("sort");
        if (sort != null
                && !sort.equalsIgnoreCase("none")
                && (sort.equalsIgnoreCase("descPrice")
                || sort.equalsIgnoreCase("ascPrice"))) {
            List<Advert> sortedAllAdvertListByPrice = advertService.sortAllAdvertListByPrice(sort, color, count, pageS);
            req.setAttribute("advertList", sortedAllAdvertListByPrice);
        } else if (sort != null
                && !sort.equalsIgnoreCase("none")
                && (sort.equalsIgnoreCase("descYear")
                || sort.equalsIgnoreCase("ascYear"))) {
            List<Advert> sortedAllAdvertListByYear = advertService.sortAllAdvertListByYear(sort, color, count, pageS);
            req.setAttribute("advertList", sortedAllAdvertListByYear);
        }


        String mark = req.getParameter("mark");
        if (mark != null) {
            if (mark.equals("anyMark")) {
                req.setAttribute("hadChosen", false);
            } else {
                List<String> modelByMark = advertService.returnModelByMark(mark);
                req.setAttribute("modelByMark", modelByMark);
                req.setAttribute("mark", mark);
                req.setAttribute("hadChosen", true);
                if (sort != null
                        && !sort.equalsIgnoreCase("none")
                        && (sort.equalsIgnoreCase("descPrice")
                        || sort.equalsIgnoreCase("ascPrice"))) {
                    List<Advert> sortedAdvertByMark = advertService.sortMarkAdvertListByPrice(sort, mark, color, count, pageS);
                    req.setAttribute("advertList", sortedAdvertByMark);
                } else if (sort != null
                        && !sort.equalsIgnoreCase("none")
                        && (sort.equalsIgnoreCase("descYear")
                        || sort.equalsIgnoreCase("ascYear"))) {
                    List<Advert> sortedAdvertByYear = advertService.sortMarkAdvertListByYear(sort, mark, color, count, pageS);
                    req.setAttribute("advertList", sortedAdvertByYear);
                } else {
                    List<Advert> advertByMark = advertService.findAdvertByMark(mark, color, count, pageS);
                    req.setAttribute("advertList", advertByMark);
                }
            }
        }


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

        StringBuffer requestURL = req.getRequestURL();
        req.setAttribute("URL", requestURL);
        String queryString = req.getQueryString();
        req.setAttribute("query", queryString);
        if (queryString != null && queryString.contains("page")) {
            String newQ = queryString.substring(0, queryString.lastIndexOf("page=") + 5);
            req.setAttribute("query", newQ);
        } else if (queryString != null) {
            String newQ = queryString + "&page=";
            req.setAttribute("query", newQ);
        } else {
            String newQ = "color=anyColor&page=";
            req.setAttribute("query", newQ);
        }


        String markCar = req.getParameter("mark");

        req.setAttribute("mark", markCar);
        String model = req.getParameter("model");
        String sort = req.getParameter("postSort");
        String color = req.getParameter("postColor");
        int count = 4;
        int pageS = 1;
        String page = req.getParameter("PostPage");
        if (page != null)
            pageS = (Integer.parseInt(page) - 1) * count;

        if (!model.equalsIgnoreCase("anyModel")) {
            if (sort != null
                    && !sort.equalsIgnoreCase("none")
                    && (sort.equalsIgnoreCase("descPrice")
                    || sort.equalsIgnoreCase("ascPrice"))) {
                List<Advert> sortedModelAdvertListByPrice = advertService.sortModelAdvertListByPrice(sort, model, color, count, pageS);
                req.setAttribute("advertList", sortedModelAdvertListByPrice);
            } else if (sort != null
                    && !sort.equalsIgnoreCase("none")
                    && (sort.equalsIgnoreCase("descYear")
                    || sort.equalsIgnoreCase("ascYear"))) {
                List<Advert> sortedModelAdvertListByYear = advertService.sortModelAdvertListByYear(sort, model, color, count, pageS);
                req.setAttribute("advertList", sortedModelAdvertListByYear);
            } else {
                List<Advert> advertByModel = advertService.findAdvertByModel(markCar, model, color, count, pageS);
                req.setAttribute("advertList", advertByModel);
            }

        } else {
            if (sort != null
                    && !sort.equalsIgnoreCase("none")
                    && (sort.equalsIgnoreCase("descPrice")
                    || sort.equalsIgnoreCase("ascPrice"))) {
                List<Advert> sortedMarkAdvertList = advertService.sortMarkAdvertListByPrice(sort, markCar, color, count, pageS);
                req.setAttribute("advertList", sortedMarkAdvertList);
            } else if (sort != null
                    && !sort.equalsIgnoreCase("none")
                    && (sort.equalsIgnoreCase("descYear")
                    || sort.equalsIgnoreCase("ascYear"))) {
                List<Advert> sortedMarkAdvertListByYear = advertService.sortMarkAdvertListByYear(sort, markCar, color, count, pageS);
                req.setAttribute("advertList", sortedMarkAdvertListByYear);
            } else {
                List<Advert> advertByMark = advertService.findAdvertByMark(markCar, color, count, pageS);
                req.setAttribute("advertList", advertByMark);
            }
        }

        req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}