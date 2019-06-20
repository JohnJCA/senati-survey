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
	String id = (String) request.getAttribute("id");
	int idAsInt = Integer.parseInt(id);
	int recordsCount = data.getRecordsCount(idAsInt);
	String surveyName = (String) request.getAttribute("surveyName");
	
	List<Diagram>  listdiagrambar =  data.getDiagramBar(idAsInt);

%>


<div  style="margin-top:80px; display: flex; flex-flow: row wrap; justify-content: center;">


<% if( listdiagrambar.size() > 0) {  %>


	<% 
		int studentsCount = data.getStudentsCount();
		System.out.println("recordsCount"+ recordsCount);
		System.out.println("studentsCount"+ studentsCount);
		int studentswithoutRecord = studentsCount - recordsCount;
		String average =  data.getTAverage(idAsInt);
		String fastest =  data.getTFastesUser(idAsInt);
		String lowest =  data.getTLowestUser(idAsInt);
		
	%>
	<script>
		var sum = [];
		var labels = [];
	</script>


      <c:forEach var="row" items="<%=listdiagrambar%>" >
      	<script>
			 labels.push("${row.getQuestionName()}");
			 sum.push("${row.getSuma()}");
		</script>
      		 
      </c:forEach>

      

	<h3 class="text-primary" style="text-align:center;width: 100%">${surveyName} - Analítica </h3><br><br><br><br>
				
		
		<div class="graph" style="width: 80%">
			<canvas id="barHorizontal"></canvas>
		</div>
		

		<div style="width: 500px; height: 300px"> 
			<canvas id="pie"></canvas> 
		</div>
		<div style="width: 60%"> 
			<canvas id="barVertical"></canvas> 
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
		
		<script>
	
	
	function renderPie() {
		
		let canvasPie = document.getElementById('pie').getContext('2d');
		
		let studentsCount="<%=recordsCount%>"; 
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
	
	   
		let densityCanvas = document.getElementById("barHorizontal");
	
		Chart.defaults.global.defaultFontFamily = "Lato";
		Chart.defaults.global.defaultFontSize = 18;
	
		let densityData = {
		  label: 'Preguntas con mas puntos (votos)',
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
	
	function getValues(time) {
		console.log('time',time);
		console.log('xd',typeof(time));
		let splited = time.split(":");
		let hours = parseInt(splited[0]) * 3600;
		let minutes = parseInt(splited[1]) * 60;
		let seconds = parseInt(splited[2]);
		console.log('time',time,'hours+minutes+seconds',hours+minutes+seconds);
		return hours+minutes+seconds;
	}
	
	
	function renderBarVertical() {
	
		let barVertical = document.getElementById("barVertical").getContext("2d");
		let lowest = "<%=lowest%>";
		let average = "<%=average%>";
		let fastest = "<%=fastest%>";
	
		let myChart = new Chart(barVertical, {
		  type: 'line',
		  data: {
		    labels: ["Más lenta", "Promedio", "Más rápida"],
		    datasets: [{
		      label: 'Tiempos de duración de encuesta (segundos)',
		      data: [{
		        
		          y: getValues(lowest)
		        },
		        {
		        
		          y: getValues(average)
		        },
		        {
		      
		          y: getValues(fastest)
		        }
		      ],
		      backgroundColor: [
	
		        'rgba(54, 162, 235, 0.2)',
		      ],
		      borderColor: [
	
		        'rgba(54, 162, 235, 1)',
		      ],
		      borderWidth: 1
		    }]
		  }
		});
	
	}

	
	renderPie();
	
	renderBar();
	renderBarVertical();
	
</script>
      <% } else { %>
	    <div id="img-container" style="display:flex; justify-content:center; width: 80%; margin-top:40px; flex-direction: column;align-items: center; ">
   			<div style="width: 50%;box-shadow: 5px 5px 19px -8px rgba(0,0,0,0.75);">
	    		<img alt="not_found" src="src/img/no_content.png" style="width: 100%;">
   			</div>
    	</div>
      <% } %>
      
      
      
</div>

	



	
</div>
 

</body>
</html>