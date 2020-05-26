<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>成功提示</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    成功!
                </h4> <a href="${pageContext.request.contextPath }/productlist.action?innId=${innId}" class="alert-link">3s后自动跳转</a>
            </div>
        </div>
    </div>
</div>

</body>

<script>
    setTimeout('location.href="${pageContext.request.contextPath }/productlist.action?innId=${innId}"', 3000);
</script>

</html>