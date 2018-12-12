<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
<script type="text/javascript" src="js/index.js"></script>

</head>
<body onload="ond()" bgcolor="#D8BFD8">
<br>
<center>订单明细列表</center>
<table width="700" border="1" cellSpacing="0" align="center">
		<tr align="center">
			<th>订单编号</th>
			<th>商品ID</th>
			<th>商品数量</th>
			<th>订单单价</th>
			<th>订单总额</th>
			<th>收货地址</th>
			<th>派发状态</th>
		</tr>
	<c:forEach items="${listOrdersDetail}" var="OrdersDetail">
		<tr align="center" onmouseover="omo(this)" onmouseout="omt(this)">
			<td>${OrdersDetail.oid}</td>
			<td>${OrdersDetail.gid}</td>
			<td>${OrdersDetail.odnum}</td>
			<td>${OrdersDetail.odmoney}</td>
			<td>${OrdersDetail.odtotalmoney}</td>
			<td>${OrdersDetail.odaddress}</td>
			<td>${OrdersDetail.odstatus}</td>
		</tr>
	</c:forEach>
</table>		
</body>
</html>