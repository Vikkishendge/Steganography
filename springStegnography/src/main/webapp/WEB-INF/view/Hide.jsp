 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   	
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="./style.css"/>
	<title>Insert title here</title>
	<link href="<c:url value="/resource/css/style.css" />" rel="stylesheet">
	
	<script src="<c:url value="/resource/js/hide.js"/>"></script>
</head>
<body> 

	<div class="outer">
	
		<center><h1>Steganography</h1></center>
		<br/><br/>
		
			<div class="select-mode" id="select-mode">
				   	<h2 style="border-bottom: solid black 5px;" id="encode">Encode</h2>
				   	<h2 id="decode"><a id="a" href="./extractimg">Decode</a></h2>
			</div>
		<div class="input-div m-5" id="encode-div">
			<h2 class="head">Encode Image</h2>
				
				<img class="Selected_img"id="Selected_img" src=<c:url value="/resource/image/Empty.jpg"/>/>
			<br /><br/>
			<form action="proccess" method="post" enctype="multipart/form-data">
	
				<div class="mb-3">
				  <label for="formFileSm" class="form-label">Select Image</label>
				  <input name="img" type="file" class="form-control form-control-lg encode-input" id="Hide">
				</div>
	
					<br/>
	
				  <div class="form-floating mb-5">
					  <textarea class="form-control"  name="textarea" id="floatingTextarea2" style="height: 100px"></textarea>
					  <label for="floatingTextarea2">Enter your message here</label>
					</div>
	
				<center><button type="submit" class="btn btn-primary btn-lg">Encode</button></center>
			</form>
		</div>
	
	</div>
	</body>
</html>