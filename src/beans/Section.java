package beans;

import java.util.List;

public class Section {
	
	private String[] questions;
	private int idCategory;
	
	public String[] getQuestions() {
		return questions;
	}
	public void setQuestions(String[] questions) {
		this.questions = questions;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	public Section() {
		// TODO Auto-generated constructor stub
	}
	public Section(String[] questions, int idCategory) {
		super();
		this.questions = questions;
		this.idCategory = idCategory;
	}
	
	
	

}
