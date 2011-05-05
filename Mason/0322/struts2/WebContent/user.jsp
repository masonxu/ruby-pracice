<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script type="text/javascript">
	function logout() {
		window.location = "";
	}
</script>
</head>
<body>
	<div align="center">
	   <p>Hi,<h2>Mason</h2> Welcome to Augmentum.</p>
	   <input type="button" name="logout" value="logout" onclick="logout();"/>
	</div>
</body>
</html>