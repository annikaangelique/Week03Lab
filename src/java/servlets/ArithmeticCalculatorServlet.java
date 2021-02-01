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
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("result", "---");
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int first = 0;
        int second = 0;
        int result = 0;
        boolean valid = true;
        String firstString = request.getParameter("first");
        String secondString = request.getParameter("second");
        
        request.setAttribute("first", firstString);
        request.setAttribute("second", secondString);
        
        try {
            first = Integer.parseInt(firstString);
            second = Integer.parseInt(secondString);
        }
        catch (NumberFormatException e) {
            valid = false;
        }
        
        if (valid == false) {
            request.setAttribute("result", "invalid");
        } else {
            if (request.getParameter("+") !=null) {
                result = first + second;
                request.setAttribute("result", result);
            } else if (request.getParameter("-") !=null) {
                result = first - second;
                request.setAttribute("result", result);
            } else if (request.getParameter("*") !=null) {
                result = first * second;
                request.setAttribute("result", result);
            } else if (request.getParameter("%") !=null) {
                if (second == 0) {
                    request.setAttribute("result", "Can't mod by 0");
                } else {
                    result = first % second;
                    request.setAttribute("result", result);
                }
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }
}
