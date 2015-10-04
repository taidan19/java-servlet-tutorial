package net.cmwolfe;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * A <i>very</i> basic example of how to write a custom JSP tag.
 */
public class FirstSimpleTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("We can write text out to the body of the custom tag");
    }
}
