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
<title>Marksheet View</title>

<style type="text/css">
	#menuToggle{
	margin-top: 61px !important;
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
						<s:message code="label.addmarksheet" />
					</c:when>
					<c:otherwise>
						<s:message code="label.updatemarksheet"></s:message>
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
				<sf:label path="studentId">
					<s:message code="label.name" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width: 345px">
						<span class="input-group-addon"><i
							class="fa fa-user fa-fw"></i></span>

						<sf:select path="studentId" class="form-control">
	                        <sf:option value=""><s:message code="label.selectstudent"></s:message></sf:option>
							<sf:options items="${studentList}" itemValue="id" itemLabel="firstName" />
						</sf:select>


					</div>
					<font color="red"><sf:errors path="studentId" /></font>
				</sf:label>
			</div>


			<div class="form-group">
				<sf:label path="rollNo">
					<s:message code="label.rollNo" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width: 345px">
						<s:message code="label.rollNo" var="enterRollNo"></s:message>
						<span class="input-group-addon"><i class="fa fa-star fa-fw"></i></span>
						<sf:input  path="rollNo" class="form-control" 
							placeholder="${enterRollNo}" />
					</div>
					<font color="red"><sf:errors path="rollNo" /></font>
				</sf:label>
			</div>


			<div class="form-group">
				<sf:label path="physics">
					<s:message code="label.physics" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width: 345px">
						<s:message code="label.physics" var="enterPhysics"></s:message>
						<span class="input-group-addon"><i class="fa fa-pencil fa-fw"></i></span>
						<sf:input path="physics" class="form-control" type="number"
							placeholder="${enterPhysics}" />
					</div>
					<font color="red"><sf:errors path="physics" /></font>
				</sf:label>
			</div>


			<div class="form-group">
				<sf:label path="chemistry">
					<s:message code="label.chemistry" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width: 345px">
						<s:message code="label.chemistry" var="enterChemistry"></s:message>
						<span class="input-group-addon"><i class="fa fa-pencil fa-fw"></i></span>
						<sf:input path="chemistry" class="form-control" type="number"
							placeholder="${enterChemistry}" />
					</div>
					<font color="red"><sf:errors path="chemistry" /></font>
				</sf:label>
			</div>


			<div class="form-group">
				<sf:label path="maths">
					<s:message code="label.maths" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width: 345px">
						<s:message code="label.maths" var="enterMaths"></s:message>
						<span class="input-group-addon"><i class="fa fa-pencil fa-fw"></i></span>
						<sf:input path="maths" class="form-control" type="number"
							placeholder="${enterMaths}"  />
					</div>
					<font color="red"><sf:errors path="maths" /></font>
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
					value="save"
					class="btn btn-success" style="margin-left: 45px"><span class="glyphicon glyphicon-check"></span><s:message code="label.update"/></button>
              		
              		<button type="submit" name="operation"
					value="cancel"
					class="btn btn-warning" style="margin-left: 45px"><span class="glyphicon glyphicon-remove"></span><s:message code="label.cancel"/></button>
					</c:otherwise>
				</c:choose>
			</div>




		</div>
	</sf:form>

</body>
</html>