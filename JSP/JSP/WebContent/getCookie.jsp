<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Cookie</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if(null != cookies)
			for (int d = 0; d <= cookies.length - 1; d++) {
	            out.print(cookies[d].getName() + ":" + cookies[d].getValue() + "<br>");
				}
	%>
</body>
</html>