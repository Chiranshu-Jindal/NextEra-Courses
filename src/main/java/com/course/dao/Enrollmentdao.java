package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.course.entities.Enrollment;

public class Enrollmentdao {
	private Connection con;

	// Constructor to initialize the database connection
	public Enrollmentdao(Connection con) {
		this.con = con;
	}

	// Method to enroll a user in a course
	public boolean enrollCourse(int userId, int courseId) {
		try {
			String query = "INSERT INTO enrollments (user_id, course_id) VALUES (?, ?)";
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

	// Method to retrieve an enrollment by its ID
	public Enrollment getEnrollmentById(int enrollmentId) {
		Enrollment enrollment = null;
		try {
			String query = "SELECT * FROM enrollments WHERE enrollment_id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, enrollmentId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				enrollment = new Enrollment();
				enrollment.setEnrollmentId(rs.getInt("enrollment_id"));
				enrollment.setUserId(rs.getInt("user_id"));
				enrollment.setCourseId(rs.getInt("course_id"));
				enrollment.setEnrollmentDate(rs.getTimestamp("enrollment_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrollment;
	}

	// Method to retrieve all enrollments for a specific user
	public List<Enrollment> getEnrollmentsByUser(int userId) {
		List<Enrollment> enrollments = new ArrayList<>();
		try {
			String query = "SELECT * FROM enrollments WHERE user_id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Enrollment enrollment = new Enrollment();
				enrollment.setEnrollmentId(rs.getInt("enrollment_id"));
				enrollment.setUserId(rs.getInt("user_id"));
				enrollment.setCourseId(rs.getInt("course_id"));
				enrollment.setEnrollmentDate(rs.getTimestamp("enrollment_date"));
				enrollments.add(enrollment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrollments;
	}

	// Method to retrieve all enrollments for a specific course
	public List<Enrollment> getEnrollmentsByCourse(int courseId) {
		List<Enrollment> enrollments = new ArrayList<>();
		try {
			String query = "SELECT * FROM enrollments WHERE course_id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, courseId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Enrollment enrollment = new Enrollment();
				enrollment.setEnrollmentId(rs.getInt("enrollment_id"));
				enrollment.setUserId(rs.getInt("user_id"));
				enrollment.setCourseId(rs.getInt("course_id"));
				enrollment.setEnrollmentDate(rs.getTimestamp("enrollment_date"));
				enrollments.add(enrollment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrollments;
	}

	// Method to check if a user is already enrolled in a course
	public boolean isEnrolled(int userId, int courseId) {
		try {
			String query = "SELECT COUNT(*) FROM enrollments WHERE user_id = ? AND course_id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, courseId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0; // If count > 0, user is enrolled
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> getEnrolledCourseNames(int userId) {
		List<String> courseNames = new ArrayList<>();
		try {
			// SQL query to fetch course names based on enrollments
			String query = "SELECT c.title FROM enrollments e " + "JOIN courses c ON e.course_id = c.course_id "
					+ "WHERE e.user_id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				courseNames.add(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseNames;
	}
}