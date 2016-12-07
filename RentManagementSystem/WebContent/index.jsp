<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rent Management System</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<section class="about">

	<h1>Login here</h1>

	<p>
		<%
			String message = (String) request.getAttribute("message");
		%>
	</p>
	<p><%=message%></p>



	</section>

	<form action="doLogin" method="POST" class="login">
		<input type="text" class="login-input" placeholder="Username"
			name="user"> <input type="password" class="login-input"
			placeholder="Password" name="pass"> <input type="submit"
			class="login-submit" value="Login">

		<p class="login-help">
			<a href="index.jsp">forgot password?</a>
		</p>
		<p class="login-help">
			<a href="register.jsp">Register here</a>
		</p>
	</form>


</body>
</html>