package servlets;

import controllers.Controller;
import controllers.ControllerFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yuri Serrano
 */

@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontControllerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
            //get Controllers name from request
            String controller = request.getParameter("control");
            //Instantiate controller class
            Controller control = ControllerFactory.getControllerByFullClassName(controller);
            //initialize controller
            control.init(request);

            control.execute();
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(control.getReturnPage());
            requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

}
