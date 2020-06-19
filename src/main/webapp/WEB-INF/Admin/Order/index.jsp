<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn hàng</title>
</head>
<body>
	<div class="card">
		<div class="card-header font-weight-bold">Đơn hàng</div>
		<div class="card-body">
			<c:if test="${ fn:length(orders) == 0 }">
				<div class="py-2 text-center">Chưa có đơn hàng nào!</div>
			</c:if>
			<c:if test="${ fn:length(orders) != 0 }">
				<table class="table table-striped text-center">
					<tr>
						<th>Tên người dùng</th>
						<th>Số điện thoại</th>
						<th>Yêu cầu</th>
						<th>Giá</th>
						<th>Tiết kiệm</th>
						<th>Thời gian tạo</th>
						<th>Chi tiết</th>
					</tr>
					<c:forEach items="${ orders }" var="item">
						<tr>
							<td>${ item.username }</td>
							<td>${ item.sdt }</td>
							<th>${ item.status }</th>
							<td>${ item.quantitystring }</td>
							<td>${ item.savingstring }</td>
							<td>${ item.createAt }</td>
							<td><a class="btn btn-info" style="color:white;">Chi tiết</a></td>
						</tr>
					</c:forEach>
				</table>

			</c:if>
		</div>
	</div>
</body>
</html>