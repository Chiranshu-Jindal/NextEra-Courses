package com.course.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.course.dao.Userdao;
import com.course.entities.Message;
import com.course.entities.User;
import com.course.helper.ConnectionProvider;
import com.course.helper.Helper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class EditServlet
 */
@MultipartConfig
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
//    public EditServlet() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
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
		PrintWriter out = response.getWriter();

		// FETCH ALL DATA

		String userEmail = request.getParameter("user_email");
		String userName = request.getParameter("user_name");
		String userFullname = request.getParameter("user_Fullname");
		String userPassword = request.getParameter("user_password");
		Part part = request.getPart("image");
		String imageName = part.getSubmittedFileName();

		// GET THE USER FROM THE SESSION

		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentUser");

		user.setEmail(userEmail);
		user.setFullName(userFullname);
		user.setPassword(userPassword);
		user.setUsername(userName);

		String oldFile = user.getProfile();
		user.setProfile(imageName);

		// UPDATE DATABASE

		try {
			Userdao userdao = new Userdao(ConnectionProvider.getConnection());
			boolean ans = userdao.updateUser(user);
			if (ans == true) {

				String path = getServletContext().getRealPath("/") + "pics" + File.separator + user.getProfile();

				// DELETE CODE
				String pathOldFile = getServletContext().getRealPath("/") + "pics" + File.separator + oldFile;
				if (!oldFile.equals("default.png")) {
					Helper.deleteFile(pathOldFile);
				}
				if (Helper.saveFile(part.getInputStream(), path)) {
					out.println("Profile Updated...");
					Message msg = new Message("Profile Details Updated...", "success", "alert-success");
					s.setAttribute("msg", msg);
				} else {
					out.println("file not save successfully");
					Message msg = new Message("Something went wrong..", "error", "alert-danger");
					s.setAttribute("msg", msg);
				}

			} else {
				out.println("not updated");
				Message msg = new Message("Something went wrong..", "error", "alert-danger");
				s.setAttribute("msg", msg);
			}

			response.sendRedirect("profile.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
