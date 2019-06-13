package servlet;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DSurveyDetail;
import Dao.DSurveyRecord;
import beans.SurveyDetail;
import beans.SurveyRecord;
import utility.Utility;

/**
 * Servlet implementation class SSurveyRecord
 */
@WebServlet("/SSurveyRecord")
public class SSurveyRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSurveyRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DSurveyRecord dSurveyRecord = new DSurveyRecord();
		SurveyRecord surveyRecord = new SurveyRecord();
		DSurveyDetail dSurveyDetail = new DSurveyDetail();

		
		
		int iduser = Integer.parseInt(request.getParameter("iduser"));
    	int idsurvey = Integer.parseInt(request.getParameter("idsurvey"));
		Timestamp startAt = Timestamp.valueOf( request.getParameter("startAt") );
		Timestamp endAt = Timestamp.valueOf( request.getParameter("endAt") );
		Time totaltime = Time.valueOf( request.getParameter("totaltime") );
		
		surveyRecord.setIdUser(iduser);
		surveyRecord.setIdSurvey(idsurvey);
		surveyRecord.setStartAt(startAt);
		surveyRecord.setEndAt(endAt);
		surveyRecord.setTotalTime(totaltime);
		
		
		try {
			int idSurveyRecord = Integer.parseInt(dSurveyRecord.add(surveyRecord));
			

			Enumeration enParams = request.getParameterNames(); 
			while(enParams.hasMoreElements()){
			 String paramName = (String)enParams.nextElement();
			 
             if(paramName.toLowerCase().contains("question".toLowerCase())) {
             	
             	int idQuestion = Integer.parseInt(paramName.replace("question-", ""));
             	int idResponse = Integer.parseInt(request.getParameter(paramName));
             	dSurveyDetail.add(new SurveyDetail(idSurveyRecord, idQuestion, idResponse));

             }
			 
			 
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("menu.jsp").forward(request, response);
		
	}

}
