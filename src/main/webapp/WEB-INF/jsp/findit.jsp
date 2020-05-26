<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>攻略</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="css/index.css" type="text/css"/>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
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

<!-- <img src="background.jpg" class="index-bg"> -->
<h1>&nbsp&nbsp${text.strategyTitle}</h1>

<div class="news-content-des">
    <p style="font-size: 120%;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${text.strategyDetail }</p>

</div>
&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<span>${user.userName}</span> 发表于 <span>${text.strategyCreatetime}</span>
<div style="background-color: #d3d3d3; width: 90%;margin:0px auto; ">
    <table class="table table-bordered">
        <tbody>
        <tr class="active">
            <th><strong>用户评论</strong></th>
        </tr>
        <c:if test="${!empty comments }">
        <c:forEach items="${comments}" var="comments">
            <tr class="warning">
                <th>${comments.userName}: <a>${comments.commentDetail}</a></th>
            </tr>

        </c:forEach>
        </c:if>

        <c:if test="${empty comments }">
            <tr class="active">
                <th><strong>商品评论</strong></th>
            </tr>
            <tr class="warning">
                <th>暂无商品评论信息 <a>[发表商品评论]</a></th>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>

</body>


</html>