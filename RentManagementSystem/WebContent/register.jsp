<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Here</title>

<link rel="stylesheet" href="css/style.css">

<style>
body {
        color: white;
}
</style>


</head>
<body>

<section class="about">

	<h1>Register Here</h1>
	
	</section>

	<form action="doRegister" method="POST" class="login" autocomplete="on">
		<table>
			<tr>
				<td>Name </td>
				<td><input type="text" class="login-input"
					placeholder="Username" name="name" /></td>
			</tr>

			<tr>
				<td>Address </td>
				<td><input type="text" class="login-input"
					placeholder="address" name="address" /></td>
			</tr>

			<tr>
				<td>Email </td>
				<td><input type="text" class="login-input" autocomplete="off" placeholder="email"
					name="email"   /></td>
			</tr>

			<tr>
				<td>Password &nbsp; </td>
				<td><input type="password" class="login-input"
					placeholder="password" name="pass" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" class="login-submit"
					value="Register" /></td>
			</tr>
		</table>

	</form>


</body>
</html>