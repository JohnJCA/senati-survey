package beans;

public class QuestionsBySurvey {

	private int idSurvey;
	private int idQuestion;
	private String question;
	private int idCategory;
	private String category;
	
	public QuestionsBySurvey(int idSurvey, int idQuestion) {
		super();
		this.idSurvey = idSurvey;
		this.idQuestion = idQuestion;
	}

	public QuestionsBySurvey(int idSurvey, int idQuestion, String question, int idCategory, String category) {
		super();
		this.idSurvey = idSurvey;
		this.idQuestion = idQuestion;
		this.question = question;
		this.idCategory = idCategory;
		this.category = category;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	// qs.idSurvey as idEncuesta, q.id  as idPregunta, q.name as Pregunta, ca.id as CategoriaId , ca.name as Categoria 
	

	
	
}
