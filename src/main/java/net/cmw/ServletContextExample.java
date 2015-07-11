package net.cmw;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Demonstration of how to use the ServletContext class.
 */
public class ServletContextExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = this.getServletContext();

        // We can retrieve config properties set in web.xml
        String param = servletContext.getInitParameter("webXMLLocation");

        // We can also get information about our application and environment
        int majorVersion = servletContext.getMajorVersion();
        int minorVersion = servletContext.getMinorVersion();

        PrintWriter writer = resp.getWriter();
        writer.println("Our web XML Location param is: " + param);
        writer.println("Servlet major version: " + majorVersion);
        writer.println("Servlet minor version: " + minorVersion);
    }
}
