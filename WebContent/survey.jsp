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
</head>
<script>



</script>
<body>
	<jsp:include page="components/navbar.jsp"/>
	<div style="margin-top:80px"  class="container-fluid">
		<div>
			<h4 class="text-primary">Datos de encuesta</h3><br>
			<form id="surveyForm" class="row">
				<div style="margin-bottom:20px" class="col-6">
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Nombre</label>
				    <input type="text" class="form-control" name="name" placeholder="Ingrese nombre">
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlTextarea1">Descripción</label>
				    <textarea style="resize: none;height: 126px" maxlength="200" class="form-control" name="description"></textarea>
				  </div>
				</div>
				<div class="col-6">
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Fecha de Inicio</label>
				    <input type="datetime-local" class="form-control" name="startDate" placeholder="Ingrese fecha">
				  </div>
		  		  <div class="form-group">
				    <label for="exampleFormControlInput1">Fecha Final</label>
				    <input type="datetime-local" class="form-control" name="endDate" id="exampleFormControlInput1" placeholder="Ingrese fecha">
				  </div>
		  	  	  <div class="form-group">
				    <label for="exampleFormControlInput1">Tiempo máximo</label>
				    <input type="number" class="form-control" name="questions" placeholder="Ingrese tiempo máximo (minutos)">
				  </div>
				</div>
				
				<h4 class="text-primary col-12">Sección de Preguntas</h4>
				
				<div style="margin: 0px 15px; width:100%; display:flex; flex-flow: row wrap" class="border">
				
					<div style="width:50%" class="border-right border-bottom p-4">
					  	<div class="form-group">
					        <label for="exampleFormControlSelect1">Seleccionar Categoría</label>
						    <select onchange="categoryClicked()" class="form-control" id="categorySelect" typeahead-focus-first="false">
						    	<option disabled selected value> -- SELECCIONE -- </option>
						    </select>
						</div>
						<button type=d"button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#exampleModal">Agregar nueva categoría</button>
					</div>
				
					<div id="description-container" style="width:50%" class="border-bottom p-4">
						<div class="text-muted d-flex justify-content-center align-items-center" style="height:100%">Por favor seleccione una categoría</div> 
					</div>
					<div style="width:100%; margin:15px 24px">
						<label for="exampleFormControlInput1">Preguntas</label>
					  	<div class="input-group mb-3">
				  			<input type="text" class="form-control" onkeyup="validateAddQuestionButton()" id="questionInput" placeholder="Ingrese Pregunta">
						    <div class="input-group-append">
						      <button class="btn btn-success" type="button" id="questionButton" onclick="addQuestion()" disabled><b>+</b></button>
							</div>
					  	</div>
						<ul id="questionListContainer" class="list-group"></ul>
						<input type="text" id="hiddenInput" name="questions" required>
					</div>
				</div>

   			    <div class="col-12 d-flex justify-content-end my-4">
			    	<input class="btn btn-success" id="submitSurvey" type="submit" value="Registrar Encuesta">
			    </div>
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
/*
	var questionList = [];
	
	function fillCategorySelect() {
		removeOptions();
		$.get(SCategory, function(data, status){
	   		let select = document.getElementById("categorySelect");
	   		
	   		$.each(data,function(key, value) {
	   			let option = document.createElement("option");
	   			option.text = value.name;
	   			option.value = value.description;
	   			select.appendChild(option);
			});
		});
	}
	
	fillCategorySelect();
	
	function removeOptions() {
	    let select = document.getElementById("categorySelect");
	    for(i = 0 ; i < select.options.length ; i++) {
	    	if(i != 0) { select.remove(i);}
	    	
	    }
	}
	
	function categoryClicked() {
		
		let select = document.getElementById("categorySelect");
		let descriptionElement = document.getElementById("description-container");
		let description = select.options[select.selectedIndex].value;
		descriptionElement.innerHTML =  "<h6 class='text-primary'>Descripción:</h6><p id='description-text'>"+description+"</p>"
	}
	function addQuestion() {
		let str = "";
		let questionInput = document.getElementById("questionInput");
		let question = questionInput.value;
		questionList.push(question);
		let questionListContainer = document.getElementById("questionListContainer");
		questionList.map((question, index)=> {str += questionItem(question, index)});
		questionListContainer.innerHTML = str;
		questionInput.value = "";
		questionInput.focus();
		validateAddQuestionButton();
		updateHiddenInput();	
	}
	
	function removeQuestion(index) {
		let questionItem = document.getElementById("q"+index);
		questionText = questionItem.querySelector('span').innerText;
		questionList = questionList.filter((question)=> {
	
			return question !== questionText
		});
		document.getElementById("q"+index).remove();
		updateHiddenInput();
	}
	
	function validateAddQuestionButton() {
		let button = document.getElementById('questionButton');
		button.disabled = (document.getElementById("questionInput").value==="") ? true: false;
	}
	
	function updateHiddenInput() {
		let hiddenInput= document.getElementById('hiddenInput');
		console.log("questionList",questionList);
		hiddenInput.value = JSON.stringify(questionList);
	}
	
	function 
*/
</script>
</html>