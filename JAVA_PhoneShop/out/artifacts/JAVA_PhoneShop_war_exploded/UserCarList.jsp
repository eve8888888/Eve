<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入js文件 -->
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">

	//全选反选
	function checkAll(){
		var cid = document.getElementById("cid");
		var cids = document.getElementsByName("cids");
		for (var i = 0; i < cids.length; i++) {
			if(cid.checked==true){
				cids[i].checked=true;
			}else{
				cids[i].checked=false;
			}
		}
	}
	
	//批量删除操作
	function DelsCar(){
		var arr = [];
		var cids = document.getElementsByName("cids");
		for (var i = 0; i < cids.length; i++) {
			if(cids[i].checked==true){
				arr.push(cids[i].value);
			}
		}
		var f = confirm("你确定要删除这  "+arr.length+" 个商品吗");
		var cs = arr.toString();
		if(f){
			window.location.href="DelsCarServlet?cids="+cs;
		}
	}
	
	//提交预备订单
	function ReadyOrder(){
		var arr = [];
		var cids = document.getElementsByName("cids");
		for (var i = 0; i < cids.length; i++) {
			if(cids[i].checked==true){
				arr.push(cids[i].value);
			}
		}
		var cs = arr.toString();
		window.location.href="ReadyOrderServlet?cids="+cs;
	}

</script>
</head>
<body onload="ond()" bgcolor="#D8BFD8">
<br>
<br>

<table width="700" border="1" cellspacing="0" align="center" bordercolor="pink">
	<tr>
		<td colspan="6">
			<input type="button" value="批量删除" onclick="DelsCar()"/>
			<input type="button" value="提交订单" onclick="ReadyOrder()"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="checkbox" id="cid" onclick="checkAll()">
		</td>
		<td>名称</td>
		<td>单价</td>
		<td>详图</td>
		<td>数量</td>
		<td>总额</td>
	</tr>
	<c:forEach items="${listCar }" var="c">
		<tr onmouseover="omo(this)" onmouseout="omt(this)">
			<td width="50">
				<input type="checkbox" name="cids" value="${c.cid }">
			</td>
			<td width="140">${c.cname }</td>
			<td>${c.cmoney }</td>
			<td width="130">
				<img src="Image/${c.cimage }" width="130" height="100">
			</td>
			<td>${c.cnum }</td>
			<td>${c.cmoney*c.cnum }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>