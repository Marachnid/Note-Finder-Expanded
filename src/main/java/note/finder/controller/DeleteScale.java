package note.finder.controller;


import note.finder.persistence.MusicalScaleDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/deleteScale")
public class DeleteScale extends HttpServlet {


    private final Logger logger = LogManager.getLogger(this.getClass());


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        MusicalScaleDao scaleDao = new MusicalScaleDao();
        int id = Integer.parseInt(request.getParameter("id"));
        scaleDao.delete(id);
        response.sendRedirect(request.getContextPath() + "/modifyScalesRouter");
    }
}
