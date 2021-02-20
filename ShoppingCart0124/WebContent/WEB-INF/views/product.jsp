<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="pb" class="useBean.productBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Home </title>
<script src="/ShoppingCart0124/resources/js/jquery3.5.1.min.js"></script>
<style type="text/css">
    .pos_right1{ position:relative; left:350px; }
    .font1{font-size : 0.5cm}
</style>
</head>
<body>
<%
pb.setPidStr(request.getParameter("pid"));
pb.readProductData();
%><br>
<table border="1">
<tr>
<td style="width: 280px; vertical-align:top">
<br>商品:&nbsp;<%=pb.getProductName() %><p>
購買數量:&nbsp;<input type="text" id="qty" value="1" size = "1" />
</td>
<td>
   <img  src = '<%=pb.getImagePath() %>' width="480" height="270"/>
 </td>
</tr>
</table><p>
<button id = "butt1">購買</button>
<script>
$(document).ready(function(){
	$("#butt1").addClass("font1").addClass("pos_right1");
});
</script>
</body>
</html>