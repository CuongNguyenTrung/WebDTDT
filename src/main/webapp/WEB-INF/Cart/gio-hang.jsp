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
				<c:if test="${ message == null }">
					<c:if test="${ cart == null }">
						<div class="py-4 text-center ">
							<div class="py-2">Không có sản phẩm nào trong giỏ hàng</div>
							<div class="py-2">
								<a href="${ c }/dtdd" class="btn btn-outline-primary">Về trang chủ</a>
							</div>
							<div>
								Nếu cần trợ giúp vui lòng liên hệ <b>0333.333.333</b> hoặc <b>0222.222.222</b>
							</div>
						</div>
					</c:if>
				</c:if>
				<c:if test="${ message != null }">
					<div class="text-center">Bạn đã đặt hàng thành công!</div>
				</c:if>
				<c:if test="${ cart != null }">
					<div class="py-4">
						<c:forEach items="${ cart }" var="orderDetail">
							<c:set var="phone" value="${ orderDetail.value.phone }"></c:set>
							<div class="row mb-3">
								<div class="col-2 offset-1 text-center">
									<img class="mb-2" alt="" src="${ c }/resources/${phone.image}"
										style="width: 70px;">
									<form class="mt-2"
										action="${ c }/gio-hang/delete/${ phone.id }" method="post">
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
									<div style="padding-top: 50px;">
										<ul class="pagination" id="${ phone.id }">
											<c:if test="${ orderDetail.value.amount == 1 }">
												<li class="page-item disabled"><a class="page-link" href="#">-</a></li>
											</c:if>
											<c:if test="${ orderDetail.value.amount > 1 }">
												<li class="page-item"><a class="page-link" href="#">-</a></li>
											</c:if>
											<li class="page-item" class="quantity"><a
												class="page-link  disabled" href="#">${ orderDetail.value.amount }</a></li>
											<li class="page-item"><a class="page-link" href="#">+</a></li>
										</ul>
									</div>
								</div>
							</div>
							<hr>
						</c:forEach>
						<div class="text-left">
							<div class="row">
								<div class="col-2 offset-1 text-center">Tổng tiền:</div>
								<div class="col-3 offset-6 text-left" id="tongtien">
									<div>
										<c:if test="${ order.saving == null}">
										${ order.quantitystring }
									</c:if>
										<c:if test="${ order.saving != null }">
										${ order.tongtienstring }
									</c:if>

									</div>
								</div>
							</div>
							<c:if test="${ order.saving != 0 }">
								<div class="row">
									<div class="col-2 offset-1 text-center">Giảm:</div>
									<div class="col-3 offset-6 text-left">
										<div id="saving">-${ order.savingstring }</div>
									</div>
								</div>
							</c:if>
							<div class="row">
								<div class="col-2 offset-1 text-center font-weight-bold">Cần
									thanh toán:</div>
								<div class="col-3 offset-6 text-left">
									<div class="font-weight-bold text-danger" id="quantity">${ order.quantitystring }</div>
								</div>
							</div>
						</div>
					</div>
					<hr>
					<div>
						<form action="${ c }/gio-hang/xac-nhan" method="post">
							<div class="row">
								<div class="col-5 offset-1">
									<div class="form-group">
										<input class="form-control" name="username" placeholder="Họ và tên">
									</div>
								</div>
								<div class="col-5">
									<div class="form-group">
										<input class="form-control" name="sdt" placeholder="Số điện thoại">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-10 offset-1">
									<div class="form-group">
										<input class="form-control" name="status" placeholder="Yêu cầu khác ( không bắt buộc )">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-4 offset-4">
									<button type="submit" style="color:white;" class="btn btn-warning btn-block">ĐẶT HÀNG</button>
								</div>
							</div>
						</form>
					</div>
				</c:if>
			</div>
		</div>
		<script>
			function handleMoney(money){
				money += "";
				console.log(money.length);
				let result = "";
				let count = 0;
				for(let i = money.length - 1;i >= 0; i--){
					count += 1;
					result += money[i];
					if(count == 3 && i != 0){
						count = 0;
						result += ".";
					}
				}
				return result.split("").reverse().join("") + "đ";
			}
			$(document).ready(function() {
				$("ul.pagination").click(function(e) {
					if (!$(e.target).hasClass("disabled")) {
						let element = e.target;
						let id = $(this).attr('id');
						let operator = e.target.textContent;
						let list = $(this).children();
						$.ajax({
							url : 'updateCart',
							type : 'post',
							data : {
								id : id,
								operator : operator
							},
							error : function() {
								console.log("error");
							},
							success : function(data) {
								console.log(data);
								if(operator == "+"){
									let quantity = $(list[1]).children();
									$(quantity).text(parseInt($(quantity).text()) + 1);
									$(list[0]).removeClass("disabled");
									console.log(quantity.text());
									console.log(quantity);
								}
								else{
									let quantity = $(list[1]).children();
									$(quantity).text(parseInt($(quantity).text()) - 1);
									if($(quantity).text() == 1){
										$(list[0]).addClass("disabled");
									}
								}
								$("#tongtien").text(handleMoney(data.tongtien));
								$("#saving").text("-" + handleMoney(data.saving));
								$("#quantity").text(handleMoney(data.quantity));
								
							}
						});
					}
				});
			});
		</script>
</body>
</html>