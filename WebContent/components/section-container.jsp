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