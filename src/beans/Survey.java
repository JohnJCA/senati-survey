package beans;

import java.sql.Timestamp;

public class Survey {
	
	private int id;
	private String name;
	private String description;
	private int timeLimit;
	private Timestamp startDate;
	private Timestamp endDate;
	private int createdBy;
	
	public Survey() {
		// TODO Auto-generated constructor stub
	}
	
	public Survey(String name, String description, int timeLimit, Timestamp startDate,Timestamp endDate, int createdBy) {
		super();
		this.name = name;
		this.description = description;
		this.timeLimit = timeLimit;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
	}
	
		
	public Survey(int id, String name, String description, int timeLimit, Timestamp startDate, Timestamp endDate, int createdBy) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.timeLimit = timeLimit;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	
}
