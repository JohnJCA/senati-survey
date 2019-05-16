package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DUser;
import beans.User;


/**
 * servlet implementation class SUser
 */
@WebServlet("/SUser")
public class SUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DUser dUser = new DUser();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
        try {
        	
        	User user = dUser.getUser(username, password).get(0);
        	if(user != null) {
        		HttpSession session=request.getSession();  
        		session.setAttribute("user", user );
    			request.setAttribute("user", user );
    			request.setAttribute("userType", user.getUserType() );
    			request.getRequestDispatcher("menu.jsp").forward(request, response);
        	}else {
        		request.getRequestDispatcher("index.jsp");
        	}

		} catch (Exception e) {
			System.out.println("Error do Post login:"+e.getMessage()); 
		}
        
	}

}
