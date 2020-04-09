<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>作家登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/index.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	background-image: url('image/background.jpg');
	background-position: center;
	background-attachment: fixed;
	background-origin: border-box;
	background-size: cover;
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
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<h4><td><a href="${pageContext.request.contextPath }/AddText.action">投稿</a></td></h4>
	文章列表：
	<c:forEach items="${textList }" var="text">
		<div class="news-list">
			<div class="news-list-left">
				<div class="news-list-item">
					<div class="author-time">
						<span>${text.authorname }</span> 发表于 <span>${text.createtime }</span>
					</div>
					<div class="news-des">
						<h3 class="news-title">
							<i></i><a
								href="${pageContext.request.contextPath }/findit.action?id=${text.tid}">${text.title }</a>
						</h3>
						<div class="news-content-des">${text.summary }</div>
						<h4>
							<div class="news-content-des">${text.checkMark }</div>
						</h4>

					</div>
					<c:if test="${text.checkMark=='未审核'}">
						<td><a
							href="${pageContext.request.contextPath }/textEdit.action?tid=${text.tid}">修改</a></td>
						<td><a
							href="${pageContext.request.contextPath }/deleteText.action?tid=${text.tid}">删稿</a></td>
					</c:if>

				</div>
			</div>
		</div>
	</c:forEach>




</body>
</html>