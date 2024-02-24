package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		String description = request.getParameter("description");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Form Read</title></head>");
		out.print("<body><h1>Employee Information :</h1>"
				+"<p> firstname : "+ firstname+"</p>"
				+ "<p> lastname : "+lastname+"</p>"
				+ "<p> email : "+email+"</p>"
				+ "<p> password : "+password+"</p>"
				+ "<p> role : "+role+"</p>"
				+ "<p> gender : "+gender+"</p>"
				+ "<h3>Employee Hobby List</h3>");
		out.print("<ul>");
		for(final String hobby:hobbies) {
			out.print("<li>"+hobby+"</li>");
		}
		out.print("</ul>");
		out.print("<p>"+description+"</p>");
		out.print("</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
