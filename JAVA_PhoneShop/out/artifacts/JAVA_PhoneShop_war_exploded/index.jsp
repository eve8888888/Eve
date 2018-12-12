<%--
  Created by IntelliJ IDEA.
  User: Eve
  Date: 2018/12/3
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>

      <link rel="stylesheet" type="text/css" href="bootstrap.css"/>
      <link rel="stylesheet" type="text/css" href="style.css"/>
      <link rel="stylesheet" type="text/css" href="css/login.css"/>


  </head>
  <body background="background2.png">
  <script type="text/javascript">

      function display(id,id2){
          var traget=document.getElementById(id);
          var traget2=document.getElementById(id2);
          if(traget2.style.display==""){
              traget2.style.display="none";
              traget.style.display="";
          }
      }
      function display2(id,id2){
          var traget=document.getElementById(id);
          var traget2=document.getElementById(id2);
          if(traget.style.display==""){
              traget.style.display="none"
              traget2.style.display="";
          }
      }
  </script>
  <ul class="nav nav-pills nav-stacked">
  </ul>
    <div id = "d1">

    </div>
    <div id="d2" align="certen">
      <ul class="nav nav-pills" style="margin:0 auto">
          <li class="resp-tab-item" onclick="display('lb','lb2')"><a href="#"><span style="color: white">登录</span></a></li>
        <li  class="resp-tab-item" onclick="display2('lb','lb2')"><a href="#" aria-controls=""><span style="color: white">注册</span></a></li>
      </ul>
      <div class="register" id="lb" align="center" >
        <form action="LoginServlet" method="post">
          <input name="u_id" placeholder="ID" type="text" required=""><br>
          <input name="u_pwd" placeholder="Password" type="password" required="">
          <div class="sign-up">
            <input type="submit" value="登录"/>
          </div>
        </form>
      </div>
      <div >
        <div class="register" style="display: none" id="lb2" align="center">
          <form action="#" method="post">
            <input placeholder="Name" name="Name" type="text" required="">
            <input placeholder="ID" name="Email" type="email" required="">
            <input placeholder="Password" name="Password" type="password" required="">
            <input placeholder="Confirm Password" name="Password" type="password" required="">
            <div class="sign-up">
              <input type="submit" value="注册"/>
            </div>
          </form>
        </div>

      </div>
    </div>
  </body>
</html>
