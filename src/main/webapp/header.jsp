<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<!DOCTYPE html>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<div class="container-fluid">

	<div class="col-md-3" style="padding-top: 20px" >
		<ol class="list-inline" >
			<c:if test="${empty user }">
			<a href="${pageContext.request.contextPath }/userLogin.action" >登录</a>
			</c:if>
			<c:if test="${!empty user }">
				<li style="color:black">欢迎您 <a  style="color:grey" href="${pageContext.request.contextPath }/autperson.action">${user.userRname }</a></li>
				<%--<li><a href="${pageContext.request.contextPath }/AuthorList.action">作者中心</a></li>--%>
				<li><a style="color:grey" href="${pageContext.request.contextPath }/logout.action">注销</a></li>
			</c:if>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<%--<a class="navbar-brand" href="${pageContext.request.contextPath }/index.action">主页</a>--%>
				<%--<a class="navbar-brand" href="${pageContext.request.contextPath }/strategylist.action">旅游攻略</a>--%>
				<%--<a class="navbar-brand" href="${pageContext.request.contextPath }/scenerylist.action">旅游景区</a>--%>
				<%--<a class="navbar-brand" href="${pageContext.request.contextPath }/innlist.action">旅游民宿</a>--%>
				<%--<a class="navbar-brand" href="${pageContext.request.contextPath }/map1.action">岚岛地图</a>--%>

			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="categoryUl">
				</ul>

				<form class="navbar-form navbar-right"
					action="${pageContext.request.contextPath }/findTextByName.action"
					role="search" method="post">
					<input type="text" name="title" /> <input type="submit" value="提交"
						class="btn btn-default">
				</form>
			</div>
		</div>
<script type="text/javascript">
			//header.jsp加载完毕后 去服务器端获得所有的category数据
			$(function(){
				var content = "";
				$.post(
					"${pageContext.request.contextPath}/NavDirectory.action",
					function(data){
						//[{"cid":"xxx","cname":"xxxx"},{},{}]
						//动态创建<li><a href="#">${category.cname }</a></li>

						for(var i=0;i<data.length;i++){
							content+="<li><a href='${pageContext.request.contextPath}/"+data[i].navSuffix+"'>"+data[i].navName+"</a></li>";
						}

						//将拼接好的li放置到ul中
						$("#categoryUl").html(content);
					},
					"json"
				);
			});


		</script>
		



	</nav>
</div>