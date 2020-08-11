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
    <title>demo 页</title>

    <%-- 引入jquery --%>
    <script src="/static/js/jquery/jquery.js"></script>

    <%-- 引入自定义js文件 --%>
    <script src="/static/js/dev/demo.js"></script>
</head>
<body>
    <div>
        这是一个测试页面
        <br/>
        <br/>
        <input type="button" value="点我发送Http-get 请求" onclick="doGet();"/>
        <br/>
        <br/>
        <input type="button" value="点我发送Http-post 请求" onclick="doPost();"/>

        <br/>
        <br/>
        <input type="button" value="点我发送请求数据" onclick="doPostQueryList();"/>
    </div>
</body>
</html>
