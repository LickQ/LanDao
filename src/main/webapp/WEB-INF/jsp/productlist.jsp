<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>民宿</title>
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


<div class="container">
    <div class="row clearfix">
        <div class="col-md-6 column">
            <div class="row">
                <c:forEach items="${productlist }" var="productlist">

                    <div class="col-md-6">
                        <div class="thumbnail">
                            <img alt="300x200" src="${productlist.productIcon}"/>
                            <div class="caption">
                                <h3>
                                        ${productlist.productName }
                                </h3>
                                <p>
                                        ${productlist.productDescription }
                                </p>
                                <p>
                                    <a class="btn btn-primary"
                                       href="${pageContext.request.contextPath }/productinfo.action?productId=${productlist.productId }">预定</a>
                                    <a class="btn" href="#"></a>
                                </p>
                            </div>
                        </div>
                    </div>

                </c:forEach>
            </div>
            <ul class="pagination">
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
        <div class="col-md-6 column">
            <font size='5'>
                <td> ${inns.innName}</td>
            </font><br/>

            <div class="thumbnail">
                <img  style="width: 100%" src="${inns.innPicture}"/>
            </div>
            <address><strong>详细信息</strong><br/>
                商家描述：${inns.innDescription}<br/>
                商家地址:${inns.innAddress}<br/>
                商家电话:${inns.innTelephone}<br/>
            </address>
            <hr/>
            <div style="background-color: #d3d3d3; width: 900px;margin:0px auto; ">
                <table class="table table-bordered" >
                    <tbody>
                    <tr class="active">
                        <th><strong>用户评论</strong></th>
                    </tr>
                    <c:forEach items="${comments}" var="comments">
                        <tr class="warning">
                            <th>${comments.userName} <a>${comments.commentDetail}</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <%--<strong>用户评论</strong><br/>--%>
            <%--<c:forEach items="${comments}" var="comments">--%>
            <%--<strong>${comments.userName}: </strong>--%>
            <%--${comments.commentDetail} <br/>--%>
            <%--</c:forEach>--%>
        </div>
    </div>
</div>

<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>








