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
<link rel="stylesheet" href="css/style.css"type="text/css" />
<style>
body {
	background-color: rgba(245, 245, 245, 200);
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
   
      <div class="container">
        <h1>${text.title}</h1>
        <h4></h4>
   
            <div class="news-list-item">
              <div class="author-time">
                <span>${text.authorname}</span> 发表于 <span>${text.createtime}</span>
              </div>
                <div class="news-content-des">
                  <p>  &nbsp;&nbsp;&nbsp; ${text.detail }
                </div>
            </div>
            <form action="${pageContext.request.contextPath }/updatecheckMark.action" method="post">
            <input type="hidden" name="tid" value="${text.tid}" />
            <input type="radio" value="不合格" name="checkMark" >不合格
            <input type="radio" value="合格" name="checkMark" > 合格
            <input type="radio" value="优秀" name="checkMark" > 优秀
            <input type="submit">
            </form>
   
 
</body>


</html>