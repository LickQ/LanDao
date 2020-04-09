<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
   
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        body {
            background: url("image/background.jpg") rgba(245, 245, 245, 200);

        }

        .header {
            width: 100%;
            height: 30px;
        }

        .header a {
            display: inline-block;
            color: #666;
            font-size: 20px;
            font-weight: normal;
            padding-right: 17px;
            opacity: 0.5;
        }

        .header a:hover {
            opacity: 1;
        }

        .tInput {
            display: inline-block;
        }

        .content {
            height: 100%;
            width: 800px;
            margin: 50px auto;
            /* background: orangered;*/
            position: relative;
            background-color: #fff;
            opacity: 0.8;
            font-size: 23px;
            border: 1px solid #000;
        }

        .content > .ct {
            margin-left: 375px;
        }
        .ct{
        margin-left:200px;
        }

        .zs, .xuanze {
            margin-top: 30px;
            align-items: flex-end;
            /*border: 1px solid #ccc;*/
            width: 400px;
        }
        .bg{
            padding-top: 20px;

        }
        textarea{
            font-size: 20px;
        }

    </style>
</head>
<body>
<div class="header">
    <a href="/springmvc-mybatis2/index.action">退出</a>
    
</div>
<hr>
<div class="content bg">
<form action="${pageContext.request.contextPath }/updateaut.action" method="post">
    <div class="ct">
     <input type="hidden" name="aid" value="${autperson.aid }" /> 
        <div class="userName bg">
            <p style="display: inline;">用户名</p>
            <input type="text" style="margin-left: 50px;height: 30px" placeholder="用户名" name="authorname" value="${autperson.authorname}">
        </div>
        <div class="age bg">
            <p style="display: inline;">年龄</p>
            <input type="text" style="margin-left: 72px;height: 30px" placeholder="年龄" name="age"  value="${autperson.age}">
        </div>
        <div class="sex bg">
            <p style="display: inline;">性别</p>
            <input type="text" style="margin-left: 72px;height: 30px" placeholder="性别" name="sex"  value="${autperson.sex}">
        </div>
        <div class="address bg">
            <p style="display: inline;">地址</p>
            <input type="text" style="margin-left: 72px;height: 30px" placeholder="地址"  name="address"  value="${autperson.address}">
        </div>
        <div class="telephone bg">
            <p style="display: inline;">电话</p>
            <input type="text" style="margin-left: 72px;height: 30px" placeholder="电话" name="telephone"  value="${autperson.telephone}">
        </div>
        <div class="name bg">
            <p style="display: inline;">密码</p>
            <input type="text" style="margin-left: 25px;height: 30px" placeholder="密码"  name="password"  value="${autperson.password}">
        </div>
        <div class="name bg">
            <p style="display: inline;">真实姓名</p>
            <input type="text" style="margin-left: 25px;height: 30px" placeholder="真实姓名"  name="rname"  value="${autperson.rname}">
        </div>
            <input type="submit" style="width: 200px;height:50px;background-color:#6495ED;margin-top: 30px;margin-left: 72px;margin-bottom:10px" id="sub">

        </div>


    </div>
</form>
</div>

<%-- <form action="${pageContext.request.contextPath }/updateaut.action" method="post">
      <input type="hidden" name="aid" value="${autperson.aid }" /> 
        密码:<input type="text"name="password" value="${autperson.authorname}" > <br>
		年龄:<input type="text"name="age" value="${autperson.age}" > <br>
		性别:<input type="text"name="sex" value="${autperson.sex}" > <br>
		地址:<input type="text"name="address" value="${autperson.address}" > <br>
		电话:<input type="text"name="telephone" value="${autperson.telephone}" > <br>
		真实姓名:<input type="text"name="rname" value="${autperson.rname}" > <br>
		<input type="submit">
</form> --%>
<a class="navbar-brand" href="/springmvc-mybatis2/index.action">首页</a>
</body>
</html>