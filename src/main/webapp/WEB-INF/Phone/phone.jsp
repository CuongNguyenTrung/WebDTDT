<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ phone.name } chínhhãng</title>
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
</head>
<body>
	<c:set value="${ pageContext.request.contextPath }" var="c" />
	<c:set value="${ phone.phoneDetail }" var="phoneDetail"></c:set>
	<div class="py-4">
		<div>
			<a href="${ c }/dtdd">Điện thoại </a> <span style="font-size: 20px;">
				› </span> <a href="${ c }/#">${ phone.type.name }</a>
		</div>
		<div>
			<h3>${ phone.name }</h3>
			<hr>
		</div>
		<div class="row">
			<div class="col-4 text-center">
				<img alt="" src="${ c }/resources/${ phone.image }">
				<div style="color: #666;">Xem hình thực tế sản phẩm</div>

				<ul class="list-inline mt-2">
					<c:forEach items="${ phoneImages }" var="phoneImage">
						<div class="list-inline-item">
							<div class="flex-column">
								<a href="#" class="show" id="${ phoneImage.value[0].color.id}">
									<img alt=""
									src="${ c }/resources/${phoneImage.value[0].image }"
									style="width: 70px; height: 40px;">
								</a>

								<div>
									<span>${ phoneImage.key }</span>
								</div>
							</div>
						</div>
						<div class="modal" id="modal${ phoneImage.value[0].color.id }"
							tabindex="-1" role="dialog">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header ">
										<h5 class="modal-title text-center">Ảnh ${ phone.name } (
											Màu ${ phoneImage.key } )</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<c:forEach items="${ phoneImage.value }" var="item">
											<img alt="" class="py-3" src="${ c }/resources/${item.image}"
												style="width: 180px; height: 125px;">
										</c:forEach>
									</div>

								</div>
							</div>
						</div>
					</c:forEach>
				</ul>

			</div>
			<div class="col-4 offset-1">
				<div>
					<span class="text-danger font-weight-bold" style="font-size: 24px;">${ phone.newpricestring }</span>
					<s style="font-size: 20px; color: #999;">${ phone.oldpricestring }</s>
					
				</div>
				<div>
					<table>
						<tr>
							<td class="pr-4">Màn hình:</td>
							<td>${ phoneDetail.screen }</td>
						</tr>
						<tr>
							<td class="pr-4">Camera sau:</td>
							<td>${ phoneDetail.acamera }</td>
						</tr>
						<tr>
							<td class="pr-4">Camera trước:</td>
							<td>${ phoneDetail.bcamera }</td>
						</tr>
						<tr>
							<td class="pr-4">CPU:</td>
							<td>${ phoneDetail.cpu }</td>
						</tr>
						<tr>
							<td class="pr-4">RAM:</td>
							<td>${ phoneDetail.ram }</td>
						</tr>
						<tr>
							<td class="pr-4">Bộ nhớ trong:</td>
							<td>${ phoneDetail.rom }</td>
						</tr>
						<tr>
							<td class="pr-4">Dung lượng pin:</td>
							<td>${ phoneDetail.battery }</td>
						</tr>
						<tr class="text-center">
							<td colspan="2"><a class="btn btn-primary btn-sm btn-block" style="color:white">Xem thêm thông số</a></td>
						</tr>
					</table>				
				</div>
				<div class="mt-4 text-center">
					<form action="${ c }/gio-hang" method="post">
						<input type="hidden" value="${ phone.id }" name="item">
						<button type="submit" class="btn btn-lg btn-warning btn-block" style="color:white">Mua ngay</button>
					</form>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$(document).ready(function() {
			$("a.show").click(function(e) {
				e.preventDefault();
				console.log(e.target);
				console.log(this.id);
				$("#modal" + this.id).modal('show');
			});
		});
	</script>
</body>
</html>