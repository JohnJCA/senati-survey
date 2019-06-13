package beans;

import java.util.List;

public class SurveyResponse {

	private List<Question> questions;
	private int idCategory;
	private String category;
	
	public List<Question>  getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question>  questions) {
		this.questions = questions;
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
	public SurveyResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public SurveyResponse(int idCategory, String category) {
		super();
		this.idCategory = idCategory;
		this.category = category;
	}
	
	public SurveyResponse(List<Question> questions, int idCategory, String category) {
		super();
		this.questions = questions;
		this.idCategory = idCategory;
		this.category = category;
	}

	
	
}
