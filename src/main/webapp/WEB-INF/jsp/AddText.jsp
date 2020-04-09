<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <script type="text/javascript">
window.onload=function(){
	var sub=document.getElementById("sub");
	sub.onclick=function(){
		var title=document.getElementById("title").value;
		if(title==""){
			alert("标题不能为空");
			return false;
		}
		var summary=document.getElementById("summary").value;
		if(summary==""){
			alert("摘要不能为空");
			return false;
		}
		var detail=document.getElementById("detail").value;
		if(detail==""){
			alert("内容不能为空");
			return false;
		}
	}
	
}
    </script>
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
        .biaoti{
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
    <div class="ct">
    <form id="myform" class="form-horizontal" action="${pageContext.request.contextPath }/AddText.action" method="post" style="margin-top: 5px;">
        <div class="biaoti bg">
            <p style="display: inline;">标题</p>
            <input type="text" style="margin-left: 50px;height: 30px" placeholder="标题" name="title" id=title>
        </div>
        <div class="zs bg">
            <p style="display: inline-block;">摘要</p>
            <textarea 
                      style="width: 200px;height: 30px;resize: none;margin-left:50px;vertical-align: middle" rows="2"
                      cols="80"
                      onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"
            placeholder="摘要" name="summary" id="summary"></textarea>
            <!--vertical-align: middle让两个标签水平对齐-->
            <br><br>
            <p > 详细内容</p>
            <br>
            <textarea  style="width: 600px;height:300px;margin-left: 18px;resize: none;vertical-align: middle" rows="3"
                      cols="80"
                      onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5" placeholder="内容" name="detail" id="detail"></textarea>
        </div>

        <select name="cid" id="xl" style="width: 100px;margin-top:25px;margin-left:25px" >
            
        </select>
        <div class="xuanze bg">
            <!-- <input type="radio" value="1" name="cid"> 自然科学
            <input type="radio" value="2" name="cid"> 人工智能
            <input type="radio" value="3" name="cid"> 区块链 -->
            <br>
            <input type="submit" id="sub" style="width: 200px;height:50px;background-color:#6495ED;margin-top: 30px;margin-left: 80px;margin-bottom:10px">

        </div>
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