<%--
  Created by IntelliJ IDEA.
  User: xiaozhameng
  Date: 2019-11-09
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
        #allmap{height:750px;width:100%;}
        #r-result{width:100%; font-size:14px;}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=G5FG7YhRZkXSLDuaGImVsG9u7QWh380h"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>
    <title>城市名定位</title>
</head>
<body>
<div id="allmap"></div>
<div id="r-result">
    城市名: <input id="cityName" type="text" style="width:100px; margin-right:10px;" />
    <input type="button" value="查询" οnclick="theLocation()" />
    <input type="button"  οnclick="openHeatmap();" value="显示热力图"/><input type="button"  οnclick="closeHeatmap();" value="关闭热力图"/>
</div>
</body>
</html>
<script type="text/javascript" src="/static/js/jquery/jquery.js"></script>
<script type="text/javascript" src="/static/js/dev/mapview.js"></script>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(116.418261, 39.921984);
    map.centerAndZoom(point,15);

    function theLocation(){
        var city = document.getElementById("cityName").value;
        if(city != ""){
            map.centerAndZoom(city,15);      // 用城市名设置地图中心点
        }
    }

    //设置地图样式
    var mapStyle={style : "dark" }
    map.setMapStyle(mapStyle);

    //在地图上添加图片文字等信息(版权控件)
    var cr=new BMap.CopyrightControl({anchor:BMAP_ANCHOR_TOP_LEFT,offset:new BMap.Size(0,0)});
    map.addControl(cr);
    cr.addCopyright({id:1,content:"<img src='./5.bmp' style='width:1600px;' />"});    //需要更改为你的图片地址和名称


    // 初始化地图， 设置中心点坐标和地图级别
    //map.centerAndZoom(new BMap.Point(116.4035,39.915),15);
    //setTimeout(function(){
    //	map.setZoom(14);
    //}, 2000);  //2秒后放大到14级
    map.enableScrollWheelZoom(true);

    selectData(function (data) {
        var points = data;
        console.info(points);

        if(!isSupportCanvas()){
            alert('热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能~')
        }
        //详细的参数,可以查看heatmap.js的文档 https://github.com/pa7/heatmap.js/blob/master/README.md
        //参数说明如下:
        /* visible 热力图是否显示,默认为true
         * opacity 热力的透明度,1-100
         * radius 势力图的每个点的半径大小
         * gradient  {JSON} 热力图的渐变区间 . gradient如下所示
         *	{
                .2:'rgb(0, 255, 255)',
                .5:'rgb(0, 110, 255)',
                .8:'rgb(100, 0, 255)'
            }
            其中 key 表示插值的位置, 0~1.
                value 为颜色值.
         */
        heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":20});
        map.addOverlay(heatmapOverlay);
        heatmapOverlay.setDataSet({data:points,max:100});

        // closeHeatmap();
    });

    //是否显示热力图
    function openHeatmap(){
        heatmapOverlay.show();
    }
    function closeHeatmap(){
        heatmapOverlay.hide();
    }

    function setGradient(){
        /*格式如下所示:
       {
             0:'rgb(102, 255, 0)',
             .5:'rgb(255, 170, 0)',
             1:'rgb(255, 0, 0)'
       }*/
        var gradient = {};
        var colors = document.querySelectorAll("input[type='color']");
        colors = [].slice.call(colors,0);
        colors.forEach(function(ele){
            gradient[ele.getAttribute("data-key")] = ele.value;
        });
        heatmapOverlay.setOptions({"gradient":gradient});
    }
    //判断浏览区是否支持canvas
    function isSupportCanvas(){
        var elem = document.createElement('canvas');
        return !!(elem.getContext && elem.getContext('2d'));
    }
</script>