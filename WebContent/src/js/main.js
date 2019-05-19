
	var questionList = {
		idCategory: "",
		questions: []
	};
	resetHiddenInput();
	
	function fillCategorySelect() {
		removeOptions();
		$.get("SCategory", function(data, status){
	   		let select = document.getElementById("categorySelect");
	   		
	   		$.each(data,function(key, value) {
	   			console.log("value",value);
	   			let option = document.createElement("option");
	   			option.text = value.name;
	   			option.value = value.id;
	   			option.setAttribute('data-description', value.description);
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
		
		let descriptionElement = document.getElementById("description-container");
		let select = document.getElementById("categorySelect");
		let option = select.options[select.selectedIndex];
		descriptionElement.innerHTML =  "<h6 class='text-primary'>Descripcion: </h6><p id='description-text'>"+option.dataset.description+"</p>";
		console.log('option',option);
		questionList.idCategory = option.value;
		updateHiddenInput();
	}
	
	function addQuestion() {
		let str = "";
		let questionInput = document.getElementById("questionInput");
		let question = questionInput.value;
		questionList.questions.push(question);
		let questionListContainer = document.getElementById("questionListContainer");
		questionList.questions.map((question, index)=> {str += questionItem(question, index)});
		questionListContainer.innerHTML = str;
		questionInput.value = "";
		questionInput.focus();
		validateAddQuestionButton();
		updateHiddenInput();	
	}
	
	function removeQuestion(index) {
		let questionItem = document.getElementById("q"+index);
		questionText = questionItem.querySelector('span').innerText;
		questionList.questions = questionList.questions.filter((question)=> {
	
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
		console.log("questionList",questionList.questions);
		hiddenInput.value = JSON.stringify(questionList);
	}
	
	function questionItem(name,index) {
		let newIndex = "q"+index;
		return "<li id="+newIndex+" class='list-group-item d-flex justify-content-between'><span>"+name+"</span><img width='24' height='24' style='cursor:pointer' src='src/img/delete-24.png' alt='icon' onclick='removeQuestion("+index+")'></li>"
	}
	
	
	function addSurvey() {
		 let hiddenInput = document.getElementById('hiddenInput').value;

		  $.post("SSurvey", {
			questions: JSON.stringify(hiddenInput),
		  }, function(data, status) {
			  console.log("agregado");
		  });
	}
	
	function resetHiddenInput() {
		let hiddenInput= document.getElementById('hiddenInput');
		hiddenInput.value = "";
	}
	
	

	