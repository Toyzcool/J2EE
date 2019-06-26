<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hero</title>
</head>
<body>
	<table align='center' border='1' cellspacing='0'>
		<tr>
			<td>序号</td>
			<td>名称</td>
			<td>血量</td>
			<td>输出</td>
		</tr>
		<c:forEach items="${ heros }" var="hero" varStatus="st">
			<tr>
			<td>${ hero.id }</td>
			<td>${ hero.name }</td>
			<td>${ hero.hp }</td>
			<td>${ hero.damage }</td>
			<td><a href="editHero?id=${hero.id}">edit</a></td>
			<td><a href="deleteHero?id=${hero.id}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>