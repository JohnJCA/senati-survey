<%@page import="beans.User"%>
<%@page import="Dao.DSurvey"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	
	if (request.getAttribute("user") == null) {
	    session.invalidate();
	    response.sendRedirect("index.jsp");
	    return;
	}
	User user = User.class.cast(request.getAttribute("user"));

%>
 <jsp:include page="components/navbar.jsp"/> 

	<div style="margin-top:80px" class="container-fluid">
	
		<div class="form-inline">
			<h3>Encuestas disponibles</h3>
			<% if( user.getUserType() == true) {  %>
				<a href="survey.jsp" style="margin-left:30px" type="button" class="btn btn-success">Agregar</a>
			<% } %>
		</div>
		<br>
		<div class="row">
			 <% DSurvey dc=new DSurvey();%>
			 <c:forEach var="data" items="<%=dc.getSurveys(true)%>">	        
			      <div class="col-sm-6 mb-md-5">
					  <div class="card">
					    <div class="card-body">
						  <h4 class="card-title">${data.getName()}</h4>
			     		  <h6 class="card-title text-primary">Tiempo límite: ${data.getTimeLimit()} minutos</h6>		      
					      <p class="card-text">${data.getDescription()}</p>
					      <form  method="get" action="SSurvey">

					      	<% if( user.getUserType() == true) {  %>
					      	<input type="hidden"  name="id" value="${data.getId()}"></input>
					      	<input type="hidden"  name=isTutor value="${user.getUserType()}"></input>
					      	<button type="submit" disabled="true" class="btn btn-primary" name="">Ver encuesta</button>
	
							<% } else { %>
					      	<input type="hidden"  name="id" value="${data.getId()}"></input>
					      	<input type="hidden"  name="isTutor" value="${user.getUserType()}"></input>
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
		</div>
	</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>