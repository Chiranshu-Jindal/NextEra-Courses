<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register- NextEra Courses</title>
<!-- css -->

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
	<%@include file="normal_navbar.jsp"%>

	<main class="primary-background p-5 banner-background ">
		<div class="container">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center primary-background text-white">
						<span class="fa fa-3x fa-user-circle"></span><br> Register
						Here
					</div>

					<div class="card-body">
						<form id="reg-form" action="RegisterServlet" method="post">

							<div class="form-group">
								<label for="user_name"> User Name</label> <input
									name="user_name" type="text" class="form-control"
									id="user_name" aria-describedby="emailHelp"
									placeholder="Enter Username">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="user_email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter Email"> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									email with anyone else.</small>
							</div>


							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									name="user_password" type="password" class="form-control"
									id="exampleInputPassword1" placeholder="Enter Password	">
							</div>

							<div class="form-group">
								<label for="full_name"> Full Name</label> <input
									name="user_fullname" type="text" class="form-control"
									id="full_name" aria-describedby="emailHelp"
									placeholder="Enter Name">
							</div>

							<!-- 			<div class="form-group">

								<label for="role">Select Role</label> <br> <input
									type="radio" id="role" name="role" value="user"> User <input
									type="radio" id="role" name="role" value="creator">
								Creator

							</div> -->

							<div class="form-group">
								<label for="role">Select Role</label> <br> <select
									class="form-control" id="role" name="role" required>
									<option value="user">User</option>
									<option value="creator">Course Creator</option>
								</select>
							</div>


							<div class="form-group form-check">
								<input name="check" type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1"> Agree Terms and Conditions</label>
							</div>

							<div class="container text-center" id="loader"
								style="display: none;">

								<span class="fa fa-refresh fa-spin fa-3x"></span>
								<h4>please wait.....</h4>
							</div>
							<div class="container text-center">
								<button id="sumbimt-btn" type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
						<p class="mt-3 text-center">
							Have an account? <a href="login_page.jsp">Login</a>
						</p>
					</div>
					<div class="card-footer"></div>
				</div>
			</div>
		</div>

	</main>




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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js "></script>
	<script>
		$(document).ready(function() {
			console.log("loaded....")

			$('#reg-form').on('submit', function(event) {
				event.preventDefault();

				let form = new FormData(this);
				$("#sumbimt-btn").hide();
				$("#loader").show();

				//SEND REGISTER SERVLET

				$.ajax({
					url : "RegisterServlet",
					type : 'POST',
					data : form,
					success : function(data, textStataus, jqXHR) {
						console.log(data)

						$("#sumbimt-btn").show();
						$("#loader").hide();
						if(data.trim()==='done'){
						swal("Registered Successfully.... We are going to redirect to login page")
						.then((value) => {
						  window.location="login_page.jsp"
						});}else{
							swal(data);
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
						$("#sumbimt-btn").show();
						$("#loader").hide();
						swal("Something Went Wrong...try again later");
					},
					processData : false,
					contentType : false

				});

			});
		});
	</script>
</body>
</html>