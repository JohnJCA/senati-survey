package beans;


public class SurveyRecord {

	private int id;
	private int idUser;
	private int idSurvey;
	private String startAt;
	private String endAt;
	private String totalTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public int getIdSurvey() {
		return idSurvey;
	}
	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
	}
	
	public String getStartAt() {
		return startAt;
	}
	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}
	
	public String getEndAt() {
		return endAt;
	}
	public void setEndAt(String endAt) {
		this.endAt = endAt;
	}
	
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	
	
}
