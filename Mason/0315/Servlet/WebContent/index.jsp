<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome you!</title>
</head>

<body>

<table align=center>
<form name="form2" action="OnlineServlet?type=login"  onsubmit="return check(this);" method="post">
<tr>
<td colspan="2" align=center> 
	<h1>Welcome you!</h1>
</td>
</tr>
<tr> 
	<td>UserName: </td>
	<td><input type="text" id="userName" name="userName"> </td>
</tr>
<tr> 
	<td>Password: </td>
	<td><input type="password" id="password" name="password"> <a href="register.jsp">Register</a></td>
</tr>
<tr> 
	<td colspan="2" align=center>
		<input type="submit" name="login" value="login"/>
		<% if (request.getParameter("result")!=null){ %>
			<%=request.getParameter("result")%>
		<% }%>
	</td>
</tr>
</form>
</table>
</body>
<script>
function check() {
	var userName = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	if(userName == "") {
		alert("please input userName.");
		return false;
	} 
	if(password == "") {
		alert("please input password.");
		return false;
	}
}

</script>
</html>