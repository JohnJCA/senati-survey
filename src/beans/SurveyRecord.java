package beans;

import java.sql.Time;
import java.sql.Timestamp;

public class SurveyRecord {

	private int id;
	private int idUser;
	private int idSurvey;
	private Timestamp startAt;
	private Timestamp endAt;
	private Time totalTime;
	
	public SurveyRecord(int id, int idUser, int idSurvey, Timestamp startAt, Timestamp endAt, Time totalTime) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idSurvey = idSurvey;
		this.startAt = startAt;
		this.endAt = endAt;
		this.totalTime = totalTime;
	}
	
	public SurveyRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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
	
	public Timestamp getStartAt() {
		return startAt;
	}
	public void setStartAt(Timestamp startAt) {
		this.startAt = startAt;
	}
	
	public Timestamp getEndAt() {
		return endAt;
	}
	public void setEndAt(Timestamp endAt) {
		this.endAt = endAt;
	}
	
	public Time getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Time totalTime) {
		this.totalTime = totalTime;
	}
	
	
}
