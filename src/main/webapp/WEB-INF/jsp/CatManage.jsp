<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/index.css" type="text/css" />

<style>
body {
	background-color: rgba(245, 245, 245, 200);
	margin-top: 20px;
	margin: 0 auto;
	width: 100%;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
				 float:left; */
	
}

font {
	color: #666;
	font-size: 22px;
	font-weight: normal;
	padding-right: 17px;
}
</style>
</head>
<body>

	<td><h5><a href="${pageContext.request.contextPath }/AddCategory.action">&nbsp;&nbsp;增加类别</a></h5></td>
	<h3>类别管理：</h3>
	<c:forEach items="${categorylist}" var="text">
		<td> ${text.cname}
		<a href="${pageContext.request.contextPath }/deleteCategory.action?id=${text.cid}">&nbsp;&nbsp;删除</a> </td> 
		<a href="${pageContext.request.contextPath }/">&nbsp;修改</a> </td> <br>
	</c:forEach>



</body>
</html>