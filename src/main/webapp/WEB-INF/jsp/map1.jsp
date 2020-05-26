<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <!-- 引入header.jsp -->
    <jsp:include page="/header.jsp"></jsp:include>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="css/index.css" type="text/css"/>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <style type="text/css">
        body, html {
            /*background-color: rgba(245, 245, 245, 200);*/
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0;
            font-family: "微软雅黑";

        }
        #allmap {
            width: 900px;
            height: 600px;
            overflow: hidden;
            font-family: "微软雅黑";
            padding-left: 30px;
        }
    </style>
    <script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=moHETRVMoycrQEp8AdIVffujp2BoASBH"></script>
    <%--<script type="text/javascript" src="//api.map.baidu.com/api?type=webgl&v=1.0&ak=moHETRVMoycrQEp8AdIVffujp2BoASBH"></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <title>设置地图3D视角</title>

    <link rel="stylesheet" href="css/index.css" type="text/css"/>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>

</head>

<body>
<div class="container" style="width: 100%">
    <%--<div class="row clearfix">--%>
    <div class="col-md-8 column" id="md-8">
        <div id="allmap"></div>
    </div>
    <div class="col-md-4 column">
            <a href="${pageContext.request.contextPath }/map.action">
                <button type="button" class="btn btn-default">3d-Map</button>
            </a>
            <div class="col-md-4" id="listmap" style="width: 100%" >
            </div>

    <%--</div>--%>
</div>




</body>



<script type="text/javascript">

    var left = ''
    var right = ''
    var map = new BMap.Map("allmap");
    // GL版命名空间为BMapGL
    // 按住鼠标右键，修改倾斜角和角度
    init(left, right);

    function init(x, y) {

        // 创建Map实例
        map.centerAndZoom(new BMap.Point(x != '' ? x : 119.806708, y != '' ? y : 25.525061), 14);  // 初始化地图,设置中心点坐标和地图级别
        map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
        // map.setHeading(64.5);
        // map.setTilt(73);
        getmap(x != '' ? x : 119.806708, y != '' ? y : 25.525061)
    }


    map.addEventListener('click', function (e) {
        // var mercator = map.lnglatToMercator(e.latlng.lng, e.latlng.lat);
        // left=mercator[0]
        // right=mercator[1]
        init(e.point.lng, e.point.lat)
        alert(e.point.lng + ", " + e.point.lat);
        // var mercator = map.lnglatToMercator(e.latlng.lng, e.latlng.lat);
        // alert('点的墨卡托坐标：' + mercator[0] + ', ' + mercator[1]);
    });


    function getmap(x, y) {
        $.ajax({
            url: '${pageContext.request.contextPath }/demo',
            data: {
                x: x,
                y: y
            },
            type: 'get',

            success: function (data) {
                console.log(data)
                $('#listmap').empty()
                if(data.sceneryName!=null) {
                    $("#listmap").append('<h3>' + '景区名称:' + data.sceneryName + '</h3>' + '<br>' + '<strong>' + '景区地址:' + data.sceneryAddress + '</strong>'
                        + '<br>'+"<dt>"+'景区描述:'+data.sceneryDescription+"</dt>" + '<br>'
                    )
                }


            },
            error: function () {

            }
        });

    }
</script>
</html>