<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><sitemesh:write property='title' /></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<style type="text/css">
#header {
	padding: 10px;
	background-color: #fed700;
	color: black;
	font-size: 20px;
	font-family: arial;
}

#header a {
	color: black;
}

.label{
	height: 21px;

}
.phonetype{
	border: 1px solid #eee;
	padding: 9px;
}
.framephone{
	border: 1px solid #eee;
}
</style>
</head>

<body>
	<c:set value="${ pageContext.request.contextPath }" var="c" />
	<header id="header" class="navbar navbar-expand-lg navbar-dark">
		<div class="navbar-nav container">
			<ul class="navbar-nav flex-row ml-4">
				<li class="nav-item"><form class="form-inline">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
					</form></li>
			</ul>
		</div>
	</header>

	<div class="container">
		<sitemesh:write property='body' />
	</div>

</body>
</html>