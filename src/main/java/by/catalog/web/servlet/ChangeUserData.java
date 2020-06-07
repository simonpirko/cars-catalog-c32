package by.catalog.web.servlet;

import by.catalog.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "ChangeUserData", urlPatterns = "/changeUserData.jsp")
public class ChangeUserData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String currentUserName = currentUser.getName();
        req.getSession().setAttribute("currentUserName", currentUserName);
        req.getServletContext().getRequestDispatcher("/pages/changeUserData.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String changesAccInfo = (String) req.getSession().getAttribute("changesAccInfo");


        switch (changesAccInfo) {
            case "changeName":
                User currentUser = (User) req.getSession().getAttribute("currentUser");

                currentUser.setName(req.getSession().setAttribute("currentUserName", newName));

        }
    }
}
