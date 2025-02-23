package note.finder.controller;

import note.finder.entity.MusicalScale;
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


@WebServlet(urlPatterns = {"/addScale"})
public class ModifyScales extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MusicalScaleDao scaleDao = new MusicalScaleDao();
        MusicalScale newScale = returnNewScaleObject(request);

        String testName = newScale.getName();

        logger.info("New scale name: " + testName);

        String nameValidation = scaleDao.getPropertyName(testName);



        if (checkUniqueName(newScale, nameValidation)) {
            logger.info("Scale already exists");
        }


        scaleDao.insert(newScale);
        request.setAttribute("scale", newScale);

        RequestDispatcher dispatcher = request.getRequestDispatcher("scaleManagementPage.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * constructs and returns MusicalScale object from form inputs
     * @param request object
     * @return MusicalScale object
     */
    private MusicalScale returnNewScaleObject(HttpServletRequest request) {
        String name = request.getParameter("name");
        int root = Integer.parseInt(request.getParameter("root"));
        int second = Integer.parseInt(request.getParameter("second"));
        int third = Integer.parseInt(request.getParameter("third"));

        return new MusicalScale(name, root, second, third);
    }


    /**
     * checks if the Scale name being entered already exists
     * @param newScale MusicalScale object
     * @param existingName queried value of existing names (names are unique)
     * @return true if duplicate scale name, false if name is unique
     */
    private boolean checkUniqueName(MusicalScale newScale, String existingName) {
        logger.info("Existing name: " + existingName);
        String newName = newScale.getName();
        logger.info("New name: " + newScale.getName());
        return newName.equals(existingName);
    }
}
