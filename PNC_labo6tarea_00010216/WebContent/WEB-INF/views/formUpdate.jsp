     
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new user</title>
</head>
<body>
	<form:form action = "${pageContext.request.contextPath}/formData" method = "POST" modelAttribute = "student">
	<label>Name: </label>
	<form:input type = "text" placeholder = "${rstudent.sName}" name = "name" path = "sName"/><br>
	
	<label>Last name: </label>
	<form:input type = "text"  placeholder = "${rstudent.lName}" name = "lname" path = "lName"/><br>
	
	<label>Age: </label>
	<form:input type = "text"  placeholder = "${rstudent.sAge}" name = "age" path = "sAge"/><br>
	
	<Label>Student status</Label><br>
	<form:radiobutton checked = "${rstudent.bActivo}" name = "status" path="bActivo" value = "true"/><label>Active</label><br> 
	<form:radiobutton  checked = "${rstudent.bActivo}"  name = "status" path="bActivo" value = "false"/><label>Inactive</label><br> 
	
	<input type = "submit" value = "Update">
	</form:form>
</body>
</html>