package com.hostmdy.expense.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.xdevapi.Statement;

public class ItemDAO {
	
	private Connection connection;
	private java.sql.Statement  stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	private final DataSource dataSource;
	
	public ItemDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	private void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public List<Item> getAllItem(Long userId){
		List<Item> items= new ArrayList<Item>();
		try {
			connection = dataSource.getConnection();
			stmt= connection.createStatement();
			rs=stmt.executeQuery("SELECT * FROM item WHERE user_id='"+userId+"' ");
			
			while(rs.next()) {
				items.add(
						new Item(
					    rs.getLong("id"),
						rs.getString("name"),
						rs.getString("category"),
						rs.getDouble("price"),
						rs.getInt("quantity"),
						rs.getDouble("subtotal"),
						rs.getTimestamp("issued_date").toLocalDateTime(),
						rs.getBoolean("essential"),
						rs.getString("image"),
						rs.getLong("user_id"),
						rs.getString("description")			
					));					
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return items;
		
	}
	
}
