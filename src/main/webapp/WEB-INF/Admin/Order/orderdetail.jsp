<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết</title>
</head>
<body>
	<c:set value="${ pageContext.request.contextPath }" var="c" />
	<div class="card">
		<div class="card-header font-weight-bold">Đơn hàng</div>
		<div class="card-body">
			<c:if test="${ fn:length(orderDetails) == 0 }">
				<div class="py-2 text-center">Chưa có đơn hàng nào!</div>
			</c:if>
			<c:if test="${ fn:length(orderDetails) != 0 }">
				<table class="table table-striped text-center">
					<tr>
						<th>Điện thoại</th>
						<th>Giá</th>
						<th>Số lượng</th>
						<th>Thời gian đăng ký</th>

					</tr>
					<c:forEach items="${ orderDetails }" var="item">
						<tr>
							<td>
								<div>
									<img alt="" src="${ c}/resources/${ item.phone.image }"
										style="width: 60px;">
								</div>
								<div>${ item.phone.name }</div>
							</td>
							<td>${ item.quantitystring }</td>
							<td>${ item.amount }</td>
							<td>${ item.createAt }</td>
							
						</tr>
					</c:forEach>
				</table>

			</c:if>
		</div>
	</div>
</body>
</html>