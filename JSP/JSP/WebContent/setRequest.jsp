<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请求中数据，仅本次请求有效</title>
</head>
<body>
<%
	request.setAttribute("name", "RequestData");
%>
请求中数据：<%= request.getAttribute("name") %>，仅当前请求有效
</body>
</html>