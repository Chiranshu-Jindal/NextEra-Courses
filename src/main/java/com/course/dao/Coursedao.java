package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.course.entities.Course;

public class Coursedao {
	private Connection con;

	public Coursedao(Connection con) {
		this.con = con;
	}

	public boolean saveCourse(Course course) {
		try {
			String query = "INSERT INTO courses (title, description, category, price, creator_id, status) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, course.getTitle());
			pstmt.setString(2, course.getDescription());
			pstmt.setString(3, course.getCategory());
			pstmt.setDouble(4, course.getPrice());
			pstmt.setInt(5, course.getCreatorId());
			pstmt.setString(6, course.getStatus());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Course> getAllPublishedCourses() {
		List<Course> list = new ArrayList<>();
		try {
			String query = "SELECT * FROM courses WHERE status = 'published'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
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
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Course getCourseById(int courseId) {
		Course course = null;
		String query = "SELECT * FROM courses WHERE course_id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, courseId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					course = new Course();
					course.setCourseId(rs.getInt("course_id"));
					course.setTitle(rs.getString("title"));
					course.setDescription(rs.getString("description"));
					course.setCategory(rs.getString("category"));
					course.setPrice(rs.getDouble("price"));
					course.setCreatorId(rs.getInt("creator_id"));
					course.setStatus(rs.getString("status"));
					course.setCreatedAt(rs.getTimestamp("created_at"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
}