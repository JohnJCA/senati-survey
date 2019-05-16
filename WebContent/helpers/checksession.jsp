<%
	if (request.getAttribute("user") == null) {
	    // Not logged in. Redirect to login page.
	    System.out.println("no estas logeado");
	    session.invalidate();
	    response.sendRedirect("http://www.google.com");
	    return;
	}
%>