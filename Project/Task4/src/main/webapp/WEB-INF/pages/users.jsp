<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
   table {
    border-collapse: collapse;
   }
   td, th {
    padding: 3px;
    border: 1px solid #000;
   }
   th {
    background: #afd792;
    color: #333;
   }
   tbody tr:hover {
    background: #f3bd48;
    color: #fff;
   }
  </style>
</head>
<body>
<h3>
	<table border="2" align="center" cellpadding="2">
		<tr>
			<td>userID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Email</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		<c:forEach items="${message}" var="user">
	    <tr>
	    <form action="users" method="post">    
	        <td>
	        	${user.userID}
	        	<input type="hidden" name="id" value="${user.userID}" />
	        </td>
	        <td>${user.firstName}</td>
	        <td>${user.lastName}</td>
	        <td>${user.email}</td>
	        <td><input type="submit" value="Edit" name="action"></td>
	        <td>
	        	<input type="submit" value="Delete" name="action">
	        </td>
	    </form>
	    </tr>
		</c:forEach>
		<tr>
		<form action="users" method="post">
			<td>
			<c:if test="${isEdit == false}">
				<input type="submit" value="Add" name="action">
			</c:if>
			<c:if test="${isEdit == true}">
				<input type="submit" value="Save" name="action">
			</c:if>
			<input type="hidden" name="idEdit" value="${idEdit}" />
			</td>
			<td><input type="text" name="fname" size="20" value="${editFname}"></td>
			<td><input type="text" name="lname" size="20" value="${editLname}"></td>
			<td><input type="text" name="email" size="20" value="${editEmail}"></td>
			<td></td>
			<td></td>
		</form>
		</tr>
	</table>
</h3>
</body>
</html>