<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Hero</title>
</head>

<script>
$(function(){
    $("a").addClass("btn btn-default btn-xs");
     
});
</script>

<body>
	<!-- 1.数据展示表格模块  -->
	<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
		<tr>
			<td style="width:50px;">序号</td>
			<td style="width:150px;">名称</td>
			<td style="width:100px;">血量</td>
			<td style="width:100px;">输出</td>
			<td>edit</td>
			<td>delete</td>
		</tr>
		<c:forEach items="${ heros }" var="hero" varStatus="st">
			<tr>
				<td>${ hero.id }</td>
				<td>${ hero.name }</td>
				<td>${ hero.hp }</td>
				<td>${ hero.damage }</td>
				<td><a href="editHero?id=${ hero.id }">edit</a></td>
				<td><a href="deleteHero?id=${ hero.id } ">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 2.数据表格切换模块  -->
	<nav>
	    <ul class="pager">
		<!-- ？代表在当前页面传递参数 -->
		<!-- a标签的href属性不能带空格 -->
	      <li><a href="?start=0">首  页</a></li>
	      <li><a href="?start=${pre}">上一页</a></li>
	      <li><a href="?start=${next}">下一页</a></li>
	      <li><a href="?start=${last}">末  页</a></li>
	    </ul>           
  	</nav>
  	
  	<!-- 3.数据添加模块  -->
	<div style="margin:10px auto; width:300px">
		<form action="addHero" method="post">
			名字：<input name="name" class="form-control"><br>
			血量：<input name="hp" class="form-control"><br>
			伤害：<input name="damage" class="form-control"><br><br>
			<input type="submit" value="添加" class="btn btn-success">
		</form>
	</div>
	
	<!-- 在线人数统计 -->
	<div style="margin:10px auto; width:300px">
		当前 在线人数 ： ${online_number}
	</div>
</body>
</html>