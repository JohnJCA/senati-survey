/**
 * 
 */
package beans;

/**
 * @author John
 *
 */
public class User {
	
	private int id;
	private String firstName;
	private String secondName;	
	private String lastName;
	private String secondLastName;
	private String username;
	private String password;
	private String dni;
	private String email;
	private boolean userType;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	public User(int id, String firstName, String secondName, String lastName, String secondLastName, String username,
			String password, String dni, String email, String userType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.username = username;
		this.password = password;
		this.dni = dni;
		this.email = email;
		this.setUserType(userType);
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		
		switch(userType) {
			case "T":
				this.userType = false; break;
			case "S":
				this.userType = true; break;
		}
		
	}

	
	
}
