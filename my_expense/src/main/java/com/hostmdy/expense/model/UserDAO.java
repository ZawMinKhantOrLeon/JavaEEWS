package com.hostmdy.expense.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.expense.crypto.PasswordEncoder;
import com.hostmdy.expense.crypto.PasswordValidator;

public class UserDAO {
	
	private Connection connection;
	private java.sql.Statement  stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	private final DataSource dataSource;
	
	public UserDAO(DataSource dataSource) {
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
	
	public List<User> getAllUsers(){
		
		List<User> users= new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user WHERE role='user'");
			
			while(rs.next()) {
				users.add(new User(
						rs.getLong("id"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("username"), 
						rs.getString("email"), 
						rs.getString("password"), 
						rs.getString("role"),
						rs.getBoolean("enabled")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return users;
	}
	
	public Boolean enable(Long userId) {
		boolean ok = false;
		try {
			connection= dataSource.getConnection();
			ps= connection.prepareStatement("UPDATE user SET "
					+ "enabled=? WHERE id=?;");
			
			ps.setBoolean(1, true);
			ps.setLong(2, userId);
			
			if(ps.executeUpdate() > 0) {
				ok = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return ok;
	}
	
	public Boolean disable(Long userId) {
		boolean ok = false;
		try {
			connection= dataSource.getConnection();
			ps= connection.prepareStatement("UPDATE user SET "
					+ "enabled=? WHERE id=?;");
			
			ps.setBoolean(1, false);
			ps.setLong(2, userId);
			
			if(ps.executeUpdate() > 0) {
				ok = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return ok;
	}
	
	public User existUser(String username) {
		User user = null;
		try {
			connection=dataSource.getConnection();
			stmt= connection.createStatement();
			rs= stmt.executeQuery("SELECT * FROM user WHERE username='"+username+"' OR email = '"+username+"';");
			
			while(rs.next()) {
				user = new User(rs.getLong("id"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("username"), 
						rs.getString("email"), 
						rs.getString("password"), 
						rs.getString("role"),
						rs.getBoolean("enabled"));
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		return user;
	}
	
	
	public Boolean createUser(User user) {
		
		Boolean ok = false;
		try {
			connection= dataSource.getConnection();
			ps= connection.prepareStatement("INSERT INTO user "
					+ "(firstname,lastname,username,email,password,role,enabled)"
					+ "VALUES(?,?,?,?,?,?,?);");
			
			ps.setString(1,user.getFirstname());
			ps.setString(2,user.getLastname());
			ps.setString(3,user.getUsername());
			ps.setString(4,user.getEmail());
			
			try {
				ps.setString(5,PasswordEncoder.encode(user.getPassword()));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.setString(6,user.getRole());
			ps.setBoolean(7,user.getEnabled());
			
			if(ps.executeUpdate() > 0)  ok = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return ok;
		
		
		
	}
	
	public Boolean authenticate(String username,String password) {
		
		User user = existUser(username);
		
		if(user == null) {
			return false;
		}
		else {
			try {
				
				if(PasswordValidator.validatePassword(password, user.getPassword()) && user.getEnabled()) return true;
				
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return false;
		
	}
}
