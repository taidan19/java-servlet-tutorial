package net.cmw;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * How to programmatically add components to a web application
 */
@WebListener
public class ProgrammaticServletConfigurationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        // We create an instance of ServletRegistration.Dynamic, and add to it
        // all the configuration parameters for the Servlet.
        ServletRegistration.Dynamic dynamic =
                servletContext.addServlet("Dynamic Basic Servlet", "net.cmw.BasicServlet");
        dynamic.addMapping("/basic-dynamic"); // URL mapping

        // Adding Filters and Listeners is done in a similar fashion.
        //
        // FilterRegistration.Dynamic filterDynamic = servletContext.addFilter("new.cmw.LoggingFilter");
        // servletContext.addListener("net.cmw.BasicServletRequestListener");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
