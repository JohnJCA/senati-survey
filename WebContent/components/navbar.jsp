<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-expand-lg fixed-top navbar-light bg-light">
   <a class="navbar-brand" href="#">
    <img src="src/img/senati_logo_small.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
    SENATI
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#"><div>Hola, ${sessionScope.user.getFirstName()}  ${sessionScope.user.getSecondName()}</div> <span class="sr-only">(current)</span></a>
      </li>
    </ul>
     <ul style="cursor:pointer" class="nav navbar-nav navbar-right">
     <form action="Logout" method="get">
     	<input type="submit" class="logoutButton" value="Cerrar sesión">
     	</input>
     	
     </form>
      
    </ul>

  </div>
</nav>