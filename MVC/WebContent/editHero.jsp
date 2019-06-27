<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Hero</title>
</head>
<body>
	<div class="panel panel-default">
	  <div class="panel-body">
	    <form action="updateHero" method="post">
	        name:<input name="name" value="${hero.name}" class="form-control"><br>
	        hp:<input name="hp" value="${hero.hp}" class="form-control"><br>
			damage:<input name="damage" value="${hero.damage}" class="form-control"><br>
	        <input type="hidden" name = "id" value="${hero.id}">
	        <input type="submit" value="提交" class="btn btn-success">
	    </form>
	  </div>
	</div>
</body>
</html>