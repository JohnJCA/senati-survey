<%@page import="beans.QuestionsBySurvey"%>
<%@page import="beans.SurveyResponse"%>
<%@page import="java.util.List"%>

<%@page import="beans.User"%>
<%@page import="Dao.DSurvey"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="main.css">
 <link rel="icon" href="http://www.senati.edu.pe/sites/all/themes/senati_theme/favicon/favicon.ico">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<%

	List<SurveyResponse> list = (List) request.getAttribute("surveyResponses");
	String surveyName = (String) request.getAttribute("surveyName");
	String time = (String) request.getAttribute("time");
	String id = (String) request.getAttribute("id");
%>


<jsp:include page="components/navbar.jsp"/>

<div style="margin-top:80px" class="container-fluid">
<form method="post" action="SSurveyRecord">
	<input type="hidden" name="iduser" value="${sessionScope.user.getId()}"></input>
	<input type="hidden" name="idsurvey" value="${id}"></input>
	<input type="hidden" id="startat" name="startAt" value="${sessionScope.user.getId()}"></input>
	<input type="hidden" id="endat" name="endAt"></input>
	<input type="hidden" id="totaltime" name="totaltime"></input>
	<div class="row" style="margin: 10px 0px;">
	
		<div style="width: 59%">
		
		<h3 class="text-primary">${surveyName}</h3>
		<h3 id="timer" style="display:inline;"> </h3>
			
		</div>
	
		<div style="width: 41%; display: flex; justify-content: space-between;">
			<p>Nunca</p>
			<p>Raras veces</p>
			<p>A veces</p>
			<p>A menudo</p>
			<p>Siempre</p>
		</div>
	</div>
	
		
		 
		 
		<c:forEach var="surveyResponseList" items="<%=list%>">	
		
		  <div>
		  		<h5>${surveyResponseList.getCategory()}</h5>
		   
		    <c:forEach var="question" varStatus="loop" items="${surveyResponseList.getQuestions()}">
		  		<!-- <h4>${question.getId()} </h4> -->
		  		<div class="row" style="margin: 10px 0px">
		 	  		<div style="width: 60%">
		  				<p  style="margin: 0px">${loop.index + 1}. ${question.getName()} </p>
		  			</div>
			    	<div class="form-check form-check-inline" style="width: 40%; margin-right: 0px; justify-content: space-between;">
					  <input class="form-check-input" type="radio" name="question-${question.getId()}" value="1" required>
					  <input class="form-check-input" type="radio" name="question-${question.getId()}" value="2" required>
		  			  <input class="form-check-input" type="radio" name="question-${question.getId()}" value="3" required>
					  <input class="form-check-input" type="radio" name="question-${question.getId()}" value="4" required>
				      <input class="form-check-input" type="radio" name="question-${question.getId()}" value="5" required>		  			  
					</div> 		
		  		</div>
	
			</c:forEach>
		  </div><hr>
		  
		</c:forEach>
		<br>
		<input class="btn btn-success btn-lg" id="submitSurvey" type="submit" onclick="addSurvey()" value="Enviar respuestas">
	</form>	
</div>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.js"></script>
<script>

var startAtInputValue;
var endAtInputValue;
	
	function setStartDate() {
		
		let input = document.getElementById('startat');
		startAtInputValue = moment().format("YYYY-MM-DD HH:mm:ss");
		input.value  = startAtInputValue;
	}
	
	function setZero(value) {
		newValue = value.toString()
		return (newValue && newValue.length == 1) ? "0"+value : value;
		
	}
	
	
	
	function addSurvey() {
		
		let endAtInput = document.getElementById('endat');
		endAtInputValue = moment().format("YYYY-MM-DD HH:mm:ss");
		endAtInput.value = endAtInputValue; 
		
		
		var startAt  = moment(startAtInputValue, "YYYY-MM-DD HH:mm:ss");
		var endAt = moment(endAtInputValue, "YYYY-MM-DD HH:mm:ss");
		
		console.log(startAtInputValue);
		console.log(endAtInputValue);
		
		let days = endAt.diff(startAt, "days");
		let min = endAt.diff(startAt, "minutes");
		let sec = endAt.diff(startAt, "seconds");
		
		let strdays = setZero(days);
		let strmin = setZero(min);
		let strsec = setZero(sec);
	
		totaltime = strdays+":"+strmin+":"+strsec;
		
		
		let inputTotaltime = document.getElementById('totaltime');
		inputTotaltime.value  = totaltime;
		
		alert("Encuesta enviada!");
	}
	
	setStartDate();

</script>
	
		
</body>
</html>