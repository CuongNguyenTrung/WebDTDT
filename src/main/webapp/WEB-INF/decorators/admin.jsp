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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<style>
#header {
	padding: 20px;
	background-color: #563d7c;
	color: #000000;
	font-size: 20px;
	font-family: arial;
}

#header a {
	color: white;
}

a:hover {
	text-decoration: none;
}

img.image{
	width: 70px;
}
</style>
</head>
<body>
	<c:set value="${ pageContext.request.contextPath }" var="c" />
	<c:set value="${ c }/admin" var="admin" />

	<header id="header" class="navbar navbar-expand-lg navbar-dark">
		<a href="#">Trang quản lý</a>
		<div class="navbar-nav">
			<ul class="navbar-nav flex-row ml-4">
				<!--<li class="nav-item"><a href="#">Link 1</a></li>-->
			</ul>
		</div>
	</header>
	<div class="container">
		<div class="row py-4">
			<div class="col-3">
				<div class="card">
					<div class="card-header text-center">Danh mục</div>
					<div class="card-body">
						<ul class="list-group text-center" id="index-list">
							<li class="list-group-item"><a
								href="${ admin }/phonetype/index">Hãng</a></li>
							<li class="list-group-item"><a href="${ admin }/phone/index">Điện thoại</a></li>
							<li class="list-group-item"><a href="${ admin }/order/index">Đơn hàng</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-8 offset-1">
				<div class="main-body">
					<sitemesh:write property='body' />
				</div>
			</div>
		</div>
	</div>
</body>

</html>