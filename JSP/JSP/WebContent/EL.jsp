<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="bean.*"%>
      <!-- 引入使用的JSTL标签库 -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>

	<!-- 1.取值 -->
	<h3>1.取值</h3>
	<c:set var="name" value="${ 'Toyz' }" scope="request" />
	通过标签获取：<c:out value="${ name }" /><br>
	通过EL获取：${ name }
	
	<!-- 2.获取JavaBean属性 -->
	<h3>2.获取JavaBean属性</h3>
	<%
		Hero hero = new Hero();
		hero.setName("Tooyz");
		hero.setDamage(100);
		request.setAttribute("hero", hero);
	%>
	英雄姓名：${ hero.name } <br>
	英雄攻击力：${ hero.damage }
	
	<!-- 3.EL结合forEach -->
	<h3>3.EL结合forEach</h3>
		<%
			List<String> heros = new ArrayList();
			heros.add("A");
			heros.add("B");
			heros.add("C");
			request.setAttribute("heros", heros);
		%>
		<table width="200px" align="center" border="1" cellspacing="0">
		<tr>
			<td>序号</td>
			<td>名称</td>
		</tr>
		<c:forEach items="${ heros }" var="hero" varStatus="st">
			<tr>
			<td>${ st.count }</td>
			<td>${ hero }</td>
		</tr>
		</c:forEach>
		</table>
	
	<!-- 4.EL表达式eq的用法 -->
	<h3>4.EL表达式eq的用法</h3>
	<%
		request.setAttribute("killNumber", "10");
	%>
	EL表达式eq的用法,运行结果为：${ killNumber ge 10? "超神":"没超神" }
	
	
</body>
</html>