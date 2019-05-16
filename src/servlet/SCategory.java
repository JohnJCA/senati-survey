package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.DCategory;
import beans.Category;
import utility.Utility;

/**
 * Servlet implementation class SCategory
 */
@WebServlet("/SCategory")
public class SCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
  		DCategory dc=new DCategory();
  		List<Category> listCategory = dc.getCategorys();
	    String json = new Gson().toJson(listCategory);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= Utility.getStringParameter("categoryName", request);
		String description= Utility.getStringParameter("categoryDescription", request);
		System.out.println("description: "+description);
		System.out.println("name: "+name);
		if(name != null && description != null) {
			Category category = new Category(name,description);
			DCategory dcategory = new DCategory();
			try {
				dcategory.add(category);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
	}

}
