<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<!DOCTYPE html>
<div class="container-fluid">

	<div class="col-md-3" style="padding-top: 20px">
		<ol class="list-inline">
		
			<c:if test="${empty author }">
			<a href="/springmvc-mybatis2/Autlogin.action">作家登录</a>
			</c:if>
			<c:if test="${!empty author }">
				<li style="color:red">欢迎您 <a href="${pageContext.request.contextPath }/autperson.action">${author.authorname }</a></li>
				<li><a href="${pageContext.request.contextPath }/AuthorList.action">作者中心</a></li>
				<li><a href="${pageContext.request.contextPath }/alogout.action">退出</a></li>
			</c:if>
			<c:if test="${empty expert }">
			<a href="/springmvc-mybatis2/Explogin.action">专家登录</a>
			</c:if>
			<c:if test="${!empty expert }">
				<li style="color:red">欢迎您 <a href="${pageContext.request.contextPath }/expperson.action">${expert.expertname }</a></li>
				<li><a href="${pageContext.request.contextPath }/ExpertList.action">专家中心</a></li>
				<li><a href="${pageContext.request.contextPath }/elogout.action">退出</a></li>
			</c:if>
			<c:if test="${empty admin }">
			<a href="/springmvc-mybatis2/Admlogin.action">管理员</a>
			</c:if>
			<c:if test="${!empty admin }">
				<li style="color:red">欢迎您，${admin.adminname }</li>
				<li><a href="${pageContext.request.contextPath }/adlogout.action">退出</a></li>
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
				<a class="navbar-brand" href="/springmvc-mybatis2/index.action">首页</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="categoryUl">

					<%-- <c:forEach items="${categortlist}" var="categortlist">


						<li><a href="${pageContext.request.contextPath }/findTextByCid.action?cid=${categortlist.cid}">${categortlist.cname }</a></li>
					</c:forEach> --%>

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
					"${pageContext.request.contextPath}/category.action",
					function(data){
						//[{"cid":"xxx","cname":"xxxx"},{},{}]
						//动态创建<li><a href="#">${category.cname }</a></li>
						
						for(var i=0;i<data.length;i++){
							content+="<li><a href='${pageContext.request.contextPath}/findTextByCid.action?cid="+data[i].cid+"'>"+data[i].cname+"</a></li>";
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