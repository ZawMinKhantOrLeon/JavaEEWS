package com.hostmdy.appstore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class TagDAO {
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource dataSource;

	public TagDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	private void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	
	public Boolean createTag(Tag tag){
			Boolean ok = false;
			
			try {
				connection = dataSource.getConnection();
				pstmt = connection.prepareStatement("INSERT INTO tag (name) VALUES (?) ; ");
				pstmt.setString(1, tag.getName());
				
				int rowEff=pstmt.executeUpdate();
				if(rowEff > 0) {
					ok = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				closeConnection(connection);
			}
			
			return ok;
		
	}
	
	public List<Tag> getAllTag(){
		
		 List<Tag> tags= new ArrayList<Tag>();
		 
		 try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs= stmt.executeQuery("SELECT * FROM tag");
			
			while(rs.next()) {
				tags.add(new Tag(
						rs.getLong("id"),
						rs.getString("name"))
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(connection);
		}
		 
		 return tags;
	}
	
	public Tag getTagById(Long id) {
		Tag tag = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tag WHERE id = " + id);
			
			while(rs.next()) {
				tag = new Tag(rs.getLong("id"),rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tag;
	}
	
	public Boolean updateTag(Tag tag) {
		Boolean ok = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("UPDATE tag SET name=? WHERE id= ? ; ");
			pstmt.setString(1, tag.getName());
			pstmt.setLong(2, tag.getId());
			
			int rowEff=pstmt.executeUpdate();
			if(rowEff > 0) {
				ok = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(connection);
		}
		
		return ok;
	}
	
	public Boolean delete(Long id) {
		
		Boolean ok =false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("DELETE FROM tag WHERE id = ? ");
			pstmt.setLong(1,id);
		
			if(pstmt.executeUpdate() > 0) {
				ok = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(connection);
		}
		return ok;
	}
	
}
