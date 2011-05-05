<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.augmentum.training.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register</title>
</head>
<body>
<%
	Map<String,User> map = UserManagerFactory.getUserManager().getUserMap();
	User user = map.get(request.getParameter("userName"));
	List<User> userList = UserManagerFactory.getUserManager().getOnlineList();
	int number = userList.size();
%>
<table>
<form name="form2" action="OnlineServlet?type=exit"  method="post"><tr>
	<input type="hidden" id="result" name="userName" value= <%=user.getUserName()%>></input>
		<td align=center> 
			<input type="submit" name="exit" value="exit"></input></td>
		</tr>
</form>
</table>

<h3>Your information.</h3>
	<table align=center border="1">	
		<tr>
			<td> UserName:</td>
			<td><%=user.getUserName()%></td>
		</tr>
		<tr>
			<td> The last online time:</td>
			<td><%=user.getLastOnlineTime().getTime()%></td>
		</tr>
		<tr>
			<td> The login times:</td>
			<td><%=user.getLoginTimes()%></td>
		</tr>
		<tr>
			<td> The number of online:</td>
			<td><%=number%></td>
		</tr>

	</table>
	<h3>The online situation:</h3>	
	<table align=center border="1" >  
		<tr>
			<td>UserName</td>
			<td>the login times</td>
		</tr>
		
	<% for(User u: userList) {%>
		<tr>
			<td><%= u.getUserName() %></td>
			<td><%= u.getLoginTimes() %></td>
		</tr>
	<%} %>
	</table>
</body>
<script>
function exit() {
	
}
</script>
</html>