package com.hostmdy.appstore.controller;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.sql.DataSource;
import com.hostmdy.appstore.model.Post;
import com.hostmdy.appstore.model.PostDAO;
import com.hostmdy.appstore.model.Tag;

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
		case "DETAIL":
			 showDetail(req, resp);
		case "UPDATEFORM":
			showUpdateForm(req, resp);
		case "UPDATE":
		    update(req, resp);
		    break;
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		
	}
	
	
	
	private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Tag> tags= postDAO.getAllTag();
		System.out.println(tags);
		RequestDispatcher dispatcher  = req.getRequestDispatcher("view/dashboard/post/addPost.jsp");
		req.setAttribute("tags", tags);
		dispatcher.forward(req, resp);
	}
	
	private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("postId"));
		List<Tag> tags = postDAO.getAllTag();
		Post post = postDAO.getPostById(id);
		RequestDispatcher dispatcher  = req.getRequestDispatcher("view/dashboard/post/updatePost.jsp");
		req.setAttribute("tags", tags);
		req.setAttribute("post", post);
		dispatcher.forward(req, resp);
		
	}
	
	private String uploadImage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		   // Retrieves the file part from the request
		
		Random random  = new Random();
        Part filePart = req.getPart("image");
        String fileName = filePart.getSubmittedFileName();
        String extension = filePart.getSubmittedFileName().substring(fileName.indexOf(".")+1);
        String newFilename = filePart.getName()+random.nextInt(0,9999)+"."+extension;
        InputStream fileContent = filePart.getInputStream();
        String uploadDirectory = "C:\\Users\\User\\Desktop\\javaEEWS\\app_store\\src\\main\\webapp\\resource\\image\\" ;
        Files.copy(fileContent, Paths.get(uploadDirectory + newFilename));

      
        fileContent.close();
        
        
        
        
        return newFilename;
		
//		Random random = new Random();
//		Part filePart = req.getPart("image");
//		String fileName = filePart.getSubmittedFileName();
//		String extension = filePart.getSubmittedFileName().substring(fileName.indexOf(".")+1);
//		String newFilename = filePart.getName()+random.nextInt(0,100)+"."+extension;
//	    InputStream inputS = filePart.getInputStream();
//		BufferedOutputStream bufferOut = new BufferedOutputStream(new FileOutputStream("C:\\Users\\User\\Desktop\\javaEEWS\\app_store\\src\\main\\webapp\\resource\\image\\"+fileName));
//		
//		byte[] buffer = new byte[4096];
//		
//		bufferOut.write(buffer,0,buffer.length);
//		
//		while(inputS.read(buffer,0,buffer.length) != -1) {
//			bufferOut.write(buffer,0,buffer.length);
//		}
//		inputS.close();
//		bufferOut.close();
//		return newFilename;
//		
	
		
	}
	
	private void createPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			
			
			
			String fileName = uploadImage(req, resp);
			String title= req.getParameter("title");
			String description = req.getParameter("description");
			String min_req= req.getParameter("min_req");
			String datetime= req.getParameter("release_date");
			String app_link = req.getParameter("app_link");
			String[] tags = req.getParameterValues("tag[]");
			List<String> tagIds = Arrays.asList(tags);
			
			
			Post post = new Post(1L,fileName,title,description,datetime,min_req,app_link);
			post.setTagIds(tagIds);
			Boolean ok=postDAO.createPost(post);
			if(ok) {
				req.setAttribute("ok", ok);
				showAddForm(req, resp);
			}
			
			
	
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
	
	private void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("postId"));
		Post post = postDAO.getPostById(id);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("view/dashboard/post/postDetail.jsp");
		req.setAttribute("post", post);
		dispatcher.forward(req, resp);
		
	}
	
	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			
		String fileName = uploadImage(req, resp);
		Long postId=  Long.parseLong(req.getParameter("postId"));
		String title= req.getParameter("title");
		String description = req.getParameter("description");
		String min_req= req.getParameter("min_req");
		String datetime= req.getParameter("release_date");
		String app_link = req.getParameter("app_link");
		String[] tags = req.getParameterValues("tag[]");
		List<String> tagIds = Arrays.asList(tags);
		
		
		Post post = new Post(postId,1L,fileName,title,description,datetime,app_link,min_req);
		post.setTagIds(tagIds);
		Boolean ok=postDAO.update(post);
		if(ok) {
			req.setAttribute("ok", ok);
			showUpdateForm(req, resp);
		}
	}
	
}
