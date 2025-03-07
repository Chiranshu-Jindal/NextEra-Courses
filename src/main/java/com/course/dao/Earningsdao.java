package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.course.entities.Earning;

public class Earningsdao {
	private Connection con;

	// Constructor to initialize the database connection
	public Earningsdao(Connection con) {
		this.con = con;
	}

	// Method to add a new earning entry
	public boolean addEarning(Earning earning) {
		try {
			String query = "INSERT INTO earnings (creator_id, course_id, amount) VALUES (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, earning.getCreatorId());
			pstmt.setInt(2, earning.getCourseId());
			pstmt.setDouble(3, earning.getAmount());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method to get total earnings for a creator
	public double getTotalEarnings(int creatorId) {
		double total = 0.0;
		try {
			String query = "SELECT SUM(amount) FROM earnings WHERE creator_id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, creatorId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				total = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	// Method to get all earnings for a creator (optional)
	public List<Earning> getEarningsByCreator(int creatorId) {
		List<Earning> earnings = new ArrayList<>();
		try {
			String query = "SELECT * FROM earnings WHERE creator_id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, creatorId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Earning earning = new Earning();
				earning.setEarningId(rs.getInt("earning_id"));
				earning.setCreatorId(rs.getInt("creator_id"));
				earning.setCourseId(rs.getInt("course_id"));
				earning.setAmount(rs.getDouble("amount"));
				earning.setDate(rs.getTimestamp("date"));
				earnings.add(earning);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return earnings;
	}
}