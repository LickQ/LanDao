<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${hlist}" var="list">
		文稿名:<td> ${list.tname}</td>  <br>
		电话:<td> ${list.latestTime}</td> <br>
		专业:<td> ${list.state}</td> <br>
		<p>
	</c:forEach>
</body>
</html>