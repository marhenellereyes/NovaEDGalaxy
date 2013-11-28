<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Groups</title>

<%@ include file="../includes/header-css.jsp" %>

</head>
<body>

<%@ include file="../includes/header-top.jsp" %>
<%@ include file="../includes/header.jsp" %>


<div class="panel-group acc-v1" id="accordion-1">
	
	
	<s:iterator value="groups"><br>
		
		
	
	
			<div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion-1" href="#collapse-One-<s:property value='name' />">
                                <s:property value="name" />
                            </a>
                        </h4>
                    </div>
                    <div id="collapse-One-<s:property value='name' />" class="panel-collapse collapse" style="height: auto;">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-4">
                                    <img class="img-responsive" src="assets/img/new/img5.jpg" alt="">
                                </div>
                                <div class="col-md-8">
                                    <s:iterator value="students"><br>
										<s:property value="firstName"/>
									</s:iterator>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
	</s:iterator>
		

</div>







<%@ include file="../includes/footer.jsp" %>
<%@ include file="../includes/footer-copyright.jsp" %>
<%@ include file="../includes/footer-js.jsp" %>

</body>
</html>