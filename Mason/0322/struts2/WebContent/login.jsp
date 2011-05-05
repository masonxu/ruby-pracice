<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

</head>
<body>
	<div align="center">
		<center><s:text name="welcome"/></center>
		<form name="form1" action="login.action" onsubmit= "return validate(this)" method="post">
		<table>
			<tr>
				<td>
					<s:text name="username"/>
				</td>
				<td>
					<input id="username" type="text" name="username"/>
				</td>
			</tr>
			<tr>
				<td>
					<s:text name="password"/>
				</td>
				<td>
					<input id="password" type="password" name="password"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="submit" value="submit" />
				</td>
			</tr>
		</table>
		</form>
			<font color="red">
			<s:property value="error"/>
			</font>
	</div>
</body>
<script type="text/javascript">
	function validate() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if (username == "") {
			alert("please input your usernmae!");
			return false;
		} 
		if (password == "") {
			alert("please input your password!");
			return false;
		}
	}
</script>
</html>