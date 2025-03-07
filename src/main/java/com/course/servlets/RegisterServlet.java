package com.course.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.course.dao.Userdao;
import com.course.entities.User;
import com.course.helper.ConnectionProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */

@MultipartConfig
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
//    public RegisterServlet() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// FETCH ALL DATA
		PrintWriter out = response.getWriter();
		String check = request.getParameter("check");

		if (check == null) {
			out.println("box is unchecked");

		} else {

			// ALL LEFT DATA

			String name = request.getParameter("user_name");
			String email = request.getParameter("user_email");
			String password = request.getParameter("user_password");
			String fullname = request.getParameter("user_fullname");
			String role = request.getParameter("role");

			// CREATE USER OBJECT AND SET ALL DATA TO OBJECT

			User user = new User(name, password, email, fullname, role);

			// CREATE A USER DAO OBJECT

			try {
				Userdao dao = new Userdao(ConnectionProvider.getConnection());
				if (dao.saveUser(user)) {
					out.println("done");
				} else {
					out.println("error");
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
