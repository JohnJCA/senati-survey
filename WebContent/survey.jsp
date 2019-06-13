<%@page import="beans.User"%>
<%@page import="beans.Category"%>
<%@page import="Dao.DCategory"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="http://www.senati.edu.pe/sites/all/themes/senati_theme/favicon/favicon.ico">
<title>Agregar encuesta</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="main.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.js"></script>

</head>
<body>


	<jsp:include page="components/navbar.jsp"/>
	
	<div style="margin-top:80px"  class="container-fluid">
	<input id="createdBy" type="hidden" value="${sessionScope.user.getId()}">
		<div>
			<h4 class="text-primary">Datos de encuesta</h4><br>
			<form id="surveyForm" class="row">
				<div style="margin-bottom:20px" class="col-6">
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Nombre</label>
				    <input type="text" class="form-control" id="surveyName" onkeyup="validate()" name="name" placeholder="Ingrese nombre" required autocomplete="off">
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlTextarea1">Descripción</label>
				    <textarea style="resize: none;height: 126px" id="surveyDescription" onkeyup="validate()" maxlength="200" class="form-control" name="description" required autocomplete="off"></textarea>
				  </div>
				</div>
				<div class="col-6">
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Fecha de Inicio</label>
				    <input type="datetime-local" class="form-control" id="startDate" onkeyup="validate()" name="startDate" placeholder="Ingrese fecha" required autocomplete="off">
				  </div>
		  		  <div class="form-group">
				    <label for="exampleFormControlInput1">Fecha Final</label>
				    <input type="datetime-local" class="form-control" id="endDate" onkeyup="validate()" name="endDate" id="exampleFormControlInput1" placeholder="Ingrese fecha" required autocomplete="off">
				  </div>
		  	  	  <div class="form-group">
				    <label for="exampleFormControlInput1">Tiempo máximo</label>
				    <input type="number" class="form-control" name="maxTime" id="maxTime" onkeyup="validate()" placeholder="Ingrese tiempo máximo (minutos)" required autocomplete="off">
				  </div>
				</div>
				
				<h4 class="text-primary col-12">Sección de Preguntas</h4>
				
				<div id="containerOfSections" style="width:100%; margin: 0px 15px; ">

					<!-- aca va el loop -->
				</div>
   			    <div class="col-12 d-flex mb-4">
			    	<a class="text text-primary" onclick="addSection()"> Agregar sección</a>
			    </div>
					
   			    <div class="col-12 d-flex mb-4 flex-row-reverse">
			    	<input class="btn btn-success btn-lg" id="submitSurvey" type="submit" onclick="addSurvey()" value="Registrar Encuesta">
			    </div>
			</form>
			<form method="post" action="SUser" class="hiddenform">
			  
				<input name="username" type="text" value="${sessionScope.user.getUsername()}">${sessionScope.user.getUsername()}</input>
				<input name="password" type="text" value="${sessionScope.user.getPassword()}">${sessionScope.user.getPassword()}</input>
				<input id="goToPrevius" type="submit" value="${sessionScope.user.getSecondName()}">${sessionScope.user.getFirstName()} </input>
			</form>
		</div>
	</div>
	<jsp:include page="components/category-modal.jsp"/>	
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="src/js/main.js"></script> 


<script>
function parseDate(id) {
	value = getValueById(id);
	return moment(value).format('YYYY-MM-DD HH:mm:ss');	
}

</script>
</html>