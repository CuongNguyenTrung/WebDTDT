<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật hãng</title>
</head>
<body>
	<c:set value="${ pageContext.request.contextPath }" var="c" />
	<div class="card">
		<div class="card-header">
			Cập nhật hãng
		</div>
		<div class="card-body">
			<form:form action="update" modelAttribute="phonetype" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<form:hidden path="id"/>
					<form:hidden path="image"/>
				</div>
				<div class="form-group">
					<label>Tên hãng</label>
					<form:input path="name" class="form-control"/>
				</div>
				<div class="form-group">
					<label>Ảnh</label>
					<input type="file" name="img" class="form-control">
					<img alt="" src="${ c }/resources/${ phonetype.image }">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Cập nhật hãng</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>