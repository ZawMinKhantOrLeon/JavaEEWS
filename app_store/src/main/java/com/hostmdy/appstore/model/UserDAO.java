package com.hostmdy.appstore.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.hostmdy.appstore.crypto.PasswordEncoder;
import com.hostmdy.appstore.crypto.PasswordValidator;

import jakarta.annotation.Resource;



public class UserDAO {
	
	private Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	@Resource(name="jdbc/dbResource")
	private DataSource dataSource;
	
	public UserDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public void closeConnection( )  {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Boolean register(User user)  {
		
		Boolean ok = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("INSERT INTO user (name,email,password,role,active) VALUES (?,?,?,?,?);");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			try {
				pstmt.setString(3, PasswordEncoder.encode(user.getPassword()));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt.setString(4,"admin");
			pstmt.setBoolean(5, true);
			
			if(pstmt.executeUpdate() > 0) {
				ok = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return ok;
	}
	
	public User existUser(String username) {
		User user = null;
		try {
			connection=dataSource.getConnection();
			stmt= connection.createStatement();
			rs= stmt.executeQuery("SELECT * FROM user WHERE name='"+username+"' OR email = '"+username+"';");
			
			while(rs.next()) {
				user = new User(rs.getLong("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("password"), 
						rs.getString("role"),
						rs.getBoolean("active"));
						
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		return user;
	}
	
	public Boolean authenticate(String username, String password) {
		User user = existUser(username);
		
		if(user == null) {
			return false;
		}
		else {
			try {
				
				if(PasswordValidator.validatePassword(password, user.getPassword()) && user.getActive()) return true;
				
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return false;
	}
	
	
	
	
}
