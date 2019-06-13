package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;

import Dao.DCategory;
import Dao.DQuestion;
import Dao.DQuestionsBySurvey;
import Dao.DSurvey;
import beans.Category;
import beans.Question;
import beans.QuestionsBySurvey;
import beans.Section;
import beans.Survey;
import beans.SurveyResponse;
import utility.Utility;

/**
 * Servlet implementation class SSurvey
 */
@WebServlet("/SSurvey")
public class SSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DSurvey dsurvey = new DSurvey();
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
		request.setCharacterEncoding("UTF-8");
		String id = Utility.getStringParameter("id", request);
		String isTutor = Utility.getStringParameter("isTutor", request);
		String surveyName = Utility.getStringParameter("surveyName", request);
		String time = Utility.getStringParameter("time", request);
		
		DQuestionsBySurvey dQuestionsBySurvey = new DQuestionsBySurvey();
		
		// records de base de datos
		List<QuestionsBySurvey> result = dQuestionsBySurvey.getSurvey(Integer.parseInt(id));
		
		int actualCategoryId = -1;
		List<SurveyResponse> surveyResponses = new ArrayList<>();
		
		for (int i = 0; i < result.size(); i++) {
			
			if(result.get(i).getIdCategory() != actualCategoryId) {
				actualCategoryId = result.get(i).getIdCategory();
				String actualCategory = result.get(i).getCategory();
				surveyResponses.add(new SurveyResponse(actualCategoryId,actualCategory));
			}
			
		}

		for (int i = 0; i < surveyResponses.size(); i++) {
			
			List<Question> questionList = new ArrayList<>();
			int idCategory = surveyResponses.get(i).getIdCategory();
			
			for (int j = 0; j < result.size(); j++) {
				
				QuestionsBySurvey row = result.get(j);
				Question question= new Question();

				if(idCategory == row.getIdCategory()) {
					
					question.setId(row.getIdQuestion());
					question.setName(row.getQuestion());
					questionList.add(question);
				}
				
			}
			surveyResponses.get(i).setQuestions(questionList);

		}
		
		request.setAttribute("surveyResponses", surveyResponses );
		request.setAttribute("id", id );
		request.setAttribute("isTutor", isTutor );
		request.setAttribute("surveyName", surveyName );
		request.setAttribute("time", time );
		
		
		
		//surveyGraphics.jsp
		
		if(Boolean.parseBoolean(isTutor) == false) {
			request.getRequestDispatcher("surveyGraphics.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("newSurvey.jsp").forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int createdBy = Integer.parseInt(request.getParameter("createdBy"));
		String name = Utility.getStringParameter("surveyName", request);
		String description = Utility.getStringParameter("surveyDescription", request);
		Timestamp startDate = Timestamp.valueOf( request.getParameter("startDate") );
		Timestamp endDate = Timestamp.valueOf( request.getParameter("endDate") );
		int timeLimit = Integer.parseInt(request.getParameter("maxTime"));
		String sections = request.getParameter("sections");
		
		Survey survey = new Survey(name, description, timeLimit, startDate, endDate, createdBy);
		
		int surveyId;

		try {
			
			String idSurvey = dsurvey.add(survey);
			surveyId =	Integer.parseInt(idSurvey);
			List<Section>sectionArray = Utility.jsonStringToArray(sections);
			DQuestion dquestion = new DQuestion();
			
			for (int i = 0; i < sectionArray.size() ; i++) {
				int idCategory = sectionArray.get(i).getIdCategory();
				String[] questions = sectionArray.get(i).getQuestions();
				List<Integer> questionIds = dquestion.addQuestions(questions, idCategory);
				for (int j = 0; j < questionIds.size(); j++) {
					QuestionsBySurvey qbs = new QuestionsBySurvey(surveyId, questionIds.get(j));
					DQuestionsBySurvey.addQuestionsBySurvey(qbs);
				}
				  
			}
			
			request.getRequestDispatcher("survey.jsp").forward(request, response);
			
		} catch (Exception e) {

			e.printStackTrace();
		}



	}
	


}
