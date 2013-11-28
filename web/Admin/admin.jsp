<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>

<%@ include file="../includes/header-css.jsp" %>


</head>
<body>

<%@include file="../includes/header-top.jsp" %>
<%@include file="../includes/header.jsp" %>

<div class="breadcrumbs margin-bottom-40">
<div class="container">
        <h1 class="pull-left">Welcome! <s:property value="%{logInfo.userType}"/>   </h1>
    </div>
</div>    
<s:a value= "register">Add User</s:a>
<s:a value= "creategroup">Add Class</s:a>
<s:a value= "editgroup">Edit Group</s:a>
<s:a value= "viewgroups">View Groups</s:a>


<div class="row tab-v3">
                <div class="col-sm-3">
                    <ul class="nav nav-pills nav-stacked"> 
                        <li class="active"><a href="#home-2" data-toggle="tab"><i class="icon-home"></i> Home</a></li>
                        <li><a href="#profile-2" data-toggle="tab"><i class="icon-cloud"></i> Add User</a></li>
                        <li><a href="#messages-2" data-toggle="tab"><i class="icon-comments"></i> Add Class</a></li>   
                    </ul>                    
                </div>
                <div class="col-sm-9">
                    <div class="tab-content">
                        <div class="tab-pane active" id="home-2">
                            <h4>Heading Sample 1</h4>
                            <p>Vivamus imperdiet condimentum diam, eget placerat felis consectetur id. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum <strong>ivamus imperdiet</strong> condimentum diam, eget placerat felis consectetur id. Donec eget orci metus, ac adipiscing nunc.</p> 
                            <p>Pellentesque <strong>fermentum vivamus</strong> imperdiet condimentum diam, eget placerat felis consectetur id. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum, ante ac felis consectetur id. Donec eget orci metusvivamus imperdiet.</p>                        
                        </div>
                        <div class="tab-pane" id="profile-2">
                            <img alt="" class="pull-left lft-img-margin img-width-200" src="assets/img/main/5.jpg">                         
                            <h4>Heading Sample 2</h4>
                            <p>Vivamus imperdiet condimentum diam, eget placerat felis consectetur id. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum, ante ac interdum ullamcorper. Donec eget orci metus, <strong>ac adipiscing nunc.</strong> Vivamus imperdiet condimentum diam, eget placerat felis consectetur id. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum, ante ac interdum id. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum, ante ac interdum ullamcorper. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum, ante ac <strong>interdum ullamcorper.</strong></p>
                        </div>
                        <div class="tab-pane" id="messages-2">
                            <h4>Heading Sample 3</h4>
                            <p><img alt="" class="pull-right rgt-img-margin img-width-200" src="assets/img/main/6.jpg"> <strong>Vivamus imperdiet condimentum diam, eget placerat felis consectetur id.</strong> Donec eget orci metus, Vivamus imperdiet condimentum diam, eget placerat felis consectetur id. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum, ante ac interdum ullamcorper. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum, consectetur id. Donec eget orci metus, ac adipiscing nunc. <strong>Pellentesque fermentum</strong>, ante ac interdum ullamcorper. Donec eget orci metus, ac adipiscing nunc. Pellentesque fermentum, ante ac interdum ullamcorper.</p>
                        </div>
                    </div>                                    
                </div>
            </div>



 <%@ include file="../includes/footer.jsp" %>
 <%@ include file="../includes/footer-copyright.jsp" %>
 <%@ include file="../includes/footer-js.jsp" %>

</body>
</html>