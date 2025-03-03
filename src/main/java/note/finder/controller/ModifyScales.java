package note.finder.controller;

import note.finder.entity.MusicalScale;
//import note.finder.persistence.MusicalScaleDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * processing servlet to handle inserting new scales into db
 */
@WebServlet(urlPatterns = {"/addScale"})
public class ModifyScales extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());


//    /**
//     * gets form submission and processes request to insert new scale record
//     * @param request Https request object
//     * @param response Https response
//     * @throws ServletException In event of servlet failure
//     * @throws IOException In event of IO failure
//     */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        MusicalScaleDao scaleDao = new MusicalScaleDao();
//        MusicalScale newScale = returnNewScaleObject(request);
//        String nameValidation = scaleDao.getByPropertyName(newScale.getName()); //== null if no records found
//
//        processRequest(request, nameValidation, scaleDao, newScale);
//
//        response.sendRedirect(request.getContextPath() + "/modifyScalesRouter");
//        request.removeAttribute("message");
//    }
//
//    /**
//     * handles request processing, determines if scale name is unique and can be added
//     * sets request attributes
//     * @param request Https request object
//     * @param nameValidation queried result searching db for duplicate scale names (can be null)
//     * @param scaleDao ScaleDao object
//     * @param newScale newScale
//     */
//    private void processRequest(HttpServletRequest request, String nameValidation,
//            MusicalScaleDao scaleDao, MusicalScale newScale) {
//
//        if (nameValidation != null) {
//            request.setAttribute("message", "Scale name already exists");
//
//        } else {
//            scaleDao.insert(newScale);
//            request.setAttribute("message", "Scale added successfully");
//        }
//    }
//
//    /**
//     * constructs and returns MusicalScale object from form inputs
//     * @param request object
//     * @return MusicalScale object
//     */
//    private MusicalScale returnNewScaleObject(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        int root = Integer.parseInt(request.getParameter("root"));
//        int second = Integer.parseInt(request.getParameter("second"));
//        int third = Integer.parseInt(request.getParameter("third"));
//
//        return new MusicalScale(name, root, second, third);
//    }
}
