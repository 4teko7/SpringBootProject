
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO LIST</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
		<h2> ALL TODOS </h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		
		
		
		<c:forEach items="${todos}" var="item">
		<c:url var = "deleteLink" value="/todos/deletetodo">
			<c:param name="id" value="${item.id}" />
		</c:url>
		<c:url var = "updateLink" value="/todos/updatetodo">
			<c:param name="id" value="${item.id}" />
		</c:url>
			    ${item}
			    <a href="${updateLink}" >Update</a>
			    <a href="${deleteLink}" onclick="if (! (confirm ('Are You Sure ?'))) return false">Delete</a><br>
			    
			</c:forEach>
			
			
		
		</div>
		
		<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/todos/addtodo">Add Todo</a>
				<a href="${pageContext.request.contextPath}/users/users">Users</a>
			</p>
	</div>
</body>
</html>