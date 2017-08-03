<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient's Menu</title>
<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css" />  
</head>
<body>

		<div id="wrapper">
		<div id="header">
				<h1>PIM - Patient's Information Menu</h1>
		</div>
		
		<div id="container">
			<div id="content">		
			
			
			<!-- Add a search box -->
			<form:form action="search" method="POST">
				Search Patient: <input type="text" name="theSearchName" />
				
				<input type="submit" value="Search" class="add-button effect" />
				
						
				<!-- put a new button: Add Patient -->
				<input type="button" value="New Patient"
					onClick="window.location.href='showFormForAdd'; return false;"
					class="add-button effect"			
				/>
				
				<!-- put a new button: Display All Patients -->
				<input type="button" value="Full List"
					onClick="window.location.href='list'; return false;"
					class="add-button effect"			
				/>
			
			</form:form>			
							
		
					
			<!-- add out html table here -->			
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Address</th>	
						<th>City</th>	
						<th>State</th>
						<th>Zip </th>
						<th>Phone No.</th>						
						<th>Email</th>	
						<th>DOB</th>
						<th>Reason for Visit</th>
						<th>Allergies</th>
						<th>Employment Status</th>	
						<th>Visit Date</th>
						<th>Edit</th>				
					</tr>	
					
					
					<!-- loop over and print patients -->
					<c:forEach var="tempPatient" items="${patients}">
						<!-- Construct an "update" link with patient id -->
						<c:url var="updateLink" value="/patient/showFormForUpdate">
							<c:param name="patientID" value="${tempPatient.patientID}" />
						</c:url>
						
					<!-- Construct a "delete" link with patient id -->
					<c:url var="deleteLink" value="/patient/delete">
						<c:param name="patientID" value="${tempPatient.patientID}" />
					</c:url>
						
						
						<tr>
							<td class="right"> ${tempPatient.firstName}</td>
							<td class="right"> ${tempPatient.lastName}</td>
							<td class="right"> ${tempPatient.address}</td>
							<td class="right"> ${tempPatient.city}</td>
							<td class="right"> ${tempPatient.state}</td>
							<td class="right"> ${tempPatient.zip}</td>
							<td class="right"> ${tempPatient.phone}</td>
							<td class="right"> ${tempPatient.email}</td>
							<td class="right"> ${tempPatient.dob}</td>
							<td class="right"> ${tempPatient.reason}</td>
							<td class="right"> ${tempPatient.allergies}</td>
							<td class="right"> ${tempPatient.empStatus}</td>
							<td class="right"> ${tempPatient.visitDate}</td>
							<td class="right">
								<!-- display the update and delete link -->
								<a href="${updateLink}">Update</a> 
								<br>
								<a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to remove this patient?'))) return false"								
								>Delete</a>
							</td>										
						</tr>		
					</c:forEach>		
						
							
				</table>				
			</div>		
		</div>	
	</div>

</body>
</html>