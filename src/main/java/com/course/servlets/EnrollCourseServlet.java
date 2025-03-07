package com.course.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.course.dao.Cartdao;
import com.course.dao.Coursedao;
import com.course.dao.Earningsdao;
import com.course.dao.Enrollmentdao;
import com.course.entities.Course;
import com.course.entities.Earning;
import com.course.entities.Message;
import com.course.entities.User;
import com.course.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@MultipartConfig
@WebServlet("/EnrollCourseServlet")
public class EnrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");

		// Check if user is authenticated and has correct role
		if (user == null || !"user".equals(user.getRole())) {
			response.sendRedirect("login_page.jsp");
			return;
		}

		int userId = user.getUserId();
		int courseId;
		try {
			courseId = Integer.parseInt(request.getParameter("courseId"));
		} catch (NumberFormatException e) {
			session.setAttribute("msg", new Message("Invalid course ID.", "error", "alert-danger"));
			response.sendRedirect("cart.jsp");
			return;
		}

		Connection con = null;
		try {
			// Retrieve connection and start transaction
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);

			// Initialize DAO objects
			Enrollmentdao enrollmentdao = new Enrollmentdao(con);
			Cartdao cartdao = new Cartdao(con);
			Coursedao coursedao = new Coursedao(con);
			Earningsdao earningsDAO = new Earningsdao(con);

			// Check if the user is already enrolled
			if (enrollmentdao.isEnrolled(userId, courseId)) {
				session.setAttribute("msg",
						new Message("You are already enrolled in this course.", "warning", "alert-warning"));
				response.sendRedirect("user_dashboard.jsp");
				con.setAutoCommit(true);
				return;
			}

			// Perform transactional operations
			if (enrollmentdao.enrollCourse(userId, courseId)) {
				cartdao.removeFromCart(userId, courseId);
				Course course = coursedao.getCourseById(courseId);
				if (course == null) {
					throw new SQLException("Course not found.");
				}
				double price = course.getPrice();
				int creatorId = course.getCreatorId();
				Earning earning = new Earning(creatorId, courseId, price);
				earningsDAO.addEarning(earning);

				// Commit transaction
				con.commit();
				session.setAttribute("msg", new Message("Enrolled successfully!", "successs", "alert-success"));
				response.sendRedirect("user_dashboard.jsp");
			} else {
				throw new SQLException("Enrollment failed.");
			}
		} catch (SQLException e) {
			// Handle SQLException (including rollback)
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}
			}
			session.setAttribute("msg", new Message("An error occurred: " + e.getMessage(), "error", "alert-danger"));
			response.sendRedirect("cart.jsp");
		} catch (ClassNotFoundException e) {
			// Handle ClassNotFoundException (e.g., JDBC driver missing)
			session.setAttribute("msg",
					new Message("Database driver not found: " + e.getMessage(), "error", "alert-danger"));
			response.sendRedirect("error_page.jsp");
		} finally {
			// Clean up resources
			if (con != null) {
				try {
					con.setAutoCommit(true); // Restore default behavior
					con.close(); // Close the connection
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}