<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Group</title>
</head>
<body>
	<form action="creategroup.action" method="post">
	
		
		<input type="text" name="name" placeholder ="Group Name" />
		<br />
		<textarea name="description"></textarea><br />
		<input type="hidden" name="hidden" value="0"/>
		<input type="submit" value="Create Group"/>


	</form>
	
</body>
</html>