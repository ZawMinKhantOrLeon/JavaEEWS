package com.hostmdy.expense.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.expense.model.Item;
import com.hostmdy.expense.model.ItemDAO;
import com.hostmdy.expense.model.User;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/item")
public class ItemController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/dbResource")
	private DataSource dataSource;
	
	private ItemDAO itemDao;
	private User user;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		itemDao= new ItemDAO(dataSource);
		
	}
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		HttpSession session = req.getSession();
		user = (User) session.getAttribute("user");
		String mode= req.getParameter("mode");
			
			if(mode==null) {
				mode="LIST";
			}
	
		
			switch (mode) {
			case "LIST": 
				 showAllItem(req, resp);
				 break;
			case "FORM":
				 showAddForm(req, resp);
				 break;
			case "CREATE":
				 createItem(req, resp);
				 break;
			case "SINGLE":
				 showDetail(req,resp);
				 break;
			case "LOAD":
				 showUpdateForm(req,resp);
				 break;
			case "UPDATE":
				 updateItem(req, resp);
				 break;
			case "DELETE":
				deleteItem(req,resp);
				break;
			}
		
		
	}
	
	private void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Long itemId = Long.parseLong( req.getParameter("itemId"));
		Boolean ok = itemDao.deleteItem(itemId);
		
		if(ok) {
			resp.sendRedirect("item");
		}
		else {
			req.setAttribute("ok", ok);
			showDetail(req, resp);
		}
		
	}

	private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Long itemId = Long.parseLong(req.getParameter("itemId"));
		Item item = itemDao.getIemById(user.getId(), itemId);
		
		if(item != null) {
			req.setAttribute("item", item);
			RequestDispatcher dispatcher = req.getRequestDispatcher("template/item/update-item.jsp");
			dispatcher.forward(	req, resp);
		}
		else {
			req.setAttribute("error", "your requested item is not found in your inventory");
			showErrorPage(req, resp);
		}
		
		
	}

	private void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		Long itemId = Long.parseLong(req.getParameter("itemId"));
		Item item = itemDao.getIemById(user.getId(), itemId);
		
		if(item != null) {
			req.setAttribute("item", item);
			RequestDispatcher dispatcher = req.getRequestDispatcher("template/item/item-detail.jsp");
			dispatcher.forward(	req, resp);
		}
		else {
			req.setAttribute("error", "your requested item is not found in your inventory");
			showErrorPage(req, resp);
		}
		
	
	}
	
	
	private void showErrorPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("template/error/item-error.jsp");
		dispatcher.forward(	req, resp);
	}

	private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("template/item/addItem.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	private void createItem(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
	
		
		String name= req.getParameter("name");
		String category = req.getParameter("category");
		Double price = Double.parseDouble(req.getParameter("price"));
		Integer quantity = Integer.parseInt(req.getParameter("quantity"));
		String image = req.getParameter("image");
		String description = req.getParameter("description");
		Boolean essential = Boolean.parseBoolean(req.getParameter("essential"));
		
		
		Item item = new Item(name,category,price,quantity,essential,image,user.getId(),description);
		Boolean ok = itemDao.createItem(item);
		
		req.setAttribute("ok", ok);
		showAddForm(req, resp);
		
		
	
	}
	
private void updateItem(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		Long itemId= Long.parseLong(req.getParameter("itemId"));
		String name= req.getParameter("name");
		String category = req.getParameter("category");
		Double price = Double.parseDouble(req.getParameter("price"));
		Integer quantity = Integer.parseInt(req.getParameter("quantity"));
		String image = req.getParameter("image");
		String description = req.getParameter("description");
		Boolean essential = Boolean.parseBoolean(req.getParameter("essential"));
		
		
		Item item = new Item(itemId,name,category,price,quantity,essential,image,description);
		Boolean ok = itemDao.updateItem(item);
		
		if(ok) {
			resp.sendRedirect("item?mode=SINGLE&itemId="+itemId);
		}
		else {
			req.setAttribute("ok", ok);
			showUpdateForm(req, resp);
		}
		
		
	
	}
	
	private void showAllItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		List<Item> items = itemDao.getAllItem(user.getId());
		PrintWriter out = resp.getWriter();
		RequestDispatcher dispatcher = req.getRequestDispatcher("template/index.jsp");
		req.setAttribute("items", items);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
