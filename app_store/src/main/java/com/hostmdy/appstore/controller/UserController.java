package com.hostmdy.appstore.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.hostmdy.appstore.model.User;
import com.hostmdy.appstore.model.UserDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserController extends HttpServlet {

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
			mode="FORM";
		}
		
		switch (mode) {
		case "FORM":
			  showSignUpForm(req,resp);
			  break;
		case "SIGNUP":
			  signUp(req,resp);
			  break;
		}

		
		
		
	}
	


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	private void showSignUpForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/dashboard/user/sign-up.jsp");
		dispatcher.forward(req, resp);
		
	}
	

	private void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new User(name,email,password);
		
		Boolean ok = userDAO.register(user);
		
		if(ok) {
			req.setAttribute("ok", ok);
			showSignUpForm(req, resp);
		}
		
		
	}
	
	

	
}
