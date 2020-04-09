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
<c:forEach items="${elist}" var="list">
		专家名:<td> ${list.expertname}</td>  <br>
		年龄:<td> ${list.age}</td> <br>
		性别:<td> ${list.sex}</td> <br>
		地址:<td> ${list.address}</td> <br>
		电话:<td> ${list.telephone}</td> <br>
		密码:<td> ${list.password}</td> <br>
		真实姓名:<td> ${list.rname}</td> <br>
		专业:<td> ${list.major}</td> <br>
		<a href="${pageContext.request.contextPath }/expperson.action?name=${list.expertname}">&nbsp;修改</a> </td> <br>
		<p>
	</c:forEach>
</body>
</html>