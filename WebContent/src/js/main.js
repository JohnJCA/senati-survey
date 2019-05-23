
	let surveyBodyRequest = [];

	function fillAllCategorySelect() {
		removeAllOptions();
		
		$.get("SCategory", function(data, status){
			let categorySelectors = document.getElementsByTagName('select');
	   		
	   		for (var i = 0; i < categorySelectors.length; i++) {
	   			categorySelectors[i].appendChild(createDefaultOption());
	   			
		   		$.each(data,function(key, value) {
		   			
		   			let option = document.createElement("option");
		   			option.text = value.name;
		   			option.value = value.id;
		   			option.setAttribute('data-description', value.description);
		   			categorySelectors[i].appendChild(option);
				});
	   			
	   		}
		});
	}
	
	
	function updateAllCategorySelect() {
		
		$.get("SCategory", function(data, status){
			let categorySelectors = document.getElementsByTagName('select');
			console.log("update");
			let finalOption;
			
	   		$.each(data,function(key, value) {
	   			if(data.length - 1 == key); {	
	   				let option = document.createElement("option");
		   			option.text = value.name;
		   			option.value = value.id;
		   			option.setAttribute('data-description', value.description);
		   			finalOption = option; 
		   			
	   			}
			});
	   		console.log("finalOption",finalOption);
	   		for (let i = 0; i < categorySelectors.length; i++) {
				
	   			categorySelectors[i].appendChild(finalOption);

	   		}
	   		categorySelectors[0].appendChild(finalOption);
		});
	}

	
	onInit();
	
	function onInit() {
		addSection();
		validateAddButton();
	}
	
	function addSection() {
		let positionInserted = surveyBodyRequest.push( { idCategory: "", questions: [] } ) - 1;
		document.getElementById('containerOfSections').innerHTML += createSecction(positionInserted);
		fillAllCategorySelect();
		validateAddButton();
	}
	
	
	function removeAllOptions() {
		
		let categorySelectors = document.getElementsByTagName('select');
   		for (let i = 0; i < categorySelectors.length; i++) {
   			let select = categorySelectors[i];
   			console.log(select);
   			removeOptions(select);			
   		}
   		validateAddButton();
	}
	
	
	function removeOptions(selectbox) {
	     
	    for(let i = selectbox.options.length - 1 ; i >= 0 ; i--) {
	        selectbox.remove(i);
	    }
	    validateAddButton();
	}
	
	function createDefaultOption() {
		
		let option = document.createElement("option");
		option.text = " -- SELECCIONE -- ";
		option.setAttribute('disabled', true);
		option.setAttribute('selected', true);
		return option;
	
	}
	
	function validate() {
		validateAddButton();
	}
	
	/**
	 * 
	 * @param select : Elemento select que se autoinserta como parámetro, utilizado para extraer su posición en el surveyBodyRequest.
	 * @description Renderiza la descripción de la categoría según la opción seleccionada y actualiza el idCategory.
	 * @returns void
	 */
	function categoryClicked(select) {
		let position = getPosition(select);
		let descriptionContainer = getElementByClassNameAndPosition("description-container", position);
		let option = select.options[select.selectedIndex];
		descriptionContainer.innerHTML =  "<h6 class='text-primary'>Descripcion: </h6><p id='description-text'>"+option.dataset.description+"</p>";
		console.log("surveyBodyRequest",surveyBodyRequest);
		console.log("surveyBodyRequest[position]",surveyBodyRequest[position]);
		surveyBodyRequest[position].idCategory = option.value;
		printRequestAsJson();
		validateAddButton();
	}
	
	function addQuestion(addQuestionButton) {
		let position = getPosition(addQuestionButton);
		let questionInput =  getElementByClassNameAndPosition("questionInput", position);
		surveyBodyRequest[position].questions.push(questionInput.value);
		let questionListContainer = getElementByClassNameAndPosition("questionListContainer", position);
		console.log("questionListContainer",questionListContainer);
		let str = "";
		surveyBodyRequest[position].questions.map((question, index)=> {
			str += questionItem(question, position, index)
		});
		questionListContainer.innerHTML = str;
		questionInput.value = "";
		questionInput.focus();
		let button = getElementByClassNameAndPosition('questionButton', position);
		button.disabled = true;
		printRequestAsJson();
		validateAddButton();
	}
	
	function validateAddQuestionButton(input) {
		
		let position = getPosition(input);
		let button = getElementByClassNameAndPosition('questionButton', position);
		button.disabled = (input.value==="") ? true: false;
		validateAddButton();
	}
	
	
	function questionItem(name, position, index) {
		let idGenerated = "q"+"_"+position+"_"+index+"";
		return "<li id="+idGenerated+" data-value="+idGenerated+" class='list-group-item d-flex justify-content-between'><span>"+name+"</span><img width='24' height='24' style='cursor:pointer' src='src/img/delete-24.png' alt='icon' onclick='removeQuestion("+''+idGenerated+''+")'></li>"
	}
	
	function removeQuestion(idGenerated) {
		let elementLi = idGenerated;
		let generatedIndex = elementLi.dataset.value;
		let position = generatedIndex.split("_")[1];
		let questionIndex = generatedIndex.split("_")[2];
		let questionList = getSurveyRequestObjectByPosition(position)['questions'];
		let filtred = questionList.filter((question, index) => {
			return index != questionIndex
		});
		updateSurveyRequestQuestions(position,filtred);
		elementLi.remove();
		printRequestAsJson(); 
		validateAddButton();
	}
	
	
	function getPosition(element) {
		return element.dataset.position;
	}
	
	function getArrayByClassName(classname) {
		return document.getElementsByClassName(classname);
	}
	
	function getArrayByTagName(tagName) {
		return document.getElementsByTagName(tagName);
	}
	
	
	function getElementByClassNameAndPosition(classname, position) {
		
		let elements = getArrayByClassName(classname);
		
		for (let i = 0; i < elements.length; i++) {
			
			if(getPosition(elements[i]) === position ) {
				return elements[i];
			}
			
		}
	}
	
	
	function getElementByTagNameAndPosition(tagName, position) {
		
		let elements = getArrayByTagName(tagName);
		
		for (let i = 0; i < elements.length; i++) {
			
			if(getPosition(elements[i]) === position ) {
				return elements[i];
			}
			
		}
	}
	
	function updateSurveyRequestQuestions(position, questions) {
		surveyBodyRequest[position].questions = questions;
	}
	
	function updateSurveyRequestCategory(position, category) {
		surveyBodyRequest[position].idCategory = category;
	}
	
	function getSurveyRequestObjectByPosition(position) {
		return surveyBodyRequest[position];
	}
	
	function printRequestAsJson(){
		console.log(JSON.stringify(surveyBodyRequest));
	}
	
	function cleanModal() {
	    document.getElementById("categoryName").value = "";
	    document.getElementById("categoryDescription").value = "";
	}
	
	function createSecction(position) {
		
		return "<div data-position="+position+" style='display:flex; flex-flow: row wrap' class='border secction'><div style='width:50%' class='border-right border-bottom p-4'><div class='form-group'><label for='exampleFormControlSelect1'>Seleccionar Categoria</label><select data-position="+position+" onchange='categoryClicked(this)' class='form-control' id='categorySelect' typeahead-focus-first='false'></select></div><button type='button' onclick='cleanModal()' class='btn btn-primary btn-sm' data-toggle='modal' data-target='#exampleModal'>Agregar nueva categoria</button></div><div class='description-container' data-position="+position+" style='width:50%' class='border-bottom p-4'><div class='text-muted d-flex justify-content-center align-items-center' style='height:100%'>Por favor seleccione una categoria</div> </div><div style='width:100%; margin:15px 24px'><label for='exampleFormControlInput1'>Preguntas</label><div class='input-group mb-3'><input data-position="+position+" type='text' class='form-control questionInput' onkeyup='validateAddQuestionButton(this)' placeholder='Ingrese Pregunta'><div class='input-group-append'><button data-position="+position+" class='btn btn-success questionButton' type='button' onclick='addQuestion(this)' disabled><b>+</b></button></div></div><ul data-position="+position+" class='list-group questionListContainer'></ul></div></div>"
	}

	
	
	function getValueById(id) {
		return document.getElementById(id).value;
	}
	
	function validateAddButton() {
		button = document.getElementById("submitSurvey");
		button.disabled = !getValidation();
	}

	function getValidation() {
		let createdBy= getValueById("createdBy");
		let surveyName= getValueById("surveyName");
		let surveyDescription= getValueById("surveyDescription");
	    let startDate= getValueById("startDate");
	    let endDate= getValueById("endDate");
	    let maxTime= getValueById("maxTime");
		let surveyBodyRequestClone= surveyBodyRequest;
		
		if(createdBy.length > 0 && surveyName.length > 0 && surveyDescription.length > 0 && startDate.length > 0 && endDate.length > 0 && maxTime.length > 0) {
			
			if(surveyBodyRequestClone && surveyBodyRequestClone.length > 0) {
				
				if(surveyBodyRequestClone[0].idCategory.length > 0 && surveyBodyRequestClone[0].questions.length > 0) {
					return true;
				} else {
					return false
				}
				
			}
		}
	}
	
	function addSurvey() {
		  $.post("SSurvey", {
			createdBy: getValueById("createdBy"),
			surveyName: getValueById("surveyName"),
			surveyDescription: getValueById("surveyDescription"),
		    startDate: parseDate("startDate"),
		    endDate: parseDate("endDate"),
		    maxTime: getValueById("maxTime"),
			sections: JSON.stringify(surveyBodyRequest),
		  }, function(data, status) {
			  alert("Encuesta guardada!");
			  btn  = document.getElementById("goToPrevius");
			  btn.click();
		  });
	}

	