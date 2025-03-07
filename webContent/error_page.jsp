<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page isErrorPage="true"%>
<html>
<head>
<meta charset="UTF-8">
<title>Sorry ! something went wrong</title>

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

	<div class="container text-center">

		<img src="img/error.png" class="img-fluid">
		<h3 class="display-3">Sorry ! Something went wrong....</h3>
		<%=exception%>
		<br> <a href="index.jsp"
			class="btn primary-background btn-lg text-white mt-3">Home</a>

	</div>
</body>
</html>