package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.course.entities.Course;

public class Cartdao {
	private Connection con;

	// Constructor to initialize the database connection
	public Cartdao(Connection con) {
		this.con = con;
	}

	// Method to add a course to the cart
	public boolean addToCart(int userId, int courseId) {
		try {
			String query = "INSERT INTO cart (user_id, course_id) VALUES (?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, courseId);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method to retrieve all courses in the cart for a user
	public List<Course> getCartCourses(int userId) {
		List<Course> cartCourses = new ArrayList<>();
		try {
			String query = "SELECT c.* FROM courses c JOIN cart ca ON c.course_id = ca.course_id WHERE ca.user_id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getInt("course_id"));
				course.setTitle(rs.getString("title"));
				course.setDescription(rs.getString("description"));
				course.setCategory(rs.getString("category"));
				course.setPrice(rs.getDouble("price"));
				course.setCreatorId(rs.getInt("creator_id"));
				course.setStatus(rs.getString("status"));
				course.setCreatedAt(rs.getTimestamp("created_at"));
				cartCourses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartCourses;
	}

	// Method to remove a course from the cart
	public boolean removeFromCart(int userId, int courseId) {
		try {
			String query = "DELETE FROM cart WHERE user_id = ? AND course_id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, courseId);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
