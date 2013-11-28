<%@page import="org.apache.tomcat.util.http.mapper.MappingData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="assets/plugins/multi-select/css/multi-select.css"/>

</head>
<body>


<form action="" method="post">

	
	<s:select list="groups"
			  name="selectedGroup"
			  title="Select Group"
	/>

	<s:select list="trainees"
			  name="trainee_set"
			  title="Select Trainees"
			  multiple="true"
			  id="mult"
	/>
	<input type = "hidden" name="hidden" value="0" />
	<button type = "submit" id = "btn">Submit</button>
	
</form>
<%@ include file="../includes/footer-js.jsp" %>
<script type="text/javascript" src="assets/plugins/multi-select/js/jquery.multi-select.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	
	$("#mult").multiSelect();
	
	
});

	
	
	

</script>


</body>
</html>