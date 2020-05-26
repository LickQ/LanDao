<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>景区</title>
    <%--<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />--%>
    <script src="js/jquery-1.4.4.min.js" type="text/javascript"></script>
    <%--<script src="js/bootstrap.min.js" type="text/javascript"></script>--%>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="css/index.css" type="text/css"/>
    <%--<link rel="stylesheet" href="css/style.css"type="text/css" />--%>
    <style type="text/css">
        body, html {
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
    <div class="row clearfix">
        <div class="col-md-8 column">

            <c:forEach items="${sceneries }" var="sceneries">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <div class="jumbotron">
                            <h1>
                                    ${sceneries.sceneryName }
                            </h1>
                            <p>
                                    ${sceneries.scenerySummary }
                            </p>
                            <p>
                                <a class="btn btn-primary btn-large"
                                   href="${pageContext.request.contextPath }/sceneryDetal.action?sceneryId=${sceneries.sceneryId}">详情</a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>


        </div>
        <div class="col-md-4 column">
            <h3>景区排行榜</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>
                        景区名称
                    </th>
                    <th>
                        热值
                    </th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${sceneries }" var="sceneries">
                <tr>

                    <td>
                    ${sceneries.sceneryName }
                    </td>
                    <td>
                     ${sceneries.sceneryHotvalue }
                    </td>
                    </c:forEach>

                </tbody>
            </table>

        </div>
    </div>
</div>


<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>



