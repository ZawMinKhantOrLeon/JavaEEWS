package tag;

import java.io.IOException;
import java.time.LocalDateTime;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class DateTimeTag extends SimpleTagSupport {
	
	private String type;
	
	
	
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspWriter out = getJspContext().getOut();
		LocalDateTime today = LocalDateTime.now();
	
		
		if(type == null || type.isBlank()) {
			type="datetime";
		}
		
		switch (type) {
		case "date":
			out.print(today.toLocalDate());
			break;
		case "time":
			out.print(today.toLocalTime());
			break;
		case "datetime":
			out.print(today);
			break;
		default:
			out.print("Invalid Date Time");
			break;
		}
		
		
		
	}



	public void setType(String type) {
		this.type = type;
	}
}
