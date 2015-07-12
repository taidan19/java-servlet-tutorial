package net.cmw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Basic example of a Servlet Request Listener
 */
public class BasicServletRequestListener implements ServletRequestListener {
    Logger logger = LoggerFactory.getLogger(BasicServletRequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("Request incoming!");

        // We can access both the Context and the Request
        ServletContext context = sre.getServletContext();
        ServletRequest request = sre.getServletRequest();
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("Request finished");
    }
}
