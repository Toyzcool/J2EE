<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
   
    <!-- 引入使用的JSTL标签库 -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<!-- 引入使用的JSTL标签库,fmt常用于格式化数字 -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>

	<!-- 1.赋值和输出值的方法 -->
	<h3>1.赋值和输出值的方法</h3>
		<!-- 在request作用域中设置值 -->
		<c:set var="name" value="${'JSTLName'}" scope="request" />
		
		<!-- 输出在request中的值 -->
		通过标签获取name:<c:out value="${name}" />
	
	<!-- 2.if逻辑判断 -->
	<h3>2.if逻辑判断</h3>
		<c:set var="hp" value="${10}" scope="request" />
		<!-- if判断 -->
		<c:if test="${hp < 5 }" >
			<p> 英雄血量较低 </p>
		</c:if>
		<c:if test="${!(hp < 5) }">
			<p> 英雄血量健康 </p>
		</c:if>
		
		<%
			pageContext.setAttribute("weapon", null);
		%>
		<c:if test="${empty weapon }">
			<p> 英雄没有武器 </p>
		</c:if>
	
	<!-- 3.choose逻辑判断 -->
	<h3>3.choose逻辑判断</h3>
		<c:set var="hp" value="${8}" scope="request" />
		<c:choose>
			<c:when test="${ hp == 10 }"> <p>英雄满血</p> </c:when>
			<c:when test="${ hp == 9 }"> <p>英雄高血量</p> </c:when>
			<c:when test="${ hp == 1 }"> <p>英雄血量不足</p> </c:when>	
			<c:otherwise><p>英雄血量未知</p></c:otherwise>
		</c:choose>
	
	<!-- 4.forEach -->
	<h3>4.forEach</h3>
	<%
		List<String> heros = new ArrayList();
		heros.add("塔姆");
		heros.add("伊泽瑞尔");
		heros.add("薇恩");
		request.setAttribute("heros", heros);
	%>
	<table width="200px" align="center" border="1" cellspacing="0">
		<tr>
			<td>英雄</td>
			<td>编号</td>
		</tr>
		<c:forEach items="${ heros }" var="hero" varStatus="st" >
		<tr>
			<td> <c:out value="${ st.count }" /></td>
			<td> <c:out value="${ hero }" /></td>
		</tr>
		</c:forEach>
	</table>
	
	<!-- 5.fmt格式化数字 -->
	<h3>5.fmt格式化数字</h3>
	<c:set var="money" value="10" />
	<c:set var="pi" value="23.12121" />
	原数字为10,最少两个小数点：<fmt:formatNumber type="number" value="${ money }" minFractionDigits="2" ></fmt:formatNumber>
	<br>
	原数字为23.12121,最多两个小数点：<fmt:formatNumber type="number" value="${ pi }" maxFractionDigits="2" ></fmt:formatNumber>
	
	<!-- 6.fmt格式化日期 -->
	<h3>6.fmt格式化日期</h3>
	<%
		Date now = new Date();
		pageContext.setAttribute("now", now);
	%>
	<fmt:formatDate value="${ now }" pattern="YYYY年MM月dd日" />
	
	
</body>
</html>