<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>
					<form:select path="country">
						<form:options items="${theCountryOptions}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Favorite Language:</td>
				<td>
				 	<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}" />
				</td>
			</tr>
			<tr>
				<td>Operating Systems:</td>
				<td>
				 	Linux <form:checkbox path="operatingSystems" value="Linux" />
				 	MacOS <form:checkbox path="operatingSystems" value="MacOS" />
				 	Windows <form:checkbox path="operatingSystems" value="Windows" />
				</td>
			</tr>
			<br><br>
			<tr>
				<td colspan="2"><input type="submit" value="Save Changes" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>