
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER LIST</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
		<h2> ALL USERS </h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		
		
		
		<c:forEach items="${users}" var="user">
		
				<c:url var = "deleteLink" value="/users/deleteuser">
					<c:param name="id" value="${user.id}" />
				</c:url>
				<c:url var = "updateLink" value="/users/updateuser">
					<c:param name="id" value="${user.id}" />
				</c:url>
			
			    ${user}
			    
			<a href="${updateLink}" >Update</a>
			    <a href="${deleteLink}" onclick="if (! (confirm ('Are You Sure ?'))) return false">Delete</a><br>

			</c:forEach>
			
			
		
		</div>
		
		
			
	</div>
	<br>
				<div style="clear; both;"></div> 
	
				<a href="${pageContext.request.contextPath}/users/adduser">Add User</a>
				<a href="${pageContext.request.contextPath}/users/registration">Registration</a>
				<a href="${pageContext.request.contextPath}/users/login">Login</a>
				<a href="${pageContext.request.contextPath}/todos/todos">Todos</a>
		
</body>
</html>