<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>景区信息</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <%--<script src="js/jquery-1.4.4.min.js" type="text/javascript"></script>--%>
    <%--<script src="js/bootstrap.min.js" type="text/javascript"></script>--%>
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

<div class="row clearfix" >
    <div class="col-md-6 column" style="padding-left: 30px" >
        <img src="${scenery.sceneryPicture}" class="img-thumbnail"  style="width: 100%"   />
    </div>
    <div class="col-md-6 column" >
        <h3 style="font-family: sans-serif">景区名称:${scenery.sceneryName}</h3><br/>
        <strong style="font-family: 'Al Tarikh'">地址:${scenery.sceneryAddress}</strong><br/>
        <dt>景区描述:
        <div class="news-content-des">
            <p style="font-size: 120%"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${scenery.sceneryDescription}</p>
        </div>
        </dt>
        <br>
        <a href="${scenery.sceneryLink}" >景区马蜂窝链接</a>
    </div>
</div>


<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>




</body>


</html>