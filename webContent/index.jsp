<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<title>NextEra Courses</title>

<!-- CSS -->

<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
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

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f5f5f5;
}

.container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	gap: 20px;
	padding: 20px;
}

.card {
	background: white;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	width: 300px;
	overflow: hidden;
	text-align: center;
	padding: 20px;
	transition: transform 0.3s ease-in-out; /* Smooth transition */
}

.card img {
	width: 100%;
	border-radius: 8px;
}

.card h3 {
	margin: 15px 0 10px;
	font-size: 20px;
	color: #333;
}

.card p {
	font-size: 14px;
	color: #666;
	padding: 0 10px;
}

.salary {
	font-weight: bold;
	color: #000;
	margin: 10px 0;
}

.credentials {
	margin-top: 10px;
}

.credentials a {
	display: block;
	color: #0073e6;
	text-decoration: none;
	font-size: 14px;
	font-size: 14px;
	margin: 5px 0;
	margin: 5px 0;
}

.credentials a:hover {
	text-decoration: underline;
}

.card:hover {
	transform: translateY(-10px); /* Moves card 10px upwards */
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
	/* Enhances shadow for effect */
}
</style>

</head>
<body>


	<!-- NAVBAR -->

	<%@ include file="normal_navbar.jsp"%>

	<!-- 	//BANNER -->

	<div class="container-fluid p-0 m-0">
		<div
			class="jumbotron primary-background text-white banner-background ">
			<div class="container">
				<h3 class="display-3">World Of NextEra Courses</h3>
				<p>"Unlock Your Potential with NextEra Courses - Where
					Innovation Meets Education." "Explore Expert-Led Courses Designed
					to Propel Your Career Forward with NextEra."</p>
				<p>"At NextEra Courses, we offer a wide range of cutting-edge
					programs tailored to meet the needs of today's dynamic job market.
					Our expert instructors provide hands-on learning experiences to
					ensure you gain practical skills that matter. Whether you're
					looking to advance in your career or start a new path, NextEra is
					here to help you succeed."</p>
				<button class="btn btn-outline-light btn-lg">
					<span class="fa fa-user-plus"></span> Start ! its Free
				</button>
				<a href="login_page.jsp" class="btn btn-outline-light btn-lg"> <span
					class="fa fa-user-circle fa-spin"></span> Login
				</a>
			</div>
		</div>

	</div>

	<!-- Start of Partner LOGO Section -->

	<section class="partner-logos-container">
		<h2>
			We collaborate with <span class="focus-point">350+ leading
				universities and companies</span>
		</h2>
		<div class="styled mb-3 ">
			<h5>Our partners include industry leaders and top-tier
				educational institutions.</h5>
		</div>
		<div class="partner-logo-grid">
			<!-- LOGO -->

			<div class="partner-logo">
				<img
					src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/wp1lcwdav1p1/77hmeEJo3ZPlURCU02fD52/aa37b7f7b52285ba350acac62d8af5c1/illinois-3.png?auto=format%2Ccompress&amp;dpr=1&amp;h=32"
					alt="University of Illinois at Urbana-Champaign">
			</div>
			<div class="partner-logo">
				<img
					src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/wp1lcwdav1p1/6XkOucZz6pMLV5DPvXCgCL/1777129a58b0a62b237bd28e9956afe8/duke-3.png?auto=format%2Ccompress&amp;dpr=1&amp;h=32"
					alt="Duke University">
			</div>
			<div class="partner-logo">
				<img
					src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/wp1lcwdav1p1/1c6RjBHi3Lqb9QpWxje7iA/b529f909c5230af3210ba2d47d149620/google.png?auto=format%2Ccompress&amp;dpr=1&amp;h=37"
					alt="Google">
			</div>
			<div class="partner-logo">
				<img
					src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/wp1lcwdav1p1/60SA8pGxPXMmJf4n7umK1H/ccec31bbe2358210bf8391dcba6cd2f1/umich.png?auto=format%2Ccompress&amp;dpr=1&amp;h=55"
					alt="University of Michigan">
			</div>
			<div class="partner-logo">
				<img
					src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/wp1lcwdav1p1/3toC4I7jbWxiedfxiyNjtT/735faeaf976a9692f425f8c3a7d125dc/1000px-IBM_logo.svg.png?auto=format%2Ccompress&amp;dpr=1&amp;h=37"
					alt="IBM">
			</div>
			<div class="partner-logo">
				<img
					src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/wp1lcwdav1p1/FHOd44z40jTFsSSao84AM/d1e357f5650a23bf2936114112d44445/imperial.png?auto=format%2Ccompress&amp;dpr=1&amp;h=35"
					alt="Imperial College London">
			</div>
			<div class="partner-logo">
				<img
					src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/wp1lcwdav1p1/4FSFmNXuDIzTvFb7n0v4mK/704ae9e0a7981fb6415f4cb4609bbbb3/stanford.svg?auto=format%2Ccompress&amp;dpr=1&amp;h=27"
					alt="Stanford University">
			</div>
			<div class="partner-logo">
				<img
					src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/wp1lcwdav1p1/1ZeiauXe5bPProvfuIo7o2/55d005d42979ab585cdfa01f825b7d4f/penn.svg?auto=format%2Ccompress&amp;dpr=1&amp;h=37"
					alt="University of Pennsylvania">
			</div>
		</div>
	</section>
	<!-- End of Partner LOGO Section -->


	<!-- 	//CARDS -->

	<div class="container">
		<div class="row mb-3">
			<!-- <div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Data Analyst</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add to Cart</a>
					</div>
				</div>

			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Data Analyst</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add to Cart</a>
					</div>
				</div>

			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Data Analyst</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add to Cart</a>
					</div>
				</div>

			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Data Analyst</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add to Cart</a>
					</div>
				</div>

			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Data Analyst</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add to Cart</a>
					</div>
				</div>

			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Data Analyst</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Add to Cart</a>
					</div>
				</div>

			</div> -->

			<div class="container">
				<div class="card">
					<img
						src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/00atxywtfxvd/53ZfSUwuieXnQwpswq4NdP/205c4ea6ffa8db11af48713d4c7af803/Cloud_Architect-role-card_2x.png"
						alt="Cloud Architect">
					<h3>Cloud Architect</h3>
					<p>Designs and manages cloud solutions for security,
						scalability, and efficiency.</p>
					<p class="salary">
						₹1,132,785 median salary<br>17,704 jobs available
					</p>
					<div class="credentials">
						<a href="#">Google Cloud Certification: Cloud Architect</a> <a
							href="#">AWS Cloud Solutions Architect</a>
					</div>
					<div class="card-body">
						<form action="AddToCartServlet" method="post">
							<input type="hidden" name="courseId" value="1">
							<!-- Unique course ID -->
							<button type="submit" class="btn btn-primary text-white">Add
								to Cart</button>
						</form>
					</div>
				</div>
				<div class="card">
					<img
						src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/00atxywtfxvd/3yY4R4RM1IvLYjGmB5v4u/15768d386615e3354eb826af1a0b91e8/Bookkeeper-hero_2x.png?auto=format%2Ccompress&amp;dpr=1&amp;w=720"
						alt="Bookkeeper">
					<h3>Bookkeeper / Accounting Clerk</h3>
					<p>Maintains ledgers and prepares reports, ensuring accuracy
						and compliance.</p>
					<p class="salary">
						₹271,079 median salary<br>30,232 jobs available
					</p>
					<div class="credentials">
						<a href="#">Intuit Academy Bookkeeping</a>
					</div>
					<div class="card-body">
						<form action="AddToCartServlet" method="post">
							<input type="hidden" name="courseId" value="2">
							<!-- Unique course ID -->
							<button type="submit" class="btn btn-primary text-white">Add
								to Cart</button>
						</form>
					</div>
				</div>
				<div class="card">
					<img
						src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/00atxywtfxvd/746wPZVPFy0WuCqPSXVTFe/12cacbc7ec2720a5a85721b49ee5ed5c/Automation_Engineer-hero_2x.png?auto=format%2Ccompress&amp;dpr=1&amp;w=720"
						alt="Automation Engineer">
					<h3>Automation Engineer</h3>
					<p>Enhances efficiency through automated solutions and CI/CD
						pipelines.</p>
					<p class="salary">
						₹320,001 median salary<br>12,882 jobs available
					</p>
					<div class="credentials">
						<a href="#">Google IT Automation with Python</a>
					</div>
					<div class="card-body">
						<form action="AddToCartServlet" method="post">
							<input type="hidden" name="courseId" value="3">
							<!-- Unique course ID -->
							<button type="submit" class="btn btn-primary text-white">Add
								to Cart</button>
						</form>
					</div>
				</div>
				<div class="card">
					<img
						src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/00atxywtfxvd/NhG8x3SAF6xspnzM3Lclu/0614c16eff53f690f2f167590f2035fa/IT_Project_Manager-hero_2x.png?auto=format%2Ccompress&amp;dpr=1&amp;w=720"
						alt="IT Project Manager">
					<h3>IT Project Manager</h3>
					<p>Plans and delivers IT projects on time and within budget.</p>
					<p class="salary">
						₹233,340 median salary<br>50,087 jobs available
					</p>
					<div class="credentials">
						<a href="#">IBM IT Project Manager</a> <a href="#">Generative
							AI for Project Managers</a>
					</div>
					<div class="card-body">
						<form action="AddToCartServlet" method="post">
							<input type="hidden" name="courseId" value="4">
							<!-- Unique course ID -->
							<button type="submit" class="btn btn-primary text-white">Add
								to Cart</button>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>

	<%-- 	<%
	Connection con = ConnectionProvider.getConnection();
	%>
	<h1><%=con%></h1> --%>




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
	<!-- <script>
		$(document).ready(function(){
			alert("document loaded")
		})</script> -->
</body>
</html>