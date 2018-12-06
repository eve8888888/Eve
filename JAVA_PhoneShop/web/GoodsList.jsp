<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--导入JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<br>
<table width="700" border="1" cellspacing="0" align="center" bordercolor="pink">
	<c:forEach items="${listGoods }" var="goods" varStatus="count">
		<c:if test="${count.index%4==0}">
	        <tr>
	    </c:if>
	    	<td>
	    		<table width="170" height="180" cellspacing="0">
	    			<tr>
	    				<td align="center">
	    					<img src="Image/${goods.gimage }" width="170" height="180">

	    					<span>${goods.gname }</span><br>
	    					<span>${goods.gmoney }</span>
	    					<a href="AddCarServlet?gid=${goods.gid }" target="a">加入购物车</a>
	    				</td>
	    			</tr>
	    		
	    		</table>
	    	</td>
	    <c:if test="${count.index%4==3}">
            </tr>
        </c:if>
	</c:forEach>
</table>
</body>
</html>