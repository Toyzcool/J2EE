<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Session </title>
</head>
<body>
	<%
		session.setAttribute("name","Session");
	%>
	<a href="getSession.jsp">跳转到getSeesion.jsp</a>
</body>
</html>