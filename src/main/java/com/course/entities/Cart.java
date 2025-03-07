package com.course.entities;

public class Cart {
	private int cartId;
	private int userId;
	private int courseId;

	// Default constructor
	public Cart() {
	}

	// Parameterized constructor (excluding auto-generated cartId)
	public Cart(int userId, int courseId) {
		this.userId = userId;
		this.courseId = courseId;
	}

	// Getters and Setters
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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
}