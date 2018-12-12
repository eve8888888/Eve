<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#D8BFD8">

<form action="SubmitOrderServlet" method="post">
	收货地址<input type="text" name="address"><br>
		 <input type="submit" value="提交"><br>
		<c:forEach items="${listReadyOrderCar }" var="OrderCar">
			<input type="text" value="${OrderCar.cid }" name="cids" readonly="readonly"><br>
			
		</c:forEach>

</form>

</body>
</html>