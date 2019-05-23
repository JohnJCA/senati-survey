package beans;

public class QuestionsBySurvey {

	private int idSurvey;
	private int idQuestion;
	
	public QuestionsBySurvey(int idSurvey, int idQuestion) {
		super();
		this.idSurvey = idSurvey;
		this.idQuestion = idQuestion;
	}
	
	public QuestionsBySurvey() {
		super();
	}

	public int getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	
}
