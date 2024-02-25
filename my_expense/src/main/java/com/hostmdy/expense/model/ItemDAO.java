package com.hostmdy.expense.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
	
	public Item getIemById(Long userId,Long itemId){
		Item item = null;
		try {
			connection = dataSource.getConnection();
			stmt= connection.createStatement();
			rs=stmt.executeQuery("SELECT * FROM item WHERE user_id='"+userId+"' AND id='"+itemId+"' ; ");
			
			while(rs.next()) {
				item=
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
					);					
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return item;
		
	}
	
	public Boolean createItem(Item item) {
		boolean ok =false;
		try {
			connection = dataSource.getConnection();
			ps= connection.prepareStatement("INSERT INTO item"
					+ " (name,category,price,quantity,subtotal,issued_date,essential,image,user_id,description)"
					+ " values(?,?,?,?,?,?,?,?,?,?);");
			
			ps.setString(1,item.getName());
			ps.setString(2,item.getCategory());
			ps.setDouble(3,item.getPrice());
			ps.setInt(4,item.getQuantity());
			ps.setDouble(5,item.getSubTotal());
			ps.setTimestamp(6, Timestamp.valueOf(item.getIssuedDate()));
			ps.setBoolean(7, item.getEssential());
			ps.setString(8,item.getImage());
			ps.setLong(9, item.getUserId());
			ps.setString(10, item.getDescription());
			
			int rowEffected = ps.executeUpdate();
			
			if(rowEffected > 0) ok =true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return ok;
	}
	
	public Boolean updateItem(Item item) {
		boolean ok =false;
		try {
			connection = dataSource.getConnection();
			ps= connection.prepareStatement("UPDATE item set "
					+ "name=?,"
					+ "category=?,"
					+ "price=?,"
					+ "quantity=?,"
					+ "subtotal=?,"
					+ "essential=?,"
					+ "image=?,"
					+ "description=? WHERE id=? ;");
			
			ps.setString(1,item.getName());
			ps.setString(2,item.getCategory());
			ps.setDouble(3,item.getPrice());
			ps.setInt(4,item.getQuantity());
			ps.setDouble(5,item.getSubTotal());
			ps.setBoolean(6, item.getEssential());
			ps.setString(7,item.getImage());
			ps.setString(8, item.getDescription());
			ps.setLong(9, item.getId());;
			
			int rowEffected = ps.executeUpdate();
			
			if(rowEffected > 0) ok =true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return ok;
	}
	

	public Boolean deleteItem(Long itemId) {
		boolean ok =false;
		try {
			connection = dataSource.getConnection();
			ps= connection.prepareStatement("DELETE FROM item WHERE id = ? ;");
			ps.setLong(1,itemId);
			
			int rowEffected = ps.executeUpdate();
			
			if(rowEffected > 0) ok =true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return ok;
	}
	
}
