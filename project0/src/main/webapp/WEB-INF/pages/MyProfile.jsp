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
<title>My Profile</title>
<style type="text/css">
	#menuToggle{
	margin-top: 61px !important;
	}
</style>

</head>


<br>

<sf:form method="post" modelAttribute="form">

		<div class="signup-form" style="margin-top: 150px;height: auto;margin-bottom: 150px;">

            <h2 class="text-center"><s:message code="label.myprofile"></s:message></h2>			

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
     		
     		
     		<sf:hidden path="id" />
				<sf:hidden path="createdBy" />
				<sf:hidden path="modifiedBy" />
				<sf:hidden path="createdDatetime" />
				<sf:hidden path="modifiedDatetime" />
     		

			
		<div class="form-group">	
		<sf:label path="firstName" >
					<s:message code="label.firstName" /><span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
						<s:message code="label.firstName" var="enterfirstName"></s:message>
				<span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span><sf:input path="firstName" class="form-control"
					placeholder="${enterfirstName}" />	
				</div>
				<font color="red"><sf:errors path="firstName" /></font>
				</sf:label>	
			</div>
			
		
		<div class="form-group">	
		<sf:label path="lastName" >
					<s:message code="label.lastName" /><span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
					<s:message code="label.lastName" var="enterLastName"></s:message>
				<span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span><sf:input path="lastName" class="form-control"
					placeholder="${enterLastName}" />	
				</div>
				<font color="red"><sf:errors path="lastName" /></font>
				</sf:label>	
			</div>
				
			
			
		<div class="form-group">	
		<sf:label path="login" >
					<s:message code="label.email" /><span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
					<s:message code="label.email" var="enteremail"></s:message>
				<span class="input-group-addon"><i class="fa fa-envelope fa-fw"></i></span><sf:input path="login" class="form-control" 
					placeholder="${enteremail}" readonly="true" />	
				</div>
				<font color="red"> <sf:errors path="login" /></font>
				</sf:label>	
			</div>
		

		<div class="form-group">	
		<sf:label path="gender" >
					<s:message code="label.gender" /><span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
				<span class="input-group-addon"><i class="fa fa-mars-double custom fa-fw"></i></span><sf:select path="gender" class="form-control" style="width:214px;">
					<sf:option value="">
						<s:message code="label.selectgender"></s:message>
					</sf:option>
					<sf:options items="${genderList}" />
				</sf:select>
               	
				</div>
				<font color="red"><sf:errors path="gender" /></font>
				</sf:label>	
			</div>

		<div class="form-group">	
		<sf:label path="dob" >
					<s:message code="label.dob" /><span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
					<s:message code="label.dob" var="enterdob"></s:message>
				<span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span><sf:input path="dob" class="form-control" id="datepicker"
					placeholder="${enterdob}" autocomplete="off" />	
				</div>
				<font color="red"><sf:errors path="dob" /></font>
				</sf:label>	
			</div>


<div class="form-group">	
		<sf:label path="mobileNo" >
					<s:message code="label.mobileNo" /><span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
					<s:message code="label.mobileNo" var="enterMobile"></s:message>
				<span class="input-group-addon"><i class="fa fa-mobile custom fa-fw"></i></span><sf:input path="mobileNo" class="form-control"
					placeholder="${enterMobile}" />	
				</div>
				<font color="red"><sf:errors path="mobileNo" /></font>
				</sf:label>	
			</div>

               <div class="form-group">
				<button type="submit" name="operation"
					value="save"
					class="btn btn-success" style="margin-left: 45px"><span class="glyphicon glyphicon-check"></span><s:message code="label.save"/></button>
					
					<button type="submit" name="operation"
					value="ChangePassword"
					class="btn btn-warning" style="margin-left: 45px"><span class="glyphicon glyphicon-check"></span><s:message code="label.changepassword"/></button>
			</div>
                
				


</div>
</sf:form>
	
	
	
	
</html>