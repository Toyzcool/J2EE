<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <!-- 引入使用的JSTL标签库 -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<!-- 在request作用域中设置值 -->
	<c:set var="name" value="${'JSTLName'}" scope="request" />
	
	<!-- 输出在request中的值 -->
	通过标签获取name:<c:out value="${name}" />
</body>
</html>