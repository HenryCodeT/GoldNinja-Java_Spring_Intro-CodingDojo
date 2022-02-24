<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title> Ninja Gold Game </title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- css -->
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<div class="m-3 p-3">
	<h3>your gold: <c:out value="${ total }"></c:out></h3>
	<div class = "card-group">
		<div class="card text-center text-white bg-dark mb-3 m-2" style="width: 18rem;">
			<form action="/process-money" method="post" >
				<div class="card-body">
					<h5 class="card-title">Farm</h5>
				    <p class="card-text">(earns 10-20 gold)</p>
				    <input type="hidden" name="stage" value="farm">
				    <button type="submit" value="submit" class="btn btn-primary">Find gold!</button>
				</div>
			</form>
		</div>
		<div class="card text-center text-white bg-dark mb-3 m-2" style="width: 18rem;">
			<form action="/process-money" method="post" >
		  		<div class="card-body">
		    		<h5 class="card-title">Cave</h5>
		    		<p class="card-text">(earns 5-10 gold)</p>
		     		<input type="hidden" name="stage" value="cave">
					<button type="submit" value="submit" class="btn btn-primary">Find gold!</button>
		  		</div>
			</form>
		</div>
		<div class="card text-center text-white bg-dark mb-3 m-2" style="width: 18rem;">
			<form action="/process-money" method="post" >
		  		<div class="card-body">
		    		<h5 class="card-title">House</h5>
		    		<p class="card-text">(earns 2-5 gold)</p>
		     		<input type="hidden" name="stage" value="house">
				    <button type="submit" value="submit" class="btn btn-primary">Find gold!</button>
		  		</div>
			</form>
		</div>
		<div class="card text-center text-white bg-dark mb-3 m-2" style="width: 18rem;">
			<form action="/process-money" method="post" >
		  		<div class="card-body">
		    		<h5 class="card-title">Casino!</h5>
		    		<p class="card-text">(earns/takes 0-50 gold)</p>
		     		<input type="hidden" name="stage" value="casino">
				    <button type="submit" value="submit" class="btn btn-primary">Find gold!</button>
		  		</div>
			</form>
		</div>
	</div>
	<a class="btn btn-danger" href="/reset">RESET</a>
	<p>Activities:</p>
    <div class="border border-dark p-3 overflow-auto" style="max-height: 200px;">
    	<div>
    		<c:forEach var="list" items="${lista}">
				<c:if test="${list. getIsAdd() == 1}">
					<p class="text-success">You entered a ${list.getStage()} and earned ${list.getNum()} gold. (${ list.getDate() })</p>
				</c:if>
				<c:if test="${list. getIsAdd() == 0}">
					<p class="text-danger">You entered a ${list.getStage()} and lost ${list.getNum()} gold. (${ list.getDate() })</p>
				</c:if>
			</c:forEach>
    	</div>
	</div>
</div>


	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- js -->
	<script src="/js/app.js"></script>
</body>
</html>