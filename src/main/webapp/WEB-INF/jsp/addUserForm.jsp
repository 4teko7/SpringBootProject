<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!--     Bootstrap CSS
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
 -->
	
	<title>Add User</title>	  
</head>
<body>
	<div id = "container" style = "margin:auto;">
		<div id="wrapper">
			<div id="header">
				<h2>Add User Form</h2>
			</div>
		</div>
	
		
		<div id="container" style = " align-items: center;">
			<h3>Save User</h3>
		
			<form:form action="adduser" modelAttribute="user" method="POST">
	  			<form:hidden path="id" />
		        <table >    
			         <tr>    
			          <td>Firstname : </td>   
			          <td><form:input path="firstname"  /></td>  
			         </tr>    
			         <tr>    
			          <td>Lastname :</td>    
			          <td><form:input path="lastname" /></td>  
			         </tr>  
			         
			         <tr>    
			          <td>Password :</td>    
			          <td><form:input path="password" /></td>  
			         </tr> 
			         
			         <tr>    
			          <td>Username :</td>    
			          <td><form:input path="username" required="required"/></td>  
			         </tr>  
			         <tr>    
			          <td>Age :</td>    
			          <td><form:input path="age" /></td>  
			         </tr>  
			         <tr>    
			          <td>School :</td>    
			          <td><form:input path="school" /></td>  
			         </tr>  
			         <tr>    
			          <td>Department :</td>    
			          <td><form:input path="department" /></td>  
			         </tr>   
			         
			         <tr>    
			          <td colspan="2"><input type="submit" value="Save" /></td>    
			         </tr>    
		        </table>    
	       </form:form> 
	       
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/users/users/">Go Users</a>
			</p>
		</div>

		  
	</div>

</body>


<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
 -->

</html>