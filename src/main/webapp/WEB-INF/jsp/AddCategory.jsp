<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加类别</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/AddCategory.action" method="post"">
<input type="text" name="cname">
<input type="submit">
</form>

</body>
</html>