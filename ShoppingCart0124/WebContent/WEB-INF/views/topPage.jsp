<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Home</title>
<script src="/ShoppingCart0124/resources/js/jquery3.5.1.min.js"></script>
<style>
h1.pos_right
{ position:relative; left:550px; }
</style>
</head>
<body>
<br><h1>歡迎光臨 OO市集</h1>
<img id="pic1" src="#" width="720" height="405" /><p>
<a href="/ShoppingCart0124/productTable"><h1 class = "pos_right" >進入商場</h1></a>
		<script>
			var count = 0;

			window.setInterval(function() {
				count++;
				$.get("/ShoppingCart0124/PictureServlet", {
					"id" : count
				}, function(path) {
					$("#pic1").attr("src", path);
				});
			}, 3000);
		</script>
</body>
</html>