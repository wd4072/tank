<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<table>
			<tr>
				<td>编码</td>
				<td>姓名</td>
				<td>账户余额</td>
			</tr>
			<c:forEach var="u" items="${users }">
				<tr >
				<td>${u.id }</td>
				<td>${u.name }</td>
				<td>${u.account }</td>
				</tr>
			</c:forEach>			
	</table>
</body>
</html>