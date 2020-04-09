<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>大学学报投稿信息管理系统</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.7.0/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.7.0/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.7.0/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		var treeData=[{
			text:"根",
			children:[{
				text:"类别管理",
				attributes:{
					url:"${pageContext.request.contextPath }/categorylist.action"
				}
			},{
				text:"作者信息",
				attributes:{
					url:"${pageContext.request.contextPath }/authorlist.action"
				}
			},{
				text:"专家信息",
				attributes:{
					url:"${pageContext.request.contextPath }/expertlist.action"
				}
			},{
				text:"操作历史",
				attributes:{
					url:"${pageContext.request.contextPath }/historylist.action"
				}
			}
			]
		}];
		
		//实例化树菜单
		$("#tree").tree({
			data:treeData,
			lines:tree,
			onClick:function(node){
				if(node.attributes){
					openTab(node.text,node.attributes.url);
				}
			}
		});
		
		//新增tab
		function openTab(text,url){
			if($("#tabs").tabs('exists',text)){
				$("#tabs").tabs('select',text);
			}else{
				var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
				$("#tabs").tabs('add',{
					title:text,
					closable:true,
					content:content
				});
				
			}
		}
	});
</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height:80px;background-color:#E3EAF4">
	</div>
	<div region="center" >
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页">
				<div align="center" style="padding-top:100px;"><font color="red" size="10">欢迎使用</font></div>
			</div>
		</div>
	</div>
	<div region="west" style="width:150px;" title="导航菜单" split="true">
		<ul id="tree"></ul>
	</div>
	<div region="south" style="height:40px;" align = "center">大学学报投稿信息管理系统，版权所有。</div>
</body>
</html>