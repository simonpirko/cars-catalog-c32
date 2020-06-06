package by.catalog.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

    @WebServlet(urlPatterns = "/home")
    public class HomepageServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Calendar calendar = new GregorianCalendar();
            Date data = calendar.getTime();


            Date time = (Date) getServletContext().getAttribute("name");
            resp.getWriter().println(time);

            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(df);

            req.setAttribute("calendar", df + "  " + data);
            req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }





