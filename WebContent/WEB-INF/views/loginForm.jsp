<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
 <script type="text/javascript">
	window.history.forward();
</script>
</head>
<body>
<h2>Login Form</h2>
		<form:form method="POST" action="./save.html">
	   		<table>
			    <tr>
			        <td><form:label path="username">User name:</form:label></td>
                    <td><form:input path="username" /></td>
                    <td><div style="color:red"><form:errors path="username" cssClass="error" /></div></td>
			    </tr>
			    <tr>
			        <td><form:label path="password">Password:</form:label></td>
                    <td><form:password path="password" /></td>
                    <td><div style="color:red"><form:errors path="password" cssClass="error" /></div></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
</body>
</html>