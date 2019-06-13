package beans;

public class SurveyDetail {

	private int idSurveyRecord;
	private int idQuestion;
	private int idResponse;
	
	
	public int getIdSurveyRecord() {
		return idSurveyRecord;
	}
	public void setIdSurveyRecord(int idSurveyRecord) {
		this.idSurveyRecord = idSurveyRecord;
	}
	
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	public SurveyDetail(int idSurveyRecord, int idQuestion, int idResponse) {
		super();
		this.idSurveyRecord = idSurveyRecord;
		this.idQuestion = idQuestion;
		this.idResponse = idResponse;
	}
	public int getIdResponse() {
		return idResponse;
	}
	public void setIdResponse(int idResponse) {
		this.idResponse = idResponse;
	}
}
