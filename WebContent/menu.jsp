<%@page import="beans.Survey"%>
<%@page import="beans.SurveyResponse"%>
<%@page import="java.util.List"%>
<%@page import="beans.User"%>
<%@page import="Dao.DSurvey"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="http://www.senati.edu.pe/sites/all/themes/senati_theme/favicon/favicon.ico">
    <title>Menu</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
    <link rel="stylesheet" type="text/css" href="main.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  
 <body>
<%
User user =(User)session.getAttribute("user"); 
if (user.getFirstName() == null) {
    session.invalidate();
    response.sendRedirect("index.jsp");
    return;
}
	DSurvey dc=new DSurvey();
	List<Survey> listSurvey = dc.getSurveys(true);
	System.out.println("listSurvey"+listSurvey.size());
%>
 <jsp:include page="components/navbar.jsp"/> 

	<div style="margin-top:80px" class="container-fluid">
	<% if( listSurvey.size() > 0) {  %>
		<div class="form-inline">

			<h3>Encuestas disponibles</h3>

			<% if( user.getUserType() == false) {  %>
				<a href="survey.jsp" style="margin-left:30px" type="button" class="btn btn-success">Agregar</a>
			<% } %>
		</div>
		<% } %>
		<br>
		<div class="row">
			 
			 <c:forEach var="data" items="<%=listSurvey%>">	        
			      <div class="col-sm-6 mb-md-5">
					  <div class="card">
					    <div class="card-body">
						  <h4 class="card-title">${data.getName()}</h4>		      
					      <p class="card-text">${data.getDescription()}</p>
					      <form  method="get" action="SSurvey">

					      	<% if( user.getUserType() == false) {  %>
					      	<input type="hidden"  name="id" value="${data.getId()}"></input>
					      	<input type="hidden"  name=isTutor value="${user.getUserType()}"></input>
  	    					<input type="hidden"  name="surveyName" value="${data.getName()}"></input>
  	    					<input type="hidden"  name="time" value="${data.getTimeLimit()}"></input> 
					      	<button type="submit" class="btn btn-primary" name="">Ver encuesta</button>
	
							<% } else { %>
					      	<input type="hidden"  name="id" value="${data.getId()}"></input>
					      	<input type="hidden"  name="isTutor" value="${user.getUserType()}"></input>
    						<input type="hidden"  name="surveyName" value="${data.getName()}"></input>
  	    					<input type="hidden"  name="time" value="${data.getTimeLimit()}"></input> 
							<button type="submit" class="btn btn-primary" >Empezar encuesta</button>
							<% } %>
					      
					      </form>
					    </div>
				        <div class="card-footer text-muted">
					      <div class="row justify-content-around">
					      	<span>Inicio: ${data.getStartDate()} </span>
					      	<span>Fin: ${data.getEndDate()} </span>
					      </div>
					    </div>
					  </div>
				  </div>
		     </c:forEach>
	    	<div id="img-container" style="display:none; justify-content:center; width: 100%; margin-top:40px; flex-direction: column;align-items: center;">
    			<div style="width: 50%;box-shadow: 5px 5px 19px -8px rgba(0,0,0,0.75);overflow: hidden; border-radius: 50px; ">
		    		<img alt="not_found" src="src/img/not_found.png" style="width: 100%;">
	    			<a href="survey.jsp"  style="width: 100%;" type="button" style="width: 100%;" class="btn btn-lg btn-success">Agregar</a>
    			</div>

	    	</div>
		     
		</div>
	</div>
	<script>
	let listSurvey="<%=listSurvey%>"; 
	console.log("listSurvey",listSurvey);
	let divImg = document.getElementById('img-container');
	
	if(listSurvey.length <= 2) {
		divImg.style.display = "flex";
	}
	
	
	
	</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>