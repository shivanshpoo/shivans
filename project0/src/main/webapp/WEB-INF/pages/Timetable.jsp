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
<title>Timetable View</title>
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
						<s:message code="label.addtimetable" />
					</c:when>
					<c:otherwise>
						<s:message code="label.updatetimetable"></s:message>
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
				<sf:label path="courseId">
					<s:message code="label.coursename" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width:173%">
						<span class="input-group-addon"><i
							class="fa fa-graduation-cap fa-fw"></i></span>

						<sf:select path="courseId" class="form-control">
							<sf:option value=""><s:message code="label.selectcourse"></s:message></sf:option>
							<sf:options items="${courseList}" itemValue="id" itemLabel="courseName" />
						</sf:select>


					</div>
					<font color="red"><sf:errors path="courseId" /></font>
				</sf:label>
			</div>

<div class="form-group">
				<sf:label path="subjectId">
					<s:message code="label.subject" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width:345px">
						<span class="input-group-addon"><i
							class="fa fa-book fa-fw"></i></span>

						<sf:select path="subjectId" class="form-control">
                            <sf:option value=""><s:message code="label.selectsubject"></s:message></sf:option> 
							<sf:options items="${subjectList}" itemValue="id" itemLabel="subjectName" />
						</sf:select>


					</div>
					<font color="red"><sf:errors path="subjectId" /></font>
				</sf:label>
			</div>




			<div class="form-group">
				<sf:label path="semester">
					<s:message code="label.semester" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
						<span class="input-group-addon"><i
							class="fa fa-bars fa-fw"></i></span>
						<sf:select path="semester" class="form-control" style="width:214px;">
							<sf:option value="">
								<s:message code="label.selectsemester"></s:message>
							</sf:option>
							<sf:options items="${semesterList}" />
						</sf:select>

					</div>
					<font color="red"><sf:errors path="semester" /></font>
				</sf:label>
			</div>
			

			<div class="form-group">
				<sf:label path="examTime">
					<s:message code="label.examtime" />
					<span style="color: red;">*</span>
					<div class="input-group" style="width: 130%">
						<span class="input-group-addon"><i
							class="fa fa-clock-o fa-fw"></i></span>
						<sf:select path="examTime" class="form-control" style="width:214px;">
							<sf:option value="">
								<s:message code="label.selecttime"></s:message>
							</sf:option>
							<sf:options items="${examTimeList}" />
						</sf:select>

					</div>
					<font color="red"><sf:errors path="examTime" /></font>
				</sf:label>
			</div>
			


		
			<div class="form-group">
				<sf:label path="examDate">
					<s:message code="label.examdate" />
					<span style="color: red;">*</span>
					<s:message code="label.examdate" var="enterDate"></s:message>
					<div class="input-group" style="width: 130%">
						<span class="input-group-addon"><i
							class="fa fa-calendar fa-fw"></i></span>
						<sf:input path="examDate" class="form-control" id="datepicker1" 
							placeholder="${enterDate}" autocomplete="off" />
					</div>
					<font color="red"><sf:errors path="examDate" /></font>
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