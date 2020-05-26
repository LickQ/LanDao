<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>攻略中心</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
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


<c:if test="${!empty user }">
    <div class="row clearfix" align="right">
        <div class="col-md-12 column" style="padding-right: 29px;">
            <a href="${pageContext.request.contextPath }/addStrategry.action">
                <button>发布攻略</button>
            </a>
        </div>
    </div>
</c:if>
<div class="container">
    <%--<div class="row clearfix">--%>
    <c:forEach items="${strategies }" var="text">
        <div class="news-list">
            <div class="news-list-left">
                <div class="news-list-item">
                    <div class="author-time">
                        发表于 <span>${text.strategyCreatetime }</span>
                    </div>
                    <div class="news-des">
                        <h3 class="news-title">
                            <i></i><a
                                href="${pageContext.request.contextPath }/findit.action?id=${text.strategyId}">${text.strategyTitle }</a>
                        </h3>
                        <div class="news-content-des" >${text.strategySummary }</div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    <%--</div>--%>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <li>
                            <a href="#">Prev</a>
                        </li>
                        <li>
                            <a href="#">1</a>
                        </li>
                        <li>
                            <a href="#">2</a>
                        </li>
                        <li>
                            <a href="#">3</a>
                        </li>
                        <li>
                            <a href="#">4</a>
                        </li>
                        <li>
                            <a href="#">5</a>
                        </li>
                        <li>
                            <a href="#">Next</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
</div>
</body>
</html>