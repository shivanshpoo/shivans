<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Role View</title>
<style type="text/css">
	#menuToggle{
	margin-top: 47px !important;
	}
	</style>
	
</head>
<body>
<br>

	<sf:form method="post" modelAttribute="form">

		<div class="signup-form"
			style="margin-top: 150px; height: auto; margin-bottom: 150px;">

			<h2 class="text-center">
				<c:choose>
					<c:when test="${form.id==0}">
						<s:message code="label.addrole" />
					</c:when>
					<c:otherwise>
						<s:message code="label.updaterole"></s:message>
					</c:otherwise>
				</c:choose>
			</h2>


			<div class="social-line text-center">
				<!-- Error -->
				<c:if test="${error != null}">
					<div class="alert alert-danger alert-with-icon"
						data-notify="container">
						<div class="container">
							<div class="alert-wrapper">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close"></button>
								<div class="message">${error}</div>
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
									aria-label="Close"></button>
								<div class="message">${success}</div>
							</div>
						</div>
					</div>
				</c:if>
				<!-- //Success -->
			</div>


			<sf:hidden path="id" />
			<sf:hidden path="createdBy" />
			<sf:hidden path="modifiedBy" />
			<sf:hidden path="createdDatetime" />
			<sf:hidden path="modifiedDatetime" />




			<div class="form-group">
				<sf:label path="name">
					<s:message code="label.name" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
						<s:message code="label.name" var="enterName"></s:message>
						<span class="input-group-addon"><i class="fa fa-users fa-fw"></i></span>
						<sf:input path="name" class="form-control"
							placeholder="${enterName}" />
					</div>
					<font color="red"><sf:errors path="name" /></font>
				</sf:label>
			</div>


			<div class="form-group">
				<sf:label path="description">
					<s:message code="label.description" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
						<s:message code="label.description" var="enterdescription"></s:message>
						<span class="input-group-addon"><i class="fa fa-clipboard fa-fw"></i></span>
						<sf:input path="description" class="form-control"
							placeholder="${enterdescription}" />
					</div>
					<font color="red"><sf:errors path="description" /></font>
				</sf:label>
			</div>


		<div class="form-group">
				<c:choose>
              		<c:when test="${form.id==0}"> 
              		
              		<button type="submit" name="operation"
					value="save"
					class="btn btn-success" style="margin-left: 45px"><span class="glyphicon glyphicon-check"></span><s:message code="label.save"/></button>
              		
              		<button type="submit" name="operation"
					value="reset"
					class="btn btn-warning" style="margin-left: 45px"><span class="glyphicon glyphicon-refresh"></span><s:message code="label.reset"/></button>
              		</c:when>
					<c:otherwise>
						
					<button type="submit" name="operation"
					value="update"
					class="btn btn-success" style="margin-left: 45px"><span class="glyphicon glyphicon-check"></span><s:message code="label.update"/></button>
              		
              		<button type="submit" name="operation"
					value="cancle"
					class="btn btn-warning" style="margin-left: 45px"><span class="glyphicon glyphicon-remove"></span><s:message code="label.cancel"/></button>
					</c:otherwise>
				</c:choose>
			</div>



		</div>
	</sf:form>

</body>
</html>