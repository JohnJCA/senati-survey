<%@page import="java.util.List"%>
<%@page import="beans.Diagram"%>
<%@page import="Dao.DData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Graficos</title>
 <link rel="stylesheet" type="text/css" href="main.css">
 <link rel="icon" href="http://www.senati.edu.pe/sites/all/themes/senati_theme/favicon/favicon.ico">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>


<body>
<jsp:include page="components/navbar.jsp"/>

<% 
	DData data =new DData();
	int recordsCount = data.getRecordsCount();
	int studentsCount = data.getStudentsCount();
	int studentswithoutRecord = studentsCount - recordsCount;
	String id = (String) request.getAttribute("id");
	int idAsInt = Integer.parseInt(id);

%>


<div class="container-fluid" style="margin-top:80px; display: flex; flex-flow: row wrap; justify-content: space-around;">

	<script>
		var sum = [];
		var labels = [];
	</script>

      <c:forEach var="row" items="<%=data.getDiagramBar( idAsInt)%>" >
      	<script>
			 labels.push("${row.getQuestionName()}");
			 sum.push("${row.getSuma()}");
		</script>
      		 
      </c:forEach>
      
      

	<h3 class="text-primary" style="text-align:center;width: 100%">Analítica</h3><br><br><br><br>
	
	<div class="col-5">

		<canvas id="pie"></canvas>
	</div>
	
	<div class="col-5">
	

	</div>
	
	
	<div style="margin:50px 0px" class="col-10">

		<canvas id="densityChart"></canvas>
	</div>
	
	

	

	



	
</div>
 
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
<script>


function renderPie() {
	
	let canvasPie = document.getElementById('pie').getContext('2d');
	let studentsCount="<%=studentsCount%>"; 
	let studentswithoutRecord="<%=studentswithoutRecord%>";
	let data = {
	    datasets: [{
	        data: [studentsCount, studentswithoutRecord],
            backgroundColor: [
                'rgba(255, 99, 132, 0.9)',
                'rgba(54, 162, 235, 0.9)'

            ],
	    }],

	    labels: [
	        'Alumnos que realizaron la encuesta',
	        'Alumnos que aún no realizan la encuesta',
	    ]
	};
	

	
	let myPieChart = new Chart(canvasPie, {
	    type: 'pie',
	    data: data,
	    options: {
	        title: {
	            display: true,
	            text: 'Total de encuestas realizadas'
	        }
	    }
	
	});
	
}



function renderBar() {

   
	let densityCanvas = document.getElementById("densityChart");

	Chart.defaults.global.defaultFontFamily = "Lato";
	Chart.defaults.global.defaultFontSize = 18;

	let densityData = {
	  label: 'Preguntas mejor rankeadas (votos)',
	  data: sum,
	  backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
	};

	let barChart = new Chart(densityCanvas, {
	  type: 'horizontalBar',
	  data: {
	    labels: labels,
	    datasets: [densityData]
	  }
	});
	
	
}

	
	console.log("sum",sum);
	console.log("labels",labels);
	
renderPie();

renderBar();
	
</script>
</body>
</html>