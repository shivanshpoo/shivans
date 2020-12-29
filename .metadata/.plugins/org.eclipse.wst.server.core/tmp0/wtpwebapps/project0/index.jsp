<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>OnlineResultSystemProject0</title>
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=0">
<script type="text/javascript">
    var i = 0;
    function change() {
      var doc = document.getElementById("background");
      var color = ["black", "blue", "brown", "green","AQUA","CRIMSON","HOTPINK"];
      doc.style.color = color[i];
      i = (i + 1) % color.length;
    }
    setInterval(change, 1000);
    
    </script>
    
    <style>
body  {
   background-image: url("resources/img/file-20170602-20599-vxe5co.jpeg");
   background-size: 100%
 /*  background-color: #cccccc; */
}
</style>
    
</head>
<body>
<h1 align="Center">
<img class="img-fluid" src="resources/img/customLogoT.png" height="120px" style="margin-top: 150px;">
<br>
<a id="background" style="text-decoration: none;" href='<c:url value="/Welcome" ></c:url>'>Online Result system</a>
</h1>

</body>
</html>