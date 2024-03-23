package com.hostmdy.appstore.controller;

import java.io.IOException;

import javax.sql.DataSource;

import com.hostmdy.appstore.model.UserDAO;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserDAO userDAO;
	@Resource(name="jdbc/dbResource")
	DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		userDAO = new UserDAO(dataSource);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mode = req.getParameter("mode");
		
		if(mode == null) {
			mode = "FORM";
		}
		
		switch (mode) {
		 case "FORM":
		 	   showLoginForm(req,resp);
			   break;
		 case "LOGIN":
			   login(req,resp);
			   break;
		case  "LOGOUT":
			   logout(req,resp);
			   break;
	
		}
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	private void showLoginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/dashboard/user/sign-in.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			Boolean ok = userDAO.authenticate(username, password);
			if(ok) {
				resp.sendRedirect("post");
			}
		
	}
	
	private void logout(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	
}
