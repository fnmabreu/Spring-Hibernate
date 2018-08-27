<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Customer Registration Form</title>
	<style>
		.error {color: red}
	</style>
</head>
<body>
	<i>Fill out the form. Asterisk (*) means required.</i>
	<form:form action="processForm" modelAttribute="customer">
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name (*):</td>
				<td>
					<form:input path="lastName" />
					<form:errors path="lastName" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Free Passes:</td>
				<td>
					<form:input path="freePasses" />
					<form:errors path="freePasses" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Postal Code:</td>
				<td>
					<form:input path="postalCode" />
					<form:errors path="postalCode" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Course Code:</td>
				<td>
					<form:input path="courseCode" />
					<form:errors path="courseCode" cssClass="error" />
				</td>
			</tr>
			<br><br>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>