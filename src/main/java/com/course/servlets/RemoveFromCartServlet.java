package com.course.servlets;

import java.io.IOException;

import com.course.dao.Cartdao;
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
 * Servlet implementation class EnrollCourseServlet
 */
@MultipartConfig
@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
//	public EnrollCourseServlet() {
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

		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("currentUser");

			if (user == null || !"user".equals(user.getRole())) {
				response.sendRedirect("login.jsp");
				return;
			}

			int userId = user.getUserId();
			int courseId = Integer.parseInt(request.getParameter("courseId"));
			Cartdao cartDAO = new Cartdao(ConnectionProvider.getConnection());

			if (cartDAO.removeFromCart(userId, courseId)) {
				session.setAttribute("message", "Course removed from cart!");
				response.sendRedirect("cart.jsp");
			} else {
				session.setAttribute("error", "Failed to remove course.");
				response.sendRedirect("cart.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
