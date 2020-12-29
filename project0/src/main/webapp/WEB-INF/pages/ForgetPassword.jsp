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
<title>Forget Password</title>
<link
	href="<c:url value="http://localhost:8080/project0/resources/css/bootstrap.min.css"></c:url>"
	rel="stylesheet" />

<link
	href="<c:url value ="http://localhost:8080/project0/resources/css/Signupform.css"></c:url>"
	rel="stylesheet" />

</head>
<body>
<sf:form method="post" modelAttribute="form">

		<div class="signup-form" style="margin-top: 150px;height: auto;margin-bottom: 150px;margin-left: 285px;">

            <h2 class="text-center"><s:message code="label.pass"></s:message></h2>
			<p class="lead"><s:message code="label.forgetpassword1"></s:message></p>

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
		<sf:label path="login" >
					<s:message code="label.email" /><span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
					<s:message code="label.email" var="enteremail"></s:message>
				<span class="input-group-addon"><i class="fa fa-envelope fa-fw"></i></span><sf:input path="login" class="form-control"
					placeholder="${enteremail}" />	
				</div>
				<font color="red"> <sf:errors path="login" /></font>
				</sf:label>	
			</div>
     
     
               <div class="form-group">
				<button type="submit" name="operation"
					value="Go"
					class="btn btn-success" style="margin-left: 45px"><span class="glyphicon glyphicon-check"></span><s:message code="label.go"/></button>
					
					<button type="submit" name="operation"
					value="cancel"
					class="btn btn-warning" style="margin-left: 45px"><span class="glyphicon glyphicon-check"></span><s:message code="label.cancel"/></button>
			</div>
                
     		
</div>
</sf:form>
</body>
</html>