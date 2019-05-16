package beans;

public class Survey {
	
	private int id;
	private String name;
	private String description;
	private String timeLimit;
	private String startDate;
	private String endDate;
	private String createdBy;
	
	public Survey() {
		// TODO Auto-generated constructor stub
	}
	
		
	public Survey(int id, String name, String description, String timeLimit, String startDate, String endDate, String createdBy) {
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
	
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
