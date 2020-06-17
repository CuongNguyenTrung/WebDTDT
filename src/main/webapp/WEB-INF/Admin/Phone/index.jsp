<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Điện thoại</title>

</head>
<body>
	<c:set value="${ pageContext.request.contextPath }" var="c" />
	<div class="mb-3 d-flex">
		<div class="mr-auto">
			<a href="create" class="btn btn-primary">Tạo Điện thoại</a>
		</div>

		<c:if test="${ message != null }">
			<div class="alert alert-success">${ message }</div>
		</c:if>

	</div>
	<div class="card">
		<div class="card-header font-weight-bold">Điện thoại</div>
		<div class="card-body">
			<c:if test="${ fn:length(list) == 0 }">
				<div class="py-2 text-center">Chưa có điện thoại nào nào!</div>
			</c:if>
			<c:if test="${ fn:length(list) != 0 }">
				<table class="table table-striped text-center">
					<tr>
						<th>Tên điện thoại</th>
						<th>Ảnh</th>
						<th>Hãng</th>
						<th>Giá</th>
						<th>Sửa</th>
						<th>Xóa</th>
					</tr>
					<c:forEach items="${ list }" var="item">
						<tr>
							<td>${ item.name }</td>
							<td><img alt="" src="${ c }/resources/${ item.image }" class="image"></td>
							<th>${ item.newpricestring }</th>
							<td>${ item.type.name }</td>
							<td>
								<a href="${ item.id }" class="btn btn-warning" style="color:white;">Sửa</a>
							</td>
							<td><button onclick="handleDelete(`${ item.id }`)"
									class="btn btn-dark">Xóa</button></td>
						</tr>
					</c:forEach>
				</table>

			</c:if>
		</div>
	</div>


	<div class="modal" id="checkDelete" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Xóa điện thoại</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Bạn muốn xóa điện thoại này không?</p>
				</div>
				<div class="modal-footer">
					<form id="form-delete" method="post">
						<button type="submit" class="btn btn-primary">Có</button>
					</form>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Không</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		function handleDelete(id) {
			let formDelete = document.getElementById('form-delete');
			formDelete.action = id;
			$("#checkDelete").modal("show");
		}
	</script>
</body>

</html>