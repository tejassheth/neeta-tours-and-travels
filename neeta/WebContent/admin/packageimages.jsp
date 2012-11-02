<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.container {
	position: relative;
	width: 100px;
	height: 100px;
	float: left;
	margin-left: 10px;
}

.checkbox {
	position: absolute;
	bottom: 0px;
	right: 0px;
}
</style>
</head>
<body>
	<c:forEach var="img" items="${requestScope.imgList}" varStatus="count">
		<div class="container">
		<c:out value="${img}"></c:out>
			<img src="${path}\<c:out value="${img}"></c:out>" height="100" width="100" /> <input type="checkbox" class="checkbox"
				id="check1" value="${img}" />
		</div>
	</c:forEach>
</body>
</html>