package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/life")
public class LifeCycleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LifeCycleServlet is Initialized");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LifeCycleService is Worked");
		super.service(arg0, arg1);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		out.print("Handler Method : Get is Worked");
		System.out.println("Do get Handler method is worked");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Servlet is Destroy");
	}
}
