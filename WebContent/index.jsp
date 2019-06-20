<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="icon" href="http://www.senati.edu.pe/sites/all/themes/senati_theme/favicon/favicon.ico">
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
    <link href="src/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="main.css">
  </head>
  <body class="login-body" onload="showModal()">
	<a style="visibility: hidden; pointer-events: none" id="modal-125442" href="#modal-container-125442" role="button" class="btn" data-toggle="modal" data-backdrop="static" data-keyboard="false">Launch demo modal</a>
	
	<div class="modal fade modal-container-flex" id="modal-container-125442" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog login-width" role="document">
			<div class="modal-content">
				<form method="post" action="SUser" autocomplete="off" >
				<div class="modal-header">
					<img style="width:300px; margin:auto"src="src/img/senati_logo.png"></img> 
				</div>
				<div class="modal-body">
					
					  <div class="form-group">
					    <label for="exampleInputEmail1">Usuario</label>
					    <input type="text" class="form-control" name="username" placeholder="Ingrese usuario" required>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Contraseña</label>
					    <input type="password" class="form-control" name="password" placeholder="Ingrese contraseña" required>
					  </div>
					
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success" value="login">Ingresar</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		function showModal() {
			document.getElementById("modal-125442").click();
		}
		
	</script>
    <script src="src/js/jquery.min.js"></script>
    <script src="src/js/bootstrap.min.js"></script>
    <script src="src/js/scripts.js"></script>
  </body>
</html>