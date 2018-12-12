<%--
  Created by IntelliJ IDEA.
  User: Eve
  Date: 2018/12/3
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">

        function old(){
            //创建对象
            var n = new Date();
            //分别获取年月日时分秒
            var y = n.getFullYear();
            var m1 = n.getMonth()+1;
            var d = n.getDate();
            var h = n.getHours();
            var m = n.getMinutes();
            var s = n.getSeconds();
            var now = y+"-"+m1+"-"+d+" "+h+":"+m+":"+s;
            //获取span
            var sp = document.getElementById("sp");
            //把当前时间赋值给span
            sp.innerHTML = now;
            //调用window的setTimeout方法，让old()函数每一千毫秒刷新一次
            window.setTimeout("old()", 1000);
        }

    </script>
    <style type="text/css">
        #d1{
            background:yellow;
            width:155px;
            height:20px;
            margin-left:1000px;
            margin-top:13px;
        }
    </style>
</head>
<body bgcolor="#FF69B4" onload="old()">

欢迎【${user.u_name}】&nbsp;|&nbsp;
<a href="ExitServlet" target="_parent">退出</a>
<%-- <h4 align="right">${currentTime}</h4> --%>
<div id="d1">
    <span id="sp"></span>
</div>

</body>
</html>

