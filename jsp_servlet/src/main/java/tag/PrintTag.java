package tag;

import java.io.IOException;
import java.io.StringWriter;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class PrintTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		StringWriter writer = new StringWriter();
		JspWriter out = getJspContext().getOut();
		getJspBody().invoke(writer);
		out.print(writer.toString());
	}
}
