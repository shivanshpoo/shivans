<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<style type="text/css">
	#menuToggle{
	margin-top: 61px !important;
	}
</style>

</head>
<body>

<br>


<sf:form method="post" modelAttribute="form">

		<div class="signup-form" style="margin-top: 150px;height: auto;margin-bottom: 150px;">

            <h2 class="text-center"><s:message code="label.changepassword" /></h2>
			

<div class="social-line text-center">
				<!-- Error -->
				<c:if test="${error != null}">
					<div class="alert alert-danger alert-with-icon"
						data-notify="container">
						<div class="container">
							<div class="alert-wrapper">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									
								</button>
								<div class="message">
									${error}
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<!-- //Error -->
				<!-- Success -->
				<c:if test="${success != null}">
					<div class="alert alert-success alert-with-icon"
						data-notify="container">
						<div class="container">
							<div class="alert-wrapper">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									
								</button>
								<div class="message">
									${success}
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<!-- //Success -->
			</div>
     		
     		
		<div class="form-group">	
		<sf:label path="oldPassword" >
					<s:message code="label.oldPassword" /><span style="color: red;">*</span>
					<div class="input-group" style="width:345px;">
				<s:message code="label.oldPassword" var="enteroldpassword"></s:message>
				<span class="input-group-addon"><i class="fa fa-lock fa-fw"></i></span><sf:input type="password" path="oldPassword" class="form-control"
					placeholder="${enteroldpassword}" />	
				</div>
				<font color="red"> <sf:errors path="oldPassword" /></font>
				</sf:label>	
			</div>
     
    
    	<div class="form-group">	
		<sf:label path="newPassword" >
					<s:message code="label.newPassword" /><span style="color: red;">*</span>
					<div class="input-group" style="width: 345px">
					<s:message code="label.newPassword" var="enternewpassword"></s:message>
				<span class="input-group-addon"><i class="fa fa-lock fa-fw"></i></span><sf:input type="password" path="newPassword" class="form-control"
					placeholder="${enternewpassword}" />	
				</div>
				<font color="red"> <sf:errors path="newPassword" /></font>
				</sf:label>	
			</div>
     
    
    	<div class="form-group">	
		<sf:label path="confirmPassword" >
					<s:message code="label.confirmPassword" /><span style="color: red;">*</span>
					<div class="input-group" style="width: 345px">
					<s:message code="label.confirmPassword" var="enterconPassword"></s:message>
				<span class="input-group-addon"><i class="fa fa-lock fa-fw"></i></span><sf:input type="password" path="confirmPassword" class="form-control"
					placeholder="${enterconPassword}" />	
				</div>
				<font color="red"> <sf:errors path="confirmPassword" /></font>
				</sf:label>	
			</div>
     

               <div class="form-group">
				<button type="submit" name="operation"
					value="save"
					class="btn btn-success" style="margin-left: 45px"><span class="glyphicon glyphicon-check"></span><s:message code="label.save"/></button>
					
					<button type="submit" name="operation"
					value="cancel"
					class="btn btn-warning" style="margin-left: 45px"><span class="glyphicon glyphicon-check"></span><s:message code="label.cancel"/></button>
			</div>
                
     		
</div>
</sf:form>



</body>
</html>