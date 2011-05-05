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
	// the list is used for show the query result.
	List<Map<String,String>> result = 
			      	(List<Map<String,String>>)request.getAttribute(Const.RESULT);
	
	List<String> list = new ArrayList<String>();
	if ((result != null) && (result.size() != 0)) {
		for(String s : result.get(0).keySet()) {
			list.add(s);
		}
	}	
%>
<div >

<!-- textarea for inputting sql -->
<!-- Begin -->
<h2>Please input sql and commit.</h2>
	<form id="form1" action="mysql?type=commit" onsubmit="return check(this);" method="post">
		<table>
			<tr>
				<td>
					<textarea id="sql" name="sqlString" rows="6" cols="60"></textarea>
					<input type="submit" name="commit" value="commit" />
				</td>
			</tr>
		</table>
	</form>
<!-- End -->
<!-- Show the query result  -->
<!-- Begin -->
<table border="1">
	<tr>
	
	<% for(String s : list) { %>
		<td><%=s %></td>
	<%} %>
	</tr>
	
	<%
		if(result != null) {
			for(Map m : result) {%>
				<tr>
					<% for(int i=0; i<m.size(); i++) {%>
						<td><%=m.get(list.get(i)) %></td>				
					<%} %>
				</tr>
			<%}%>
		<%}%>
		
</table>
	
	<% if((result != null) && (request.getAttribute(Const.ERROR_TYPE) == null)){ %>
		<font color=red>Empty set.</font>
	<% } else if (request.getAttribute(Const.ERROR_TYPE) != null) {%>
		<font color=red><%=request.getAttribute(Const.ERROR_TYPE) %></font>
		
	<% }%>
<!-- End -->
</div>

</body>
<script type="text/javascript">
function check() {
	var textarea = document.getElementById("sql");
	if(textarea.value == "") {
		alert("The sql is not blank. please input sql.")
		return false;
	}
}
</script>
</html>