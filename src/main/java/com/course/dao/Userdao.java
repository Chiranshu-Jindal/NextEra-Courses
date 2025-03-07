package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.course.entities.User;

public class Userdao {

	private Connection con;

	public Userdao(Connection con) {
		this.con = con;
	}

	// METHOD TO INSERT USER TO DATAB BASE

	public boolean saveUser(User user) {
		boolean f = false;
		try {

			// USER--> DATABASE

			String query = "insert into users(username,password,email,full_name,role) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getFullName());
			pstmt.setString(5, user.getRole());

			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return f;
	}

	// GET USER BY EMAIL AND PASSWORD

	public User getUserByEmailAndPassword(String email, String password) {
		User user = null;

		try {
			String query = "select * from users where email=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				// DATA FROM DB
				String name = rs.getString("full_name");
				// SET TO USER OBJECT
				user.setFullName(name);
				user.setUsername(rs.getString("username"));
				user.setRole(rs.getString("role"));
				user.setEmail(rs.getString("email"));
				user.setUserId(rs.getInt("user_id"));
				user.setPassword(rs.getString("password"));
				user.setDatetime(rs.getTimestamp("created_at"));
				user.setProfile(rs.getString("profile"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean updateUser(User user) {

		boolean f = false;
		try {
			String query = "UPDATE users set username=?,password=?,email=?,full_name=?, profile=? where user_id=?";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getFullName());
			pstmt.setString(5, user.getProfile());
			pstmt.setInt(6, user.getUserId());
			pstmt.executeUpdate();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
