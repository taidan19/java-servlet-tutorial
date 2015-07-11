package net.cmw;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Basic example of a Java Servlet.
 */
public class BasicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
         * We can add HTTP Header values to the Response
         */
        resp.addHeader("Content-Type", "text/plain");

        /*
         * The response object contains a PrintWriter, which we can use to add content to the response body.
         */
        PrintWriter writer = resp.getWriter();
        writer.print("This is a test string");
    }
}
