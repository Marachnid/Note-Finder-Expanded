package note.finder.controller;


import note.finder.entity.MusicalScale;
//import note.finder.persistence.MusicalScaleDao;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/editScale")
public class EditScaleRouter extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//
//        MusicalScaleDao scaleDao = new MusicalScaleDao();
//        int id = Integer.parseInt(request.getParameter("id"));
//        MusicalScale scaleToEdit = scaleDao.getById(id);
//
//        request.setAttribute("scaleToEdit", scaleToEdit);
//        request.getSession().setAttribute("scaleToEdit", scaleToEdit);
//        response.sendRedirect(request.getContextPath() + "/modifyScalesRouter");
    }
}
