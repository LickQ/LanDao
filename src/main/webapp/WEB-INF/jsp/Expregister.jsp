<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>专家注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<!-- 引入表单校验jquery插件 -->
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}

.error{
	color:red
}
</style>

</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>专家注册</font>USER REGISTER
				<form id="myform" class="form-horizontal" action="${pageContext.request.contextPath }/Expregister.action" method="post" style="margin-top: 5px;">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="expertname" id="expertname-id" onblur="checkName()"
								placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password" name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="repassword" name="repassword" onblur="checkpassword()"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">真实姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control"  name="rname"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">年龄</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="age" id="age" onblur="checkage()"
								placeholder="年龄">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> 
								<input type="radio" name="sex"  value="男" >男
							</label> 
							<label class="radio-inline"> 
								<input type="radio" name="sex"  value="女">女
							</label>
							<label class="error" for="sex" style="display:none ">您没有第三种选择</label>
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">电话号</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="telephone" id="telephone" onblur="checktel()"
								placeholder="电话号">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">地址</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="address"
								placeholder="地址">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">专业</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="major"
								placeholder="专业">
						</div>
					</div>


					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>
<script>
  function checkName(){
	  var userName=document.getElementById("expertname-id");
	  if(userName.value==""){
          alert("用户名不能为空");
		  userName.value="";
	  }
	  if(!(/[A-Za-z0-9]+/.test(userName.value))){
		  alert("用户名只能为数字和字母");
		  userName.value="";
	  }
  }
   function checkpassword(){
	  var pasword=document.getElementById("password");
	  var repasword=document.getElementById("repassword");
	  if(password.value!=repassword.value){
		  alert("两次输入的密码不同");
		  repassword.value="";
		   password.value=""; 
	  }
  } 
  function checkage(){
	  var age=document.getElementById("age");
	  if(age.value<=0){
		  alert("请输入正确的年龄");
		  age.value="";
	  }
  }
   function checktel(){
	  var tel=document.getElementById("telephone");
	  if(!(/^\d+$/.test(tel.value))){
		  
		  alert("请输入正确的电话号码");
		  tel.value="";
	  }
  }  
</script>


