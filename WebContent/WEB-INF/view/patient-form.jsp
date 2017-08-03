<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Patient</title>
		<link rel="stylesheet" 
		  type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/style.css">
		<link rel="stylesheet" 
		  type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/add-patient-style.css">
</head>
<body>

	<div id="wrapper">
			<div id="header">
				<h2>PIM - Patient's Information Menu</h2>				
			</div>
	</div>

		<div id="container">
			<h3>Patient's Information</h3>

			<form:form action="savePatient" modelAttribute="patient" method="POST">
			
				<form:hidden path="patientID"/>

				<table>
					<tbody>
						<tr>
							<td><label>First Name:</label></td>
							<td><form:input path="firstName" cssClass = "test"/></td>
							<td><form:errors path="firstName" cssClass="error" /></td>
						</tr>
						
						<tr>
							<td><label>Last Name:</label></td>
							<td><form:input path="lastName" /></td>
							<td><form:errors path="lastName" cssClass="error" /></td>
							
						</tr>
						
						<tr>
							<td><label>Address:</label></td>
							<td><form:input path="address" /></td>
							<td><form:errors path="address" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>City:</label></td>
							<td><form:input path="city" /></td>
							<td><form:errors path="city" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>State:</label></td>
							<td><form:input path="state" /></td>
							<td><form:errors path="state" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Zip Code:</label></td>
							<td><form:input path="zip" /></td>
						</tr>
						<tr>
							<td><label>Phone Number:</label></td>
							<td><form:input path="phone" /></td>
						</tr>
						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<td><label>Date of Birth: yyyy-mm-dd</label></td>
							<td><form:input path="dob" /></td>
						</tr>
						<tr>
							<td><label>Reason for Visit:</label></td>
							<td><form:input path="reason" /></td>
						</tr>
						<tr>
							<td><label>Allergies:</label></td>
							<td><form:input path="allergies" /></td>
						</tr>
						<tr>
							<td><label>Employment Status:</label></td>
							<td><form:input path="empStatus" /></td>
						</tr>		
						
						<tr>
							<td><label>Visit Date: yyyy-mm-dd</label></td>
							<td><form:input path="visitDate" /></td>
						</tr>							
						
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save effect"/></td>
						</tr>
					</tbody>
				</table>				
			</form:form>
			
			<div style="clear:both"></div>
			<p> 
				<a href="${pageContext.request.contextPath}/patient/list">Back to List</a>
			</p>
		</div>

</body>
</html>