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
	
	private void createPostTag(Post post,Long lastInsertId) throws SQLException {
		pstmt = connection.prepareStatement("INSERT INTO post_tag (post_id,tag_id) VALUES (?,?) ;" );
		List<String> tagIds = post.getTagIds();
		for(final String tag:tagIds) {
			pstmt.setLong(1, lastInsertId);
			pstmt.setLong(2, Long.parseLong(tag));
			pstmt.executeUpdate() ;
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
				
				createPostTag(post, lastInsertId);
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
						 rs.getString("app_link"),
						 rs.getString("min_req")
						
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
						
					pstmt= connection.prepareStatement("DELETE FROM post_tag  WHERE post_id = ? ;");
					pstmt.setLong(1, post.getId());
					
					if(pstmt.executeUpdate() > 0) {
						 	
						createPostTag(post, post.getId());
						
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
	
	public Boolean delete(Long id) {
		Boolean ok = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("DELETE post,post_tag FROM post INNER JOIN  post_tag  ON post.id = post_tag.post_id  WHERE post.id = ?");
			pstmt.setLong(1, id);

			
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
