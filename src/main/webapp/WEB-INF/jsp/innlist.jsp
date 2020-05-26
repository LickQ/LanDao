<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>民宿</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
	<script src="js/jquery-1.4.4.min.js" type="text/javascript"></script>
	<%--<script src="js/bootstrap.min.js" type="text/javascript"></script>--%>
	<!-- 引入自定义css文件 style.css -->
	<link rel="stylesheet" href="css/index.css" type="text/css" />
	<link rel="stylesheet" href="css/style.css"type="text/css" />
	<style>
		body {
			/*background-color: rgba(245, 245, 245, 200);*/
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
		<div class="col-md-12 column">
			<div class="row">
				<c:forEach items="${inns }" var="inns">
					<div class="col-md-4">
						<div class="thumbnail">
							<img alt="300x200" src="${inns.innPicture}" />
							<div class="caption">
								<h3>
										${inns.innName }
								</h3>
								<p>
										${inns.innDescription }
								</p>
								<p>
									<a class="btn btn-primary" href=${pageContext.request.contextPath }/productlist.action?innId=${inns.innId }>预定</a> <a class="btn" href="#"></a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>



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
<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>











		

		
