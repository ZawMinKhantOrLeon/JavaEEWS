package com.hostmdy.appstore.controller;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.appstore.model.Tag;
import com.hostmdy.appstore.model.TagDAO;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tag")
public class TagController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TagDAO tagDAO;
	@Resource(name="jdbc/dbResource")
	DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		tagDAO = new TagDAO(dataSource);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mode = req.getParameter("mode");
		
		if(mode == null) {
			mode="LIST";
		}
		
		switch (mode) {
		case "LIST":
			  getAllTag(req,resp);
			  break;
		case "FORM":
			  showForm(req,resp);
			  break;
		case "CREATE":
			  createTag(req,resp);
			  break;
		case "UPDATEFORM":
			  showUpdateForm(req, resp);
			  break;
		case "UPDATE":
			  updateTag(req, resp);
			  break;
		case "DELETE":
			  delete(req, resp);
			  break;
		}
	}
	

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	private void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("test");
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/dashboard/tag/addTag.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	private void createTag(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Tag tag = new Tag(name);
		Boolean ok = tagDAO.createTag(tag);
		
		if(ok) {
			req.setAttribute("ok", ok);
			showForm(req, resp);
		}
		
	}
	
	private void getAllTag(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Tag> tags = tagDAO.getAllTag();
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/dashboard/tag/tagList.jsp");
		req.setAttribute("tags", tags);
		dispatcher.forward(req, resp);
		
		
	}
	
	
	public void  showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("tagId"));
		Tag tag = tagDAO.getTagById(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/dashboard/tag/updateTag.jsp");
		req.setAttribute("tag", tag);
		dispatcher.forward(req, resp);
	}
	
	public void updateTag(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		Long id = Long.parseLong(req.getParameter("tagId"));
		String name = req.getParameter("name");
		Tag tag = new Tag(id,name);
		Boolean ok = tagDAO.updateTag(tag);
		if(ok) {
			resp.sendRedirect("tag?mode=LIST");
		}
		else {
			req.setAttribute("ok", ok);
			showUpdateForm(req, resp);
		}
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Long id = Long.parseLong(req.getParameter("tagId"));
		Boolean ok = tagDAO.delete(id);
		if(ok) {
			resp.sendRedirect("tag?mode=LIST");
		}else {
			req.setAttribute("ok", ok);
			getAllTag(req, resp);
		}
	}
}
