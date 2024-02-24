package com.hostmdy.expense.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.expense.model.Item;
import com.hostmdy.expense.model.ItemDAO;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/item")
public class ItemController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/dbResource")
	private DataSource dataSource;
	
	private ItemDAO itemDao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		itemDao= new ItemDAO(dataSource);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Item> items = itemDao.getAllItem(1L);
		PrintWriter out = resp.getWriter();
		RequestDispatcher dispatcher = req.getRequestDispatcher("template/index.jsp");
		req.setAttribute("items", items);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
