
	var questionList = [];
	
	function fillCategorySelect() {
		removeOptions();
		$.get("SCategory", function(data, status){
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
		descriptionElement.innerHTML =  "<h6 class='text-primary'>Descripcion: </h6><p id='description-text'>"+description+"</p>"
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
	
	function questionItem(name,index) {
		let newIndex = "q"+index;
		return "<li id="+newIndex+" class='list-group-item d-flex justify-content-between'><span>"+name+"</span><img width='24' height='24' style='cursor:pointer' src='src/img/delete-24.png' alt='icon' onclick='removeQuestion("+index+")'></li>"
	}
	
	
	function addCategory() {
		 let hiddenInput = document.getElementById('hiddenInput').value;

		  $.post("SSSurvey", {
			questions: JSON.stringify(hiddenInput),
		  }, function(data, status) {
			  console.log("agregado");
		  });
	}
	
	
	
	
/*	function createSeccion() {
		
		return "<div style='margin: 0px 15px; width:100%; display:flex; flex-flow: row wrap' class='border'><div style='width:50%' class='border-right border-bottom p-4'><div class='form-group'><label for='exampleFormControlSelect1'>Seleccionar Categoría</label><select onchange='categoryClicked()' class='form-control' id='categorySelect' typeahead-focus-first='false'><option disabled selected value> -- SELECCIONE -- </option></select></div><button type=d'button' class='btn btn-primary btn-sm' data-toggle='modal' data-target='#exampleModal'>Agregar nueva categoría</button></div><div id='description-container' style='width:50%' class='border-bottom p-4'><div class='text-muted d-flex justify-content-center align-items-center' style='height:100%'>Por favor seleccione una categoría</div> </div><div style='width:100%; margin:15px 24px'><label for='exampleFormControlInput1'>Preguntas</label><div class='input-group mb-3'><input type='text' class='form-control' onkeyup='validateAddQuestionButton()' id='questionInput' placeholder='Ingrese Pregunta'><div class='input-group-append'><button class='btn btn-success' type='button' id='questionButton' onclick='addQuestion()' disabled><b>+</b></button></div></div><ul id='questionListContainer' class='list-group'></ul><input type='text' id='hiddenInput' name='questions' required></div></div>"
	}
	*/

	