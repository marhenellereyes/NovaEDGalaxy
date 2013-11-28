<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>


<%@include file="includes/header-css.jsp" %>
<link rel="stylesheet" href="assets/css/pages/page_log_reg_v1.css">

</head>
<body>

<%@include file="includes/header-top.jsp" %>
<%@include file="includes/header.jsp" %>



	<!--=== Breadcrumbs ===-->
<div class="breadcrumbs margin-bottom-40">
    <div class="container">
        <h1 class="pull-left">Login</h1>
        <ul class="pull-right breadcrumb">
            <li><a href="index-2.html">Home</a></li>
            <li><a href="#">Pages</a></li>
            <li class="active">Login</li>
        </ul>
    </div><!--/container-->
</div><!--/breadcrumbs-->
<!--=== End Breadcrumbs ===-->

<!--=== Content Part ===-->
<div class="container">		
	<div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
            <form class="reg-page" action = "login.action" method="post" >
                <div class="reg-header">            
                    <h2>Login to your account</h2>
                </div>

                <div class="input-group margin-bottom-20">
                    <span class="input-group-addon"><i class="icon-user"></i></span>
                    <input type="text" placeholder="Username" name="username" class="form-control">
                </div>                    
                <div class="input-group margin-bottom-20">
                    <span class="input-group-addon"><i class="icon-lock"></i></span>
                    <input type="password" placeholder="Password" name="password" class="form-control">
                </div>                    

                <div class="row">
                    <div class="col-md-6">
                        <label class="checkbox"><input type="checkbox"> Stay signed in</label>                        
                    </div>
                    <div class="col-md-6">
                        <button class="btn-u pull-right" type="submit">Login</button>                        
                    </div>
                </div>

                <hr>

                <h4>Forget your Password ?</h4>
                <p>no worries, <a class="color-green" href="#">click here</a> to reset your password.</p>
            </form>            
        </div>
    </div><!--/row-->
</div><!--/container-->		
<!--=== End Content Part ===-->

<!-- 
	<s:form action="login.action" method="post">
		<s:textfield label="Username" key="username"/>
		<s:password label="Password" key="password"/>
		<s:submit value="Login"/>
	</s:form>
 -->
 
 <%@ include file="includes/footer.jsp" %>
 <%@ include file="includes/footer-copyright.jsp" %>
 
 <%@ include file="includes/footer-js.jsp" %>
</body>
</html>