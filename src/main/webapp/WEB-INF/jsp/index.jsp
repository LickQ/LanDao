<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <%--<script src="js/bootstrap.min.js" type="text/javascript"></script>--%>
    <!-- 引入自定义css文件 style.css -->
    <%--<link rel="stylesheet" href="css/index.css" type="text/css" />--%>
    <%--<link rel="stylesheet" href="css/style.css"type="text/css" />--%>
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


<!-- 轮播图 -->
<div class="container-fluid"  >
    <div class="row clearfix" >
        <div class="col-md-12 column">
            <div class="carousel slide" id="carousel-726850">
                <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target="#carousel-726850">
                    </li>
                    <li data-slide-to="1" data-target="#carousel-726850">
                    </li>
                    <li data-slide-to="2" data-target="#carousel-726850">
                    </li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <img  src="http://cdn.ibootstrap.cn/lorempixel.com/1600/500/sports/1/default.jpg" />
                        <div class="carousel-caption">
                            <h4>
                                First Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="http://cdn.ibootstrap.cn/lorempixel.com/1600/500/sports/2/default.jpg" />
                        <div class="carousel-caption">
                            <h4>
                                Second Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="http://cdn.ibootstrap.cn/lorempixel.com/1600/500/sports/3/default.jpg" />
                        <div class="carousel-caption">
                            <h4>
                                Third Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                </div> <a class="left carousel-control" href="#carousel-726850" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-726850" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
        </div>
    </div>
</div>
<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>

