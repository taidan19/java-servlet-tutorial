package net.cmwolfe;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Example of a JSP custom tag that manipulates its body content.
 */
public class TagWithBody extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        StringWriter writer = new StringWriter();

        // Here we retrieve the tag body so we can use it.
        getJspBody().invoke(writer);
        getJspContext().getOut().write(writer.toString().toUpperCase());
    }
}
