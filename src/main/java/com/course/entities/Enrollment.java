package com.course.entities;

import java.sql.Timestamp;

public class Enrollment {
	private int enrollmentId; // Primary key
	private int userId; // Foreign key referencing users table
	private int courseId; // Foreign key referencing courses table
	private Timestamp enrollmentDate; // Date and time of enrollment

	// Default constructor
	public Enrollment() {
	}

	// Parameterized constructor (excluding auto-generated enrollmentId and
	// enrollmentDate)
	public Enrollment(int userId, int courseId) {
		this.userId = userId;
		this.courseId = courseId;
	}

	// Getters and Setters
	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Timestamp getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Timestamp enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
}
