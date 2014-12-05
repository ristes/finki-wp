<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<h1>Books in ${category.name }</h1>
	<c:forEach items="${books}" var="book">
		<div>
			<a href="${pageContext.request.contextPath}/books/order/${book.id }">${book.name } (${book.price })</a>
		</div>
	</c:forEach>
	
	<h2>Ordered books - ${totalPrice }</h2>
	<c:forEach items="${shoppingCart}" var="book">
		<div>
			<a href="${pageContext.request.contextPath}/books/removeorder/${book.id }">${book.name } (${book.price }) - ${book.category.name }</a>
		</div>
	</c:forEach>
	<br/>
	<br/>
	<a href="${pageContext.request.contextPath}/books/buy">Buy</a>
</body>
</html>