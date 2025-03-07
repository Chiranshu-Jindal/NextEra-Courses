package com.course.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.course.dao.Userdao;
import com.course.entities.Message;
import com.course.entities.User;
import com.course.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    /**
//     * Default constructor. 
//     */
//    public LoginServlet() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("email");
		String userPassword = request.getParameter("password");

		PrintWriter out = response.getWriter();

		try {
			Userdao dao = new Userdao(ConnectionProvider.getConnection());

			User u = dao.getUserByEmailAndPassword(userName, userPassword);
			HttpSession s = request.getSession();
			if (u != null) {
				// ...LOGIN SUCCESS

				s.setAttribute("currentUser", u);
				switch (u.getRole()) {
				case "admin":
					response.sendRedirect("admin_dashboard.jsp");
					break;
				case "creator":
					response.sendRedirect("creator_dashboard.jsp");
					break;
				default:
					response.sendRedirect("user_dashboard.jsp");
				}

			} else {

				// LOGIN ERROR
//				out.println("invalid details ... try again");
				Message msg = new Message("Invalid Details ! try again", "error", "alert-danger");
				response.sendRedirect("login_page.jsp");
				s.setAttribute("msg", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
