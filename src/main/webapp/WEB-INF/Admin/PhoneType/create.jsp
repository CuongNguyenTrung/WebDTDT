<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo hãng</title>
</head>
<body>
	<c:set value="${ pageContext.request.contextPath }" var="c" />
	<div class="card">
		<div class="card-header">
			Tạo hãng
		</div>
		<div class="card-body">
			<form:form action="save" modelAttribute="phonetype" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label>Tên hãng</label>
					<form:input path="name" class="form-control"/>
				</div>
				<div class="form-group">
					<label>Ảnh</label>
					<input type="file" name="img" class="form-control">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Tạo hãng</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>