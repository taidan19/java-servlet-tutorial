package net.cmwolfe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Example of how to use a Servlet to redirect requests to a JSP page,
 * thus behaving as a poor man's MVC framework.
 */
public class MVCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // First we need to get this query param. from the URL.
        String field = req.getParameter("field");

        // We are trying to simulate the behavior of an MVC app,
        // so let's pretend to fetch some data
        FakeModelClass model = new FakeModelClass();
        String data = model.getSomeData(field);

        // We add our data to the request object. Here we are
        // adding a String, but you could add any Java object you want
        // to the request.
        req.setAttribute("reversed_string", data);

        // This is how we send the request and response to the JSP page
        // using a RequestDispatcher.
        RequestDispatcher rd= req.getRequestDispatcher("mvc.jsp");
        rd.forward(req, resp);
    }
}
