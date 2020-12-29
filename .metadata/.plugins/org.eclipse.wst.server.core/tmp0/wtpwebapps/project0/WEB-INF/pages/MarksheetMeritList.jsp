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
<title>MarksheetMeritList View</title>
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
	<sf:form method="post" modelAttribute="form">

<div class="row d-flex justify-content-center" style="height: 790px;">

	<div class="col-lg-12 col-sm-12 ml-auto mr-auto">
		<div class="card card-table">
		<br><br><br><br><br><br>
			<h3 class="w-100 text-center under-over-line">
				<s:message code="label.marksheetmeritlist"></s:message>
			</h3>
				<c:set value="1" var="index"></c:set>
				<c:if test="${!empty list}">
				<div class="row p-2 d-flex justify-content-center">
					<div class="col-lg-2">
								<a target="blank" class="btn btn-warning btn-block btn-round w-100" href='<c:url value="/ctl/Jasper" ></c:url>'><i class="fa fa-print" aria-hidden="true"></i><s:message code="label.meritList"></s:message></a>
					</div>
				</div>
				<div class="row d-flex justify-content-center">
					<div class="col-lg-12 table-responsive">
						<table class="table table-hover table-striped border border-secondary">
							<thead>
								<tr>
									<th scope="col" class="text-center">S.No.</th>
									<th scope="col" class="text-center"><s:message code="label.name"/></th>
									<th scope="col" class="text-center"><s:message code="label.rollNo"/></th>
									<th scope="col" class="text-center"><s:message code="label.physics"/></th>
									<th scope="col" class="text-center"><s:message code="label.chemistry"/></th>
									<th scope="col" class="text-center"><s:message code="label.maths"/></th>
									<th scope="col" class="text-center"><s:message code="label.total"/></th>
									<th scope="col" class="text-center"><s:message code="label.percentage"/></th>
								</tr>
								</thead>
							<tbody>
							<c:forEach items="${list}" var="marksheet" varStatus="ct">
							<c:set var="percentage"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${(marksheet.physics+marksheet.chemistry+marksheet.maths)/3}" /></c:set>
								<tr>								
									<td class="text-center">
										<c:out value="${ct.index+1}" />
										<c:set var="index" value="${ct.index+1}" />
									</td>
									<td class="text-center">${marksheet.name}</td>
									<td class="text-center">${marksheet.rollNo}</td>
									<td class="text-center">${marksheet.physics}</td>
									<td class="text-center">${marksheet.chemistry}</td>
									<td class="text-center">${marksheet.maths}</td>
									<td class="text-center">${marksheet.physics+marksheet.chemistry+marksheet.maths}</td>
									<td class="text-center">${percentage}%</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				</c:if>
		</div>
	</div>
</div>
</sf:form>
</body>
</html>