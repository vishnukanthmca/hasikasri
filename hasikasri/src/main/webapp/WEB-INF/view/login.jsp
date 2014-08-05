<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Hasikasri</title>
</head>
<body>
	<form:form method="post" action="home">
		<h1>Hello, ${welcomeUser.username}!</h1>
		<form:label path="username">username : </form:label>
		<form:input path="username" />
		<form:label path="password">password: </form:label>
		<form:password path="password" />
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>