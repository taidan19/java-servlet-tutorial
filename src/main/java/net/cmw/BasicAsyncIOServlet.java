package net.cmw;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Basic example of async I/O in a Servlet
 */
@WebServlet(name = "basic-async-io",
        urlPatterns = {"/basic-async-io"},
        description = "Basic Async IO Example",
        asyncSupported = true) // notice the asyncSupported property`
public class BasicAsyncIOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        resp.addHeader("Content-Type", "text/plain");

        final AsyncContext async = req.startAsync();

        // We have to retrieve the response's stream as an ServletOutputStream
        final ServletOutputStream output = resp.getOutputStream();

        // We set our Listener class on the output stream
        output.setWriteListener(new BasicWriteListener(output, async));
    }
}

/**
 * A basic implementation of the WriteListener interface
 */
class BasicWriteListener implements WriteListener {

    private ServletOutputStream output;
    private AsyncContext async;

    public BasicWriteListener(ServletOutputStream output, AsyncContext async) {
        this.output = output;
        this.async = async;
    }

    @Override
    public void onWritePossible() throws IOException {
        if (output.isReady()) {
            output.print("Some content");
        }
        async.complete();
    }

    @Override
    public void onError(Throwable t) {
        System.out.println(t.getMessage());
        async.complete();
    }
}
