<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List View</title>
<link href="<c:url value ="http://localhost:8080/project0/resources/css/menumove.css"></c:url>" rel="stylesheet" />
<style type="text/css">

	table, th {  
  font-weight: bolder;
  border-color: black;

}

	table, td {
font-size: medium;
font-weight: bold; 
}	
</style>
</head>
<body>

<c:set value="${findList}" var="findtotal"></c:set>
<c:set value="${list}" var="total"></c:set>

<div class="row d-flex justify-content-center" style="height: 790px;">
	
	<div class="col-lg-12 col-sm-12 ml-auto mr-auto">
		<div class="card card-table">
			<br><br><br><br><br><br>
			<h3 class="w-100 text-center under-over-line">
				<s:message code="label.courselist"></s:message>
			</h3>
			
			<sf:form  method="post" modelAttribute="form">
				<c:set value="${((form.pageNo-1)*form.pageSize)+1}" var="index"></c:set>
				<sf:hidden path="pageNo" />
				<sf:hidden path="pageSize" />
				<c:if test="${!empty list}">
				<div class="row p-2 d-flex justify-content-center">
					<div class="col-lg-3">
						<sf:input path="courseName" cssClass="form-control border-left-right"
							placeholder="${enterName}"/>
					</div>
					<div class="col-lg-3">
						<div class="row">
							<div class="col-6">
								<button type="submit"
									class="btn btn-outline-info btn-block btn-round w-100"
									name="operation" value="Search"><s:message code="label.search"/></button>
							</div>
							<div class="col-6">
								<button type="submit"
									class="btn btn-outline-danger btn-block btn-round w-100"
									name="operation" value="Reset"><s:message code="label.reset"/></button>
							</div>
						</div>
					</div>
				</div>
				
				<center>
				<div  class="social-line align-self-center text-center col-lg-6" style="min-height: 75px;">
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
				</center>
			
				
				<div class="row d-flex justify-content-center">
					<div class="col-lg-12 table-responsive">
						<table class="table table-hover table-striped border border-secondary">
							<thead>
								<tr>
									<th scope="col" class="text-center text-white"><input
										type="checkbox" id="selectall" /></th>
									<th scope="col" class="text-center">S.No.</th>
									<th scope="col" class="text-center"><s:message code="label.name"/></th>
									<th scope="col" class="text-center"><s:message code="label.description"/></th>
									<th scope="col" class="text-center"><s:message code="label.edit"/></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="course" varStatus="ct">
								<tr>
									<td class="text-center">
										<input class="case" name="chk_1" type="checkbox" value="${course.id}">
									</td>
									<td class="text-center">
										<c:out value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
										<c:set var="index" value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
									</td>
									<td class="text-center">${course.courseName}</td>
									<td class="text-center">${course.description}</td>
									<td class="text-center">
										<c:url var="editUrl" value="/ctl/Course/Course?id=" />
              							<a class="btn btn-outline-warning btn-block btn-round w-100" href="${editUrl}${course.id}"><i class="fa fa-trash" aria-hidden="true"></i><s:message code="label.edit"/></a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row d-flex justify-content-center">
					<div class="col-lg-1 col-3">
						<c:choose>
							<c:when test="${form.pageNo > 1}">
								<button type="submit" style="width: 125px;margin-left: -25px" class="btn btn-outline-primary btn-block btn-round" name="operation" value="Previous">
									<i class="fa fa-arrow-circle-left" aria-hidden="true"></i>
									<s:message code="label.previous"/>
								</button>
							</c:when>
							<c:otherwise>
								<button type="submit" style="width: 125px;margin-left: -25px" class="btn btn-outline-secondary btn-block btn-round" name="operation" value="Previous" disabled>
									<i class="fa fa-arrow-circle-left" aria-hidden="true"></i>
									<s:message code="label.previous"/>
								</button>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-lg-1 col-3">
						<button type="submit"   class="btn btn-outline-success btn-block btn-round" name="operation" value="New"><i class="fa fa-plus" aria-hidden="true"></i><s:message code="label.new"/></button>
					</div>
					<div class="col-lg-1 col-3">
						<button type="submit" style="width: 100px;margin-left:-25px" class="btn btn-outline-danger btn-block btn-round" name="operation" value="Delete"><i class="fa fa-trash" aria-hidden="true"></i><s:message code="label.delete"/></button>
					</div>
					<div class="col-lg-1 col-3">
					<c:choose>
						<c:when test="${nextlistsize !=0}">
							<button type="submit" style="width: 85px;margin-left: -25px" class="btn btn-outline-primary btn-block btn-round" name="operation" value="Next">
								<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
								<s:message code="label.next"/>
							</button>
						</c:when>
						<c:otherwise>
							<button type="submit" style="width: 85px;margin-left: -25px" class="btn btn-outline-secondary btn-block btn-round" name="operation" value="Next" disabled>
								<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
								<s:message code="label.next"/>
							</button>
						</c:otherwise>
					</c:choose>
					</div>
				</div>
				</c:if>
				<c:if test="${empty list}">
					<div class="row d-flex justify-content-center">
						<div class="col-lg-2 col-6">
							<button type="submit" class="btn btn-outline-warning btn-block btn-round w-100" name="operation" value="Back">
								<i class="fa fa-reply" aria-hidden="true"></i><s:message code="label.back"></s:message>
							</button>
						</div>
					</div>
				</c:if>
			</sf:form>
		</div>
	</div>
</div>


</body>
</html>