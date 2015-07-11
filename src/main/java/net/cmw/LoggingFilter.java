package net.cmw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Basic Filter example which logs incoming requests.
 */
public class LoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    private String testValue;

    /**
     * This method is called when the filter is created. The FilterConfig object passed in contains
     * key/value pairs which can be configured in the web.xml file.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        testValue = filterConfig.getInitParameter("testValue");
    }

    /**
     * Web apps can have multiple filters, which the server chains together; calling the doFilter() method
     * will pass the request and response objects to the next filter in the chain. When it arrives at the last filter,
     * the doFilter() method will pass the request and response to the Servlet itself.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        logger.info("Request incoming from " + request.getRemoteHost());
        logger.info("Our test value is " + testValue);

        // Wrap the response
        HttpServletResponse wrappedResponse =
                new BasicResponseWrapper((HttpServletResponse)response);

        // Pass in the wrapper
        chain.doFilter(request, wrappedResponse);

        // Grab the content from the wrapper's output stream
        CharArrayWriter writer = new CharArrayWriter();
        writer.write(wrappedResponse.toString());

        // modify the wrapper's content and write into the response
        PrintWriter out = response.getWriter();
        out.write("Our test value is " + testValue + "\n");
        out.write(writer.toString());
        out.write("\nIsn't that great?");
    }

    /**
     * Called when the filter is being destroyed at web app shutdown. You generally don't have to write anything
     * concrete in this method.
     */
    @Override
    public void destroy() {}
}
