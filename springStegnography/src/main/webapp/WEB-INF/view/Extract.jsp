<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
   	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		
		<link href="<c:url value="/resource/css/style.css" />" rel="stylesheet">
		
		<script src="<c:url value="/resource/js/extract.js"/>"></script>
		
		<title>Decode</title>
	</head>
<body>
	<div class="outer">
		
			<center><h1>Steganography </h1></center>
			<br/><br/>
			
				<div class="select-mode" id="select-mode">
					   	<h2 id="encode"><a id="a" href="./hideimg">Encode</a></h2>
					   	<h2 style="border-bottom: solid black 5px;" id="decode">Decode</h2>
				</div>


			<div class="m-5" id="decode-div">
					<h2 class="head">Decode Image</h2>
				<img class="Selected_img"id="Selected_img" src=<c:url value="/resource/image/Empty.jpg"/>/>
				
					<br/> <br/>
				<form action="extract" method="post" enctype="multipart/form-data">
					<div class="mb-5">
					  <label for="Extract" class="form-label">Select Image</label>
					  <input class="decode-input form-control form-control-lg" name="img" id="Extract" type="file">
					</div>
					<div class="form-floating mb-5">
					  <textarea class="form-control"  style="height: 100px" readonly></textarea>
					  <label for="floatingTextarea2">Extracted Message:${content}</label>
					</div>
					<center><button type="submit" class="btn btn-primary btn-lg">Decode</button></center>
				</form>
			</div>
		</div>
	</body>
</html>