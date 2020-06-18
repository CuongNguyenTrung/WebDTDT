<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
<style type="text/css">
body {
	background-color: #f0f0f0;
}
</style>
</head>
<body>
	<c:set value="${ pageContext.request.contextPath }" var="c" />
	<div class="row mt-4">
		<div class="col-8 offset-2">
			<div class="d-flex">
				<div class="mr-auto">
					<a href="dtdd">Mua thêm sản phẩm khác</a>
				</div>
				<div style="color: #999;">Giỏ hàng của bạn</div>
			</div>

			<div class="mt-4 py-4"
				style="border: 1px solid #eee; border-radius: 10px;">
				<c:if test="${ cart == null }">
					<div class="py-4 text-center ">
						<div class="py-2">Không có sản phẩm nào trong giỏ hàng</div>
						<div class="py-2">
							<a href="dtdd" class="btn btn-outline-primary">Về trang chủ</a>
						</div>
						<div>
							Nếu cần trợ giúp vui lòng liên hệ <b>0333.333.333</b> hoặc <b>0222.222.222</b>
						</div>
					</div>
				</c:if>
				<c:if test="${ cart != null }">
					<div class="py-4">
						<c:forEach items="${ cart }" var="orderDetail">
							<c:set var="phone" value="${ orderDetail.value.phone }"></c:set>
							<div class="row">
								<div class="col-2 offset-1 text-center">
									<img class="mb-2" alt="" src="${ c }/resources/${phone.image}"
										style="width: 70px;">
									<form class="mt-2" action="${ c }/gio-hang/delete/${ id }"
										method="post">
										<button type="submit"
											class=" text-center btn btn-sm btn-outline-dark">Xoá</button>
									</form>
								</div>
								<div class="col-6">
									<div>
										<a href="${ c }/dtdd/${ phone.phonelink}"
											class="font-weight-bold" style="color: black;">${ phone.name }</a>
									</div>
									<div>
										<c:if test="${ phone.saving != null}">
											Giảm <span class="text-danger">${ phone.saving }</span>
											 còn <span class="text-danger">${ phone.newpricestring }</span>
										</c:if>
									</div>
								</div>
								<div class="col-3 text-left">
									<div class="text-danger">
										<c:if test="${ phone.oldprice != null }">
											${ phone.oldpricestring }										
										</c:if>
										<c:if test="${ phone.oldprice == null }">
											${ phone.newpricestring }
										</c:if>
									</div>
									<div style="padding-top:50px;">
										<ul class="pagination">
											<li class="page-item"><a class="page-link" href="#">-</a></li>
											<li class="page-item"><a class="page-link" href="#">${ orderDetail.value.amount }</a></li>
											<li class="page-item"><a class="page-link" href="#">+</a></li>
										</ul>
									</div>
								</div>
							</div>
							<hr>
						</c:forEach>
					</div>
				</c:if>
			</div>
		</div>
</body>
</html>