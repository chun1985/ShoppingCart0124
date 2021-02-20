<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
<form action = "/ShoppingCart0124/product" method = "get">
<br>購買&nbsp;<select name = "pid">
 <c:forEach  var="current"  items="${message}" >        
          <option value='<c:out value="${current.pid}" />'>
          <c:out value="${current.productname}" /></option>                     
</c:forEach>
 </select>
 <input type = "submit" value = "選擇">
</form><p>
	<table border="1">
		<th>Product ID</th>
		<th>Product Name</th>
		<th>Product price</th>
		<th>Product image</th>
		<c:forEach items="${message}" var="product">
			<tr>
				<td align = "center" >${product.pid}</td>
				<td align = "center" >${product.productname}</td>
				<td align = "center" >${product.price}</td>
				<td><img src='${product.imagepath}'  width="320" height="180" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>