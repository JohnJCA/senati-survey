package beans;

public class Question {

	private int id;
	private String name;
	private int idCategory;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public Question(int id, String name, int idCategory) {
		super();
		this.id = id;
		this.name = name;
		this.idCategory = idCategory;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Question(String name, int idCategory) {
		super();
		this.name = name;
		this.idCategory = idCategory;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	
	
}
