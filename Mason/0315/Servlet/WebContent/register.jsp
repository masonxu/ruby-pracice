<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register</title>
</head>
<body>

<input type="hidden" id="result" value=<%= request.getParameter("result")%>>
<form name="form" action="OnlineServlet?type=register"  onsubmit="return check(this);" method="post">
<table align= center>
<tr>
<td colspan="2" align=center> 
	<h3>Please input your userName and password!</h3>
</td>
</tr>
<tr> 
	<td>UserName: </td>
	<td><input type="text" id="userName" name="userName"> </td>
</tr>
<tr> 
	<td>Password: </td>
	<td><input type="password" id="password" name="password"> </td>
</tr>
<tr> 
	<td colspan="2" align=center> 
		<input type="submit" name="submit" value="submit" /> 
	</td>
</tr>
</table>
</form>
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
function result() {
	var type = document.getElementById("result").value;
	if(type == "ok") {
		alert("ok");
		window.close();
	} else if (type == "failure"){
		alert("failure");
	}
}

onload = result;
</script>
</html>