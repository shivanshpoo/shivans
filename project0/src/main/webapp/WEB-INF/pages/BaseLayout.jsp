<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>ORS</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <link href="https://unpkg.com/ionicons@4.5.9-1/dist/css/ionicons.min.css" rel="stylesheet">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"></link>

<link
	href="<c:url value ="http://localhost:8080/project0/resources/css/style.css"></c:url>"
	rel="stylesheet" />
	
	<link
	href="<c:url value="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"></c:url>"
	rel="stylesheet">
	
	<script src='<c:url value="http://localhost:8080/project0/resources/js/bootstrap-datetimepicker.min.js"></c:url>'></script>
	
	 <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/>">
		<script src="<c:url value="/resources/js/jquery-1.12.4.js"/>"></script>
		<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>	
	
<link
	href="<c:url value ="http://localhost:8080/project0/resources/css/Signupform.css"></c:url>"
	rel="stylesheet" />
	<link
	href="<c:url value ="http://localhost:8080/project0/resources/css/Loginform.css"></c:url>"
	rel="stylesheet" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
</style>

<link
	href="<c:url value="http://localhost:8080/project0/resources/css/bootstrap.min.css"></c:url>"
	rel="stylesheet" />
 
<link
	href="<c:url value ="http://localhost:8080/project0/resources/css/Signupform.css"></c:url>"
	rel="stylesheet" />

        <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/>">
		<script src="<c:url value="/resources/js/jquery-1.12.4.js"/>"></script>
		<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>	
	<script>
		$(function() {
			$("#datepicker").datepicker({
				dateFormat : 'mm/dd/yy',
				defaultDate : "01/01/1982",
				changeMonth : true,
				changeYear : true,
				yearRange : '-35:-18' 
			});

		});
	</script>

<script>
		$(function() {
			$("#datepicker1").datepicker({
				dateFormat : 'mm/dd/yy',
				defaultDate : "01/01/1982",
				changeMonth : true,
				changeYear : true,
				minDate:"+1d",
			});

		});
	</script>

<script>
		$(function() {
			$("#datepicker2").datepicker({
				dateFormat : 'mm/dd/yy',
				defaultDate : "01/01/2019",
				changeMonth : true,
				changeYear : true,
			});

		});
	</script>


</head>

<body>

	<tiles:insertAttribute name="header"></tiles:insertAttribute>

	<div class="wrapper">
		<div class="page-header" style="background-color: #a2d8d81f">
			
			<div class="container-fluid">
			<div class="row"> 
				<div class="col-md-2">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</div>
			<div class="col-md-10">
				<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</div>
				</div>
				 </div> 
				<tiles:insertAttribute name="footer"></tiles:insertAttribute>
			</div>
		</div>
	
</body>
</html>