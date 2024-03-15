package com.hostmdy.appstore.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.jakartaee.commons.compress.utils.FileNameUtils;

import com.hostmdy.appstore.model.Post;
import com.hostmdy.appstore.model.PostDAO;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@MultipartConfig
@WebServlet("/post")
public class PostController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PostDAO postDAO;
	@Resource(name="jdbc/dbResource")
	DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		 postDAO = new PostDAO(dataSource);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mode = req.getParameter("mode");
		
		if(mode == null) {
			mode = "LIST";
		}
		
		switch (mode) {
		case "LIST":
			showAllPost(req, resp);
			break;
		case "FORM":
			showAddForm(req, resp);
			break;
		case "POSTLIST":
			postList(req, resp);
			break;
		case "CREATE":
			createPost(req, resp);
			break;
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		
	}
	
	
	private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher  = req.getRequestDispatcher("view/dashboard/post/addPost.jsp");
		dispatcher.forward(req, resp);
	}
	
	private String uploadImage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Part filePart = req.getPart("image");
		String fileName = filePart.getSubmittedFileName();
		String extension = filePart.getSubmittedFileName().substring(fileName.indexOf(".")+1);
		String newFilename = filePart.getName()+"_"+Math.random()+"."+extension;
		BufferedInputStream bufferIn = new BufferedInputStream(filePart.getInputStream());
		
		BufferedOutputStream bufferOut = new BufferedOutputStream(new FileOutputStream("C:\\Users\\User\\Desktop\\javaEEWS\\app_store\\src\\main\\webapp\\images\\"+newFilename));
		
		byte[] buffer = new byte[4096];
		
		bufferOut.write(buffer,0,buffer.length);
		
		while(bufferIn.read(buffer,0,buffer.length) != -1) {
			bufferOut.write(buffer,0,buffer.length);
		}
		bufferIn.close();
		bufferOut.close();
		return newFilename;
	}
	
	private void createPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			
			String fileName = uploadImage(req, resp);
			String title= req.getParameter("title");
			String description = req.getParameter("description");
			String min_req= req.getParameter("min_req");
			LocalDateTime datetime= LocalDateTime.parse(req.getParameter("release_date"));
			
			Post post = new Post(1L,fileName,title,description,datetime,min_req);
	
	}
	
	private void showAllPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Post> posts = postDAO.getAllPost();
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/index.jsp");
		req.setAttribute("posts", posts);
		dispatcher.forward(req, resp);
		
	}
	
	private void postList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Post> posts = postDAO.getAllPost();
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/dashboard/post/postList.jsp");
		req.setAttribute("posts", posts);
		dispatcher.forward(req, resp);
	}
	
}
