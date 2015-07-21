package net.cmw;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Basic example of an asynchronous Servlet.
 */
@WebServlet(name = "basic-async-servlet",
        urlPatterns = {"/basic-async"},
        description = "Basic Async Servlet Example",
        asyncSupported = true) // notice the asyncSupported property
public class BasicAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        resp.addHeader("Content-Type", "text/plain");

        // The AsyncContext object is an async-capable ServletContext.
        // We need to make this method call to start async processing.
        final AsyncContext async = req.startAsync();

        // You can adjust how long the server will wait for the async process to run.
        async.setTimeout(500);

        final PrintWriter writer = resp.getWriter();

        // Create a Runnable that will run in its own Thread.
        Runnable runner = new Runnable() {
            @Override
            public void run() {

                // We marked the response's output writer as final,
                // so we can use it here in the Runnable.
                writer.write("Some content\n");

                // Simulate a long running process.
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                writer.write("more content");

                // We *have* to call async.complete() to notify the server
                // that async processing is finished.
                async.complete();
            }
        };

        runner.run();
    }
}
