<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Submission Form</title>
</head>
<body>
	<h1> Student Admission Form For Engineering Courses</h1>
	<form action="/FirstSpringMVCProject/submitAdmissionForm.html" method="post">
		<p>
			Student Name : <input type="text" name="studentName"/> 		
		</p>
		<p>
			Student Hobby : <input type="text" name="studentHobby"/> 		
		</p>
		<input type="submit" value="submit this form by clicking here" />
		
	</form>
</body>
</html>