<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.augmentum.training.jdbc.*"%>
<%@page import="com.augmentum.training.entity.*" %>
<%@page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome you!</title>
</head>

<body>
<%
	// the list is used for viewing the table field and type.
	List<FieldInfo> list =(List<FieldInfo>)request.getAttribute(Const.TABLE_INFO);
%>

		<table align=left border="1">
			<tr>
				<td colspan="3" align=center>
				<h3>The infomation of <%= request.getAttribute(Const.TABLE_NAME) %></h3>

				</td>
			</tr>
			<tr> 
				<th>COLUMN_TYPE</th>
				<th>DATA_TYPE</th>
				<th>REMARKS</th>
			</tr>
	
			<% for(FieldInfo f: list) {%>
			<tr>
     	  		<td><%=f.getColumnName()%></td>
     	 	 	<td><%=f.getTypeName()%></td>
      	 		<td><%=f.getRemarks()%></td>
   			 </tr>
   			 <%} %>
	
		</table>



</body>

</html>