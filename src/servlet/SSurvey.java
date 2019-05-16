package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DCategory;
import beans.Category;
import utility.Utility;

/**
 * Servlet implementation class SSurvey
 */
@WebServlet("/SSurvey")
public class SSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSurvey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> params = request.getParameterNames(); 
		while(params.hasMoreElements()){
		 String paramName = params.nextElement();
		 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
		}
//		String name= Utility.getStringParameter("categoryName", request);
//		String description= Utility.getStringParameter("categoryDescription", request);
//		System.out.println("description: "+description);
//		System.out.println("name: "+name);
//		if(name != null && description != null) {
//			Category category = new Category(name,description);
//			DCategory dcategory = new DCategory();
//			try {
//				dcategory.add(category);
//				request.getRequestDispatcher("menu.jsp");
//			} catch (Exception e) {
//			
//				e.printStackTrace();
//			}
//		}

	}
	


}
