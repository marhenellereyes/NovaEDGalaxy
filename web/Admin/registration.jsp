<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>	
	<s:form action="register.action" method="post">
		<s:textfield label="First Name" key="firstname"/>
		<s:textfield label="Last Name" key="lastname"/>
		<s:textfield label="School" key="school"/>
		<s:textfield label="Contact Number" key="contactno"/>
		
		<s:select label="User Type" 
				headerKey="-1" 
				headerValue="Select User Type"
				list="userTypeList" 
				name="userType"
				/>
				
		<s:textfield label="Username" key="username"/>		
		<s:password label="Password" key="password"/>
		<s:hidden key="hidden" value="0"/>
	
		<s:submit value="Register"/>
	</s:form>
</body>
</html>