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
 * Demonstration of how to use the ServletConfig class.
 */
public class ServletConfigExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Let's get the ServletConfig object, and use it to read some properties
        ServletConfig servletConig = this.getServletConfig();
        String servletName = servletConig.getServletName();
        String testParam = servletConig.getInitParameter("testParam");

        // We can get the ServletContext object from the ServletConfig,
        // or on its own by calling this.getServletContext()
        ServletContext servletContext = servletConig.getServletContext();

        // Now we can run all the same code we ran in the ServletContextExample class
        String param = servletContext.getInitParameter("webXMLLocation");

        // We can also get information about our application and environment
        int majorVersion = servletContext.getMajorVersion();
        int minorVersion = servletContext.getMinorVersion();

        PrintWriter writer = resp.getWriter();
        writer.println("Servlet name is" + servletName);
        writer.println("Our Servlet property is " + testParam);
        writer.println("Our web XML Location param is: " + param);
        writer.println("Servlet major version: " + majorVersion);
        writer.println("Servlet minor version: " + minorVersion);
    }
}
