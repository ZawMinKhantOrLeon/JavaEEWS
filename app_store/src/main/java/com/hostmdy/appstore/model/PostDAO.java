package com.hostmdy.appstore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;


public class PostDAO  {

	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource dataSource;

	
	public PostDAO(DataSource dataSource) {
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
	
	public Boolean createPost(Post post) {
			
		Boolean ok = false;
		Long lastInsertId = null;
		try {
			connection = dataSource.getConnection();
			pstmt= connection.prepareStatement("INSERT INTO post (image,title,description,release_date,min_req) VALUES (?,?,?,?,?);",stmt.RETURN_GENERATED_KEYS);
			
			
			
			pstmt.setString(1, post.getImage());
			pstmt.setString(2, post.getTitle());
			pstmt.setString(3, post.getDescription());
			pstmt.setString(4, post.getRelease_date());
			pstmt.setString(5, post.getMin_req());
			
			int rowEff= pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			while(rs.next()) {
				 lastInsertId = rs.getLong(1);
				System.out.println(lastInsertId);
			}
			
			if(rowEff > 0) {
				pstmt = connection.prepareStatement("INSERT INTO post_tag (post_id,tag_id) VALUES (?,?) ;" );
				List<String> tagIds = post.getTagIds();
				for(final String tag:tagIds) {
					pstmt.setLong(1, lastInsertId);
					pstmt.setLong(2, Long.parseLong(tag));
					pstmt.executeUpdate() ;
				}
				
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
		
	List<Tag> tags = new LinkedList<Tag>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tag");
			
			while(rs.next()) {
				tags.add(new Tag(
						
						rs.getLong("id"),
						rs.getString("name")
						));
				
				
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
	
	public List<Post> getAllPost() {
		
		List<Post> posts = new LinkedList<Post>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM post");
			
			while(rs.next()) {
				posts.add(new Post(
						
						rs.getLong("id"),
						rs.getLong("user_id"),
						rs.getString("image"),
						rs.getString("title"),
						rs.getString("description"),
						rs.getString("release_date"),
						rs.getString("min_req"),
						rs.getTimestamp("created_at").toLocalDateTime(),
						rs.getTimestamp("updated_at").toLocalDateTime()
						
						));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(connection);
		}
		
		return posts;
	}
	
	public Post getPostById(Long Id) {
		Post post = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM POST WHERE id = " + Id);
			
			while(rs.next()) {
				  post = new Post(
						 rs.getLong("id"),
						 1L,
						 rs.getString("image"),
						 rs.getString("title"),
						 rs.getString("description"),
						 rs.getString("release_date"),
						 rs.getString("min_req"),
						 rs.getString("app_link")
						 );		 
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(connection);
		}
		return post;
		}
	
	
	public Boolean update(Post post) {
	    	
	        Boolean ok = false;
			
			try {
				connection = dataSource.getConnection();
				pstmt = connection.prepareStatement("UPDATE post SET title=?,description=?,image=?,app_link=?,release_date=?,min_req=? WHERE id= ? ; ");
				pstmt.setString(1, post.getTitle());
				pstmt.setString(2, post.getDescription());
				pstmt.setString(3, post.getImage());
				pstmt.setString(4, post.getApp_link());
				pstmt.setString(5, post.getRelease_date());
				pstmt.setString(6, post.getMin_req());
				pstmt.setLong(7, post.getId());
				
				int rowEff=pstmt.executeUpdate();
				if(rowEff > 0) {
						
					pstmt= connection.prepareStatement("UPDATE post_tag SET tag_id=? WHERE post_id = ? ;");
					List<String> tagIds = post.getTagIds();
					for(final String tag:tagIds) {
						
						pstmt.setLong(1, Long.parseLong(tag));
						pstmt.setLong(2, post.getId());
						pstmt.executeUpdate() ;
					}
					ok =true;
					
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
