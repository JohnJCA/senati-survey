<li id="q${param.questionId}"class="list-group-item d-flex justify-content-between">
	<span>${param.questionName}</span> 
	<span>${param.questionId}</span> 
	<img width="24" height="24" src="src/img/delete-24.png" alt="icon name" onclick="removeQuestion(${param.questionId})">
</li>
<script>
	function removeQuestion(id) {
		let id = "q"+id;
		document.getElementById(id).remove();	
	}
</script>


