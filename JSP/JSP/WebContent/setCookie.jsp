<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Cookie</title>
</head>
<body>
	<%
		Cookie c = new Cookie("name","Toyz");
		c.setMaxAge(24*60*60);
		c.setPath("/");
		response.addCookie(c);
	%>
</body>
</html>