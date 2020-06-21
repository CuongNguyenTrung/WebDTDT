<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Điện thoại smartphone</title>
</head>
<body>
	<c:set value="${ pageContext.request.contextPath }" var="c"></c:set>
	<div class="py-4">
		<c:forEach items="${ phonetypes }" var="phonetype">
			<a href="${ c }/dtdd/type/${ phonetype.lowername }" class="phonetype">
				<img alt="" src="${ c }/resources/${ phonetype.image }"
				class="label">
			</a>
		</c:forEach>
	</div>
	<div>
		<a href="${ c }/dtdd">Điện thoại </a> <span style="font-size: 20px;">
			› </span> <a href="${ c }/dtdd/type/${ nametype}">${ nametype }</a>
	</div>
	<hr>
	<div class="py-4">
		<div class="font-weight-bold">Các điện thoại ${ nametype }</div>
		<ul class="list-inline">
			<c:forEach items="${ phone }" var="phone">
				<div class="list-inline-item text-center py-4 ml-3">
					<a href="${ c }/dtdd/${ phone.phonelink }"> <img alt=""
						src="${ c }/resources/${ phone.image }"
						style="width: 180px; height: 180px;">
						<p style="font-size: 18px; color: black;">${ phone.name }</p>
						<div class="price" style="font-size: 15px;">
							<strong class="text-danger">${ phone.newpricestring }</strong> <s
								class="text-dark">${ phone.oldpricestring }</s>
						</div>
					</a>
				</div>
			</c:forEach>
		</ul>
	</div>
</body>
</html>