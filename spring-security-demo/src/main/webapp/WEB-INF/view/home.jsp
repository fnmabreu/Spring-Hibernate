<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Omega Company Home Page</title>
</head>

<body>
	<h2>Omega Company Home Page</h2>
	<hr>

	<p>Welcome to the Omega Company Home Page!</p>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</body>

</html>