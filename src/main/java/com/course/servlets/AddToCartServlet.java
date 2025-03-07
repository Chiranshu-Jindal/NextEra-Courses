package com.course.servlets;

import java.io.IOException;

import com.course.dao.Cartdao;
import com.course.dao.Coursedao;
import com.course.entities.User;
import com.course.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet
 */
@MultipartConfig
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
//	public AddToCartServlet() {
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");

		if (user == null || !"user".equals(user.getRole())) {
			session.setAttribute("pendingAction", "addToCart");
			session.setAttribute("courseId", request.getParameter("courseId"));
			response.sendRedirect("login_page.jsp");
			return;
		}

		int userId = user.getUserId();
		int courseId;
		try {
			courseId = Integer.parseInt(request.getParameter("courseId"));
		} catch (NumberFormatException e) {
			session.setAttribute("error", "Invalid course ID.");
			response.sendRedirect("browse_courses.jsp");
			return;
		}

		try {
			// Validate if the course exists
			Coursedao coursedao = new Coursedao(ConnectionProvider.getConnection());
			if (coursedao.getCourseById(courseId) == null) {
				session.setAttribute("error", "Course not found.");
				response.sendRedirect("browse_courses.jsp");
				return;
			}

			// Add to cart
			Cartdao cartDAO = new Cartdao(ConnectionProvider.getConnection());
			if (cartDAO.addToCart(userId, courseId)) {
				session.setAttribute("message", "Course added to cart!");
				response.sendRedirect("cart.jsp"); // Redirect to cart instead of browse_courses
			} else {
				session.setAttribute("error", "Failed to add course to cart.");
				response.sendRedirect("browse_courses.jsp");
			}
		} catch (Exception e) {
			session.setAttribute("error", "An unexpected error occurred: " + e.getMessage());
			response.sendRedirect("error_page.jsp");
			e.printStackTrace();
		}
	}
}
