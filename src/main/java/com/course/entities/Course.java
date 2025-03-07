package com.course.entities;

import java.sql.Timestamp;

public class Course {
	private int courseId, creatorId;
	private String title, description, category, status;
	private double price;
	private Timestamp createdAt;

	public Course() {
	}

	public Course(String title, String description, String category, double price, int creatorId, String status) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.creatorId = creatorId;
		this.status = status;
	}

	// Getters and Setters
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
