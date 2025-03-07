package com.course.entities;

import java.sql.Timestamp;

public class Earning {
	private int earningId; // Primary key
	private int creatorId; // Foreign key referencing users table (course creator)
	private int courseId; // Foreign key referencing courses table
	private double amount; // Earnings amount with 2 decimal places
	private Timestamp date; // Date and time of earning

	// Default constructor
	public Earning() {
	}

	// Parameterized constructor (excluding auto-generated earningId and date)
	public Earning(int creatorId, int courseId, double amount) {
		this.creatorId = creatorId;
		this.courseId = courseId;
		this.amount = amount;
	}

	// Getters and Setters
	public int getEarningId() {
		return earningId;
	}

	public void setEarningId(int earningId) {
		this.earningId = earningId;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}