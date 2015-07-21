package net.cmw;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * An example of an Async Listener
 */
@WebListener
public class BasicAsyncListener implements AsyncListener {

    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        // This method is called when an async event is finished processing
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        // This method is called when an async event times out
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        // This method is called if an error occurs during processing
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        // This method is called when async processing begins
    }
}
