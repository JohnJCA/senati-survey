package beans;

public class Login{
	
	private User user; 
	private boolean isLogged;
    private static Login instance;
    
	public Login(User user) {
		super();
		this.user = user;
		this.isLogged = true;
	}
	
	private Login(){}
    
    public static Login getInstance(){
        if(instance == null){
            instance = new Login();
        }
        return instance;
    }

	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	public void logout() {
		this.user = null;
		this.isLogged = false;
	}
	

	
	
	
	
	
	

}
