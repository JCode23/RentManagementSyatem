<%@page import="com.ncit.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<section class="about"> <%
 	List<User> userList = (List<User>) request.getAttribute("allUserList");
 %>

	<h1>View All Users</h1>
	<h2>
		Total Users:
		<%=userList.size()%></h2>
		
		
	</section>


	<!-- Create a table format -->

<section class="table">

	<table>
		<tr>
			<td>&nbsp;ID&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;NAME&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;EMAIL&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;ADDRESS&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;ACTIONS&nbsp;&nbsp;</td>
		</tr>

		<%
			for (int i = 0; i < userList.size(); i++) {
				User user = userList.get(i);
		%>

		<!-- In a loop -->
		<tr>
			<td>&nbsp;<%=user.getId()%>&nbsp;&nbsp;
			</td>
			<td>&nbsp;&nbsp;<%=user.getUserName()%>&nbsp;&nbsp;
			</td>
			<td>&nbsp;&nbsp;<%=user.getEmail()%>&nbsp;&nbsp;
			</td>
			<td>&nbsp;&nbsp;<%=user.getAddress()%>&nbsp;&nbsp;
			</td>
			<td>&nbsp;&nbsp;<a href="doEdit?id=<%=user.getId()%>">Edit</a>&nbsp;/&nbsp;<a href="doDelete?id=<%=user.getId()%>">Delete</a></td>
		</tr>
		<%
			}
		%>
		<!-- End of loop -->
	</table>
</section>
</body>
</html>