<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>作家登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/index.css" type="text/css" />
<link rel="stylesheet" href="css/style.css"type="text/css" />
<style>
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

        .header p {
            display: inline-block;
            color: #666;
            font-size: 20px;
            font-weight: normal;
            padding-right: 17px;
            opacity: 0.5;
        }

        .header p:hover {
            opacity: 1;
        }

        .tInput {
            display: inline-block;
        }

        .content {
            height: 700px;
            width: 800px;
            margin: 50px auto;
            /* background: orangered;*/
            position: relative;
            background-color: #fff;
              opacity: 0.8;
            font-size: 23px;
        }

        .content > .ct {
            margin-left: 75px;
        }

        .zs, .xuanze {
            margin-top: 30px;
            align-items: flex-end;
            /*border: 1px solid #ccc;*/
            width: 400px;
        }
        #sub{
            display:inline-block;
            float:right;
            position:absolute;
            bottom:-20px;
            right:10px;
        }
        #myform{
            position:relative;
        }

        .biaoti{
            padding-top: 20px;
        }
        textarea{
            font-size: 20px;
        }
        #xl{
        width: 200px;height:50px;margin-top:25px;margin-left:25px
        }

</style>
</head>
<body>
    <!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
   <div class="content bg">
    <div class="ct">
   <form action="${pageContext.request.contextPath }/updatetext.action" method="post">
      <div class="container">
      <input type="hidden" name="tid" value="${text.tid }" />
      <div class="biaoti bg">
        <p>标题:<input type="text" style="margin-left: 50px;height: 30px" placeholder="标题" name="title" id=title  value="${text.title}"> </p>
      </div>
         <div class="zs bg">
                <span>摘要:
                <textarea
                      style="width: 515px;height: 100px;resize: none;margin-left:100px;vertical-align: middle" rows="2"
                      cols="80"
                      onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"
            placeholder="摘要" name="summary" id="summary" value="${text.summary}">${text.summary}</textarea> </span> <br>



                  <p>  详细内容:
                  <textarea  style="width: 600px;height:300px;margin-left: 18px;resize: none;vertical-align: middle" rows="3"
                      cols="80"
                      onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5" placeholder="内容" name="detail" id="detail" value="${text.detail}">${text.detail}</textarea>
                  </p>
                  </div>
              <select name="cid" id="xl"  >

              </select>
<input type="submit">
            </form>
   </div>
 </div>
</body>
<script type="text/javascript">
			//AddText.jsp加载完毕后 去服务器端获得所有的category数据
			$(function(){
				var content = "";
				$.post(
					"${pageContext.request.contextPath}/category.action",
					function(data){
						//[{"cid":"xxx","cname":"xxxx"},{},{}]
						//动态创建<li><a href="#">${category.cname }</a></li>

						for(var i=0;i<data.length;i++){
							content+="<option value="+data[i].cid+">"+data[i].cname+"</option>";
						}

						//将拼接好的option放置到select中
						$("#xl").html(content);
					},
					"json"
				);
			});

		</script>

</html>