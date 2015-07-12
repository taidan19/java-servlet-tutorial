package net.cmw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Basic example of a Servlet Context Listener.
 */
public class BasicServletContextListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(BasicServletContextListener.class);

    /**
     * Called when the Servlet Context is initialized
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Let's annoucne that the context is ready
        logger.info("Context is initialized");

        // We have access to the Servlet Context in here
        ServletContext context = sce.getServletContext();

        // This method is also a good place to run other tasks, such as:
        // * Initializing Spring beans
        // * Starting other, non-Servlet listeners
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Context is destroyed");

        // This method is also a good place to run other tasks, such as:
        // * Destroying Spring beans
        // * Stopping other, non-Servlet listeners
        // * Closing stray threads that are created (but not cleaned up)
        //   by other objects.
    }
}
