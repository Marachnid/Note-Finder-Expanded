package note.finder.controller;


import note.finder.entity.MusicalScale;
//import note.finder.persistence.MusicalScaleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/updateScale")
public class EditScale extends HttpServlet {

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        MusicalScaleDao scaleDao = new MusicalScaleDao();
//        MusicalScale scaleToEdit = returnUpdatedScaleObject(request);
//
//        scaleDao.update(scaleToEdit);
//
//        request.removeAttribute("scaleToEdit");
//        response.sendRedirect(request.getContextPath() + "/modifyScalesRouter");
//
//    }


//    private MusicalScale returnUpdatedScaleObject(HttpServletRequest request) {
//
//        String name = request.getParameter("name");
//        int id = Integer.parseInt(request.getParameter("id"));
//        int root = Integer.parseInt(request.getParameter("root"));
//        int second = Integer.parseInt(request.getParameter("second"));
//        int third = Integer.parseInt(request.getParameter("third"));
//
//        return new MusicalScale(name, id, root, second, third);
//    }
}
