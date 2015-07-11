package net.cmw;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Implementation of {@link HttpServletResponseWrapper} that returns
 * its own output stream, thus protecting the wrapped response's stream.
 */
public class BasicResponseWrapper extends HttpServletResponseWrapper{

    private CharArrayWriter outWriter;

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response
     * @throws IllegalArgumentException if the response is null
     */
    public BasicResponseWrapper(HttpServletResponse response) {
        super(response);
        outWriter = new CharArrayWriter();
    }

    @Override
    public String toString() {
        return outWriter.toString();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(outWriter);
    }
}
