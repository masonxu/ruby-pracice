<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page import="com.augmentum.training.jdbc.*"%>
<%@page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome you!</title>
</head>

<body>
<%
	DataBaseManager dm = (DataBaseManager)request.getAttribute(Const.DATA_BASE_MANAGER);
	List<String> list = dm.getTableList();
%>
<div>
	<h4>If you want to see the table's information, 
		please click corresponding link.</h4>
</div>
<table align=left border="1">
<tr> 
	<th>Table Name</th>
</tr>
<% for(String s : list) {%>
	<tr><td>
		<a href="/jdbc/mysql?type=view&tablename=<%=s %>"><%=s %></a>
	</td></tr>
<%} %> 
</table>
<h1><a href="/jdbc/query.jsp">Execute SQL!</a><h1>

</body>

</html>