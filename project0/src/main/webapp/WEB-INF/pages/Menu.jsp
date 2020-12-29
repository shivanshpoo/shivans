<%@page import="in.co.sunrays.project0.dto.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<style>
.vertical-menu {
  width: 200px;
}

.vertical-menu a {
  background-color: #eee;
  color: black;
  display: block;
  padding: 12px;
  text-decoration: none;
}

.vertical-menu a:hover {
  background-color: #ccc;
}

.vertical-menu a.active {
  background-color: #F4D03F;
  color: white;
}
</style>
<c:if test="${not empty sessionScope.user}">

<div class="vertical-menu">
  <a class="active" href="<c:url value="/Welcome"/>"><s:message code="label.home" /></a>
  <a class="menu-items m-1" href="<c:url value="/ctl/User/Search"/>"
				class="smoothscroll"><s:message code="label.userlist" />
				</a> 
				<a class="menu-items m-1" href="<c:url value="/ctl/Role/Search"/>"
				class="smoothscroll"><s:message code="label.rolelist" /></a> <a
				class="menu-items m-1" href="<c:url value="/ctl/College/Search"/>"
				class="smoothscroll"><s:message code="label.collegelist" /></a> <a
				class="menu-items m-1" href="<c:url value="/ctl/Course/Search"/>"
				class="smoothscroll"><s:message code="label.courselist" /></a> <a
				class="menu-items m-1" href="<c:url value="/ctl/Subject/Search"/>"
				class="smoothscroll"><s:message code="label.subjectlist" /></a> <a
				class="menu-items m-1" href="<c:url value="/ctl/Faculty/Search"/>"
				class="smoothscroll"><s:message code="label.facultylist" /></a> <a
				class="menu-items m-1" href="<c:url value="/ctl/Student/Search"/>"
				class="smoothscroll"><s:message code="label.studentlist" /></a> <a
				class="menu-items m-1" href="<c:url value="/ctl/Timetable/Search"/>"
				class="smoothscroll"><s:message code="label.timetablelist" /></a>
</div>
		
</c:if>