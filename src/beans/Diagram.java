package beans;

public class Diagram {

	private String questionName;
	private int suma;
	
	public Diagram(String questionName, int suma) {
		super();
		this.questionName = questionName;
		this.suma = suma;
	}

	public Diagram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}
	
}
