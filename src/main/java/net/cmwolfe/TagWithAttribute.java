package net.cmwolfe;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Example of a JSP custom tag with a tag attribute.
 */
public class TagWithAttribute extends SimpleTagSupport {
    // The name of the field is the attribute name we'll use in the JSP page.
    private String prop;

    public void setProp(String prop) {
        this.prop= prop;
    }

    @Override
    public void doTag() throws JspException, IOException {

        boolean isEmpty = prop == null || prop.isEmpty();
        getJspContext().getOut().write("Is our attribute empty? " + (isEmpty ? "Yes" : "No"));
    }
}
