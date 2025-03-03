package note.finder.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import note.finder.entity.MusicalScale;
import note.finder.persistence.NoteFinderDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Routing servlet - only forwards user to scale management interface
 */
@WebServlet(urlPatterns = {"/modifyScalesRouter"})
public class ModifyScalesRouter extends HttpServlet {

    //logging class
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * forwards user to scale management interface
     * @param request Http object
     * @param response Http object
     * @throws ServletException in event of servlet failure
     * @throws IOException in event of IO failure
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("modifyScalesRouter executed: {}", LocalDateTime.now().toString());

        //includes a list of all existing scales on loading the page
        NoteFinderDao<MusicalScale> scaleDao = new NoteFinderDao<>(MusicalScale.class);
        scaleDao.getAll();
        request.setAttribute("scaleList", scaleDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/scaleManagementPage.jsp");
        dispatcher.forward(request, response);
    }
}