<%@page import="com.ncit.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User</title>
</head>
<body>

	<link rel="stylesheet" href="css/style.css">

	<style>
body {
	color: white;
}
</style>
</head>
<body>

	<section class="about"> <%
 	User user = (User) request.getAttribute("User");
 %>

	<h1>Update Here</h1>

	</section>

	<form action="doUpdate" method="POST" class="login">
		<table>
			<tr>
				<td>Name </td>
				<td><input type="text" class="login-input" name="name"
					value="<%=user.getUserName()%>" /></td>
			</tr>

			<tr>
				<td>Address&nbsp;&nbsp;</td>
				<td><input type="text" class="login-input" name="address"
					value="<%=user.getAddress()%>" /></td>
			</tr>

			<tr>
				<td>Email </td>
				<td><input type="text" class="login-input" name="email"
					value="<%=user.getEmail()%>" /></td>
			</tr>

			<input type="hidden" class="login-input" name="id"
				value="<%=user.getId()%>" />
			<tr>
				<td colspan="2"><input type="submit" class="login-submit"
					value="Update" /></td>
			</tr>
		</table>

	</form>

</body>
</html>