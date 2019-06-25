<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>向作用域设置数据</title>
</head>
<body>
<%
	/* 当前页面 */
	pageContext.setAttribute("name", "PageContextData");

	/* 当前用户所属的会话 */
	pageContext.setAttribute("name", "SessionData",pageContext.SESSION_SCOPE);
	
	/* 全局 */
	pageContext.setAttribute("name", "ApplicationData",pageContext.APPLICATION_SCOPE);
%>
	<!-- 当前页面 -->
	页面数据为：<%= pageContext.getAttribute("name") %>，只能在当前页面访问<br>
	
	<!-- 当前用户所属的会话 -->
	会话数据为：<%= pageContext.getAttribute("name",pageContext.SESSION_SCOPE) %>，可用于页面间数据传递<br>
	
	<!-- 全局 -->
	全局数据为：<%= pageContext.getAttribute("name",pageContext.APPLICATION_SCOPE) %>，所有用户共享<br>
</body>
</html>