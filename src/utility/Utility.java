package utility;

import javax.servlet.http.HttpServletRequest;

public class Utility {
	
	
	public static String getStringParameter(String parameter,HttpServletRequest request) {
		return (String)request.getParameter(parameter);
		
	}

}
