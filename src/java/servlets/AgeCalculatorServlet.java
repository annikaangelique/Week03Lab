package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Annika Vestre
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int age = 0;
        boolean valid = true;
        String ageString = request.getParameter("age");
        
        request.setAttribute("age", ageString);
        
        try {
            age = Integer.parseInt(ageString) + 1;
        }
        catch (NumberFormatException e) { 
            valid = false;
        }
        
        if (age < 0) {
            valid = false;
        }
        
        if (valid == false) {
            request.setAttribute("message", "You must give your current age");
        } else {
            request.setAttribute("message", "Your age next birthday will be " + age);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }
}
