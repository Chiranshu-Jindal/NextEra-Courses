<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.course.entities.User"%>
<%@page import="com.course.entities.Message"%>
<%@page errorPage="error_page.jsp"%>
<%
// Check if the user is logged in and has the "creator" role
User user = (User) session.getAttribute("currentUser");
if (user == null || !"creator".equals(user.getRole())) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Creator Dashboard - Nexteracourses</title>
<!-- CSS -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.banner-background {
	clip-path: polygon(0% 15%, 0 0, 15% 0%, 85% 0%, 100% 0, 100% 15%, 100% 97%, 84% 95%
		, 59% 100%, 42% 100%, 16% 96%, 0 98%);
}
</style>

<!-- //FAVICON IMAGE -->

<link rel="icon" type="image/png" href="img/title.png">
</head>
<body>
	<!-- Navigation Bar -->
	<!-- <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container">
			<a class="navbar-brand" href="creator_dashboard.jsp">Nexteracourses</a>
			<div class="navbar-nav ms-auto">
				<a class="nav-link" href="create_course.jsp">Create Course</a> <a
					class="nav-link" href="my_courses.jsp">My Courses</a> <a
					class="nav-link" href="earnings.jsp">Earnings</a> <a
					class="nav-link" href="LogoutServlet">Logout</a>
			</div>
		</div>
	</nav>
	-->



	<!-- NAVBAR -->
	<nav class="navbar navbar-expand-lg navbar-dark primary-background">
		<a class="navbar-brand" href="index.jsp"><span> <img
				src="img/logo.png" width="60">
		</span> NextEra Courses</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#"> <span
						class="	fa fa-graduation-cap"></span> Home <span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-expanded="false"> Explore </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Goals</a> <a
							class="dropdown-item" href="#">Subject</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="browse_courses.jsp">Browse
							Courses</a>
					</div></li>

			</ul>
			<div class="navbar-nav ms-auto">
				<a class="nav-link" href="create_course.jsp">Create Course</a> <a
					class="nav-link" href="my_courses.jsp">My Courses</a> <a
					class="nav-link" href="earnings.jsp">Earnings</a>
			</div>
			<ul class="navbar-nav mr-right">

				<li class="nav-item"><a class="nav-link" href="cart.jsp"><span
						class="fa fa-cart-plus"></span>&nbsp; Cart</a></li>

				<li class="nav-item"><a class="nav-link" href="#!"
					data-toggle="modal" data-target="#profile-modal"><span
						class="fa fa-user-circle "></span> &nbsp;<%=user.getUsername()%> </a></li>

				<li class="nav-item"><a class="nav-link" href="LogoutServlet"><span
						class="fa fa-power-off"></span>&nbsp;Logout</a></li>


			</ul>
		</div>
	</nav>
	<!-- END OF NAVBAR -->

	<%
	Message m = (Message) session.getAttribute("msg");
	if (m != null) {
	%>
	<div class="alert <%=m.getCssClass()%>" role="alert">
		<%=m.getContent()%>
	</div>
	<%
	session.removeAttribute("msg");
	}
	%>



	<!-- PROFILE MODEL -->
	<!-- Modal -->
	<div class="modal fade" id="profile-modal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header primary-background text-white">
					<h5 class="modal-title" id="exampleModalLabel">NextEra Courses</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container text-center">
						<img
							src="<%=request.getContextPath()%>/pics/<%=user.getProfile() == null || user.getProfile().isEmpty() ? "default.png" : user.getProfile()%>"
							class="img-fluid" style="border-radius: 50%; max-width: 150px;">

						<br>
						<h5 class="modal-title mt-3" id="exampleModalLable"><%=user.getFullName()%></h5>

						<!--//DETAILS -->
						<div id="profile-details">
							<table class="table table-hover">
								<tbody>
									<tr>
										<th scope="row">ID :</th>
										<td><%=user.getUserId()%></td>
									</tr>
									<tr>
										<th scope="row">Email :</th>
										<td><%=user.getEmail()%></td>

									</tr>
									<tr>
										<th scope="row">Role :</th>
										<td><%=user.getRole()%></td>

									</tr>
									<tr>
										<th scope="row">Registered On :</th>
										<td><%=user.getDatetime().toString()%></td>

									</tr>
								</tbody>
							</table>
						</div>

						<!-- //PROFILE EDIT -->

						<div id="profile-edit" style="display: none;">
							<h3 class="mt-2">PLease Edit Carefully...</h3>
							<form action="EditServlet" method="post"
								enctype="multipart/form-data">
								<table class="table">
									<tr>
										<td>Id :</td>
										<td><%=user.getUserId()%></td>
									</tr>
									<tr>
										<td>Role :</td>
										<td><%=user.getRole().toUpperCase()%></td>
									</tr>
									<tr>
										<td>Email :</td>
										<td><input type="email" class="form-control"
											name="user_email" value="<%=user.getEmail()%>"></td>
									</tr>
									<tr>
										<td>Username :</td>
										<td><input type="text" class="form-control"
											name="user_name" value="<%=user.getUsername()%>"></td>
									</tr>
									<tr>
										<td>FullName :</td>
										<td><input type="text" class="form-control"
											name="user_Fullname" value="<%=user.getFullName()%>"></td>
									</tr>
									<tr>
										<td>Password :</td>
										<td><input type="password" class="form-control"
											name="user_password" value="<%=user.getPassword()%>"></td>
									</tr>
									<tr>
										<td>New Profile Picture :</td>
										<td><input type="file" class="form-control" name="image"
											value="<%=user.getPassword()%>"></td>
									</tr>
								</table>

								<div class="container">
									<button type="submit" class="btn btn-outline-primary">Save</button>
								</div>



							</form>
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="edit-profile-button" type="button"
						class="btn btn-primary">Edit</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 	//END OF PROFILE MODAL -->


	<!-- Main Content -->
	<div class="container mt-5">
		<h2 class="text-center">
			Welcome,
			<%=user.getFullName()%>!
		</h2>
		<p class="text-center">Manage your courses and track your earnings
			from here.</p>

		<div class="row mt-4">
			<!-- Create Course Card -->
			<div class="col-md-4">
				<div class="card text-center shadow-sm">
					<div class="card-body">
						<h5 class="card-title">Create New Course</h5>
						<p class="card-text">Start building a new course to share your
							knowledge.</p>
						<a href="create_course.jsp" class="btn btn-primary">Create
							Course</a>
					</div>
				</div>
			</div>

			<!-- My Courses Card -->
			<div class="col-md-4">
				<div class="card text-center shadow-sm">
					<div class="card-body">
						<h5 class="card-title">My Courses</h5>
						<p class="card-text">View and manage the courses you've
							created.</p>
						<a href="my_courses.jsp" class="btn btn-primary">View Courses</a>
					</div>
				</div>
			</div>

			<!-- Earnings Card -->
			<div class="col-md-4">
				<div class="card text-center shadow-sm">
					<div class="card-body">
						<h5 class="card-title">Earnings</h5>
						<p class="card-text">Check your total earnings from course
							enrollments.</p>
						<a href="earnings.jsp" class="btn btn-primary">View Earnings</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- JAVASCRIPT -->

	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
		integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
		crossorigin="anonymous"></script>
	<script src="js/myjs.js" type="text/javascript"></script>

	<script>
		$(document).ready(function() {
			let editStatus = false;

			$('#edit-profile-button').click(function() {
				/* alert("button clicker") */
				if (editStatus == false) {
					$("#profile-details").hide()
					$("#profile-edit").show()
					editStatus = true;
					$(this).text("Back")
				} else {
					$("#profile-details").show()
					$("#profile-edit").hide()
					editStatus = false;
					$(this).text("Edit")
				}
			});
		});
	</script>
</body>
</html>