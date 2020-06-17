<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo điện thoại</title>
</head>
<body>
	<c:set value="${ pageContext.request.contextPath }" var="c" />
	<c:if test="${ dataPhone.phone == null}">
		<c:set value="save" var="link" />
		<c:set value="Tạo điện thoại" var="cardHeader" />
		<c:set value="Lưu" var="buttonContent" />
	</c:if>
	<c:if test="${ dataPhone.phone != null }">
		<c:set value="update" var="link" />
		<c:set value="Cập nhật điện thoại" var="cardHeader" />
		<c:set value="Cập nhật" var="buttonContent" />
	</c:if>
	<div class="card">
		<div class="card-header">${ cardHeader }</div>
		<div class="card-body">

			<form:form action="${ link }" modelAttribute="dataPhone"
				method="post" enctype="multipart/form-data">
				<c:if test="${ dataPhone.phone.id != 0 }">
					<form:hidden path="phone.id" value="${ dataPhone.phone.id }" />
				</c:if>
				<div class="form-group">
					<label>Tên điện thoại</label>
					<form:input path="phone.name" class="form-control" />
				</div>
				<div class="form-group">
					<label>Giá mới</label>
					<form:input path="phone.newprice" class="form-control" />
				</div>
				<div class="form-group">
					<label>Giá cũ</label>
					<form:input path="phone.oldprice" class="form-control" />
				</div>
				<div class="form-group">
					<label>Ảnh</label> <input type="file" name="image"
						class="form-control">
				</div>
				<c:if test="${ dataPhone.phone != null }">
					<img alt="" src="${ c }/resources/${dataPhone.phone.image}"
						class="image">
				</c:if>
				<div class="form-group">
					<label>Hãng</label>

					<form:select path="phone.type.id" class="form-control">
						<form:options items="${ phoneTypes }" itemLabel="name"
							itemValue="id" />
					</form:select>

				</div>

				<hr>
				<div class="form-group">
					<label>Màn hình</label>
					<form:input path="phoneDetail.screen" class="form-control" />
				</div>
				<div class="form-group">
					<label>Cpu</label>
					<form:input path="phoneDetail.cpu" class="form-control" />
				</div>
				<div class="form-group">
					<label>Ram</label>
					<form:input path="phoneDetail.ram" class="form-control" />
				</div>
				<div class="form-group">
					<label>Bộ nhớ</label>
					<form:input path="phoneDetail.rom" class="form-control" />
				</div>
				<div class="form-group">
					<label>Camera trước</label>
					<form:input path="phoneDetail.bcamera" class="form-control" />
				</div>
				<div class="form-group">
					<label>Camera sau</label>
					<form:input path="phoneDetail.acamera" class="form-control" />
				</div>
				<div class="form-group">
					<label>Pin</label>
					<form:input path="phoneDetail.battery" class="form-control" />
				</div>
				<hr>
				<c:forEach items="${ dataPhone.phoneImages }" var="phoneImage"
					varStatus="index">
					<div class="form-group mb-2">
						<c:choose>
							<c:when test="${ link == 'update' }">
								<label>Ảnh ( Màu ${ colors[index.index].name } )</label>
								<input type="file" name="newPhoneImages[${ phoneImage.key }]"
									class="form-control" multiple="multiple">
								<c:forEach items="${ dataPhone.stringPhoneImages }" var="pi">
									<c:if test="${ pi.key == phoneImage.key && pi.value != null}">
										<c:forEach items="${ pi.value }" var="linkImage">
											<span class="divimg${ linkImage.id }"> <input
												type="checkbox" id="${ linkImage.id }"> <img alt=""
												src="${ c }/resources/${linkImage.image}" class="image">
											</span>
										</c:forEach>
										<button value="${ pi.key }"
											class="deleteImages btn btn-dark btn-xs">Xóa</button>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:if test="${ link == 'save' }">
									<label>Ảnh ( Màu ${ colors[index.index].name } )</label>
									<input type="file" name="phoneImages[${ phoneImage.key }]"
										class="form-control" multiple="multiple">
								</c:if>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">${ buttonContent }</button>
				</div>
			</form:form>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("button.deleteImages").click(function(e) {
				e.preventDefault();
				let array = [];
				let checkboxes = $("input[type = 'checkbox']:checked");

				for (let i = 0; i < checkboxes.length; i++) {
					array.push(checkboxes[i].id);
				}
				console.log(array.join(' '));
				if (array.length == 0)
					return;
				$.ajax({
					url : 'deleteImages',
					type : 'post',
					contentType : 'application/json',
					data : JSON.stringify(array),

					error : function(e) {
						console.log(e);
					},
					success : function(data) {
						for (let i = 0; i < data.length; i++) {

							let span = $("span.divimg" + data[i]).remove();
							let span1 = span.before().tagName;
							console.log(span1);

						}

					}
				});
			});
		});
	</script>
</body>

</html>