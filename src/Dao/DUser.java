package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bd.PostGreSQLConnection;
import beans.Login;
import beans.User;

public class DUser {
	
    private static List<User> userArray=null;
    private static Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<User> getUser(String username, String pasword) {
    	
    	
    	try {
        	userArray = new ArrayList<User>();
            con=PostGreSQLConnection.getConexion();
            if (con != null) {
            	System.out.println("CONECTADO!!");
            }
            
            ps=con.prepareStatement("select * from fn_getcredentials(?,?)");
            ps.setString(1, username );
            ps.setString(2, pasword );
            rs=ps.executeQuery();
            while(rs.next()){
            	System.out.println("name: "+rs.getString(2));
            	userArray.add(new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10))  
                );
          
            }
            
		} catch (SQLException e) {
			System.out.println("error de sql get credentials: "+e.getMessage());
		}
    	if(userArray != null && userArray.size() > 0) {
    		Login login = new Login(userArray.get(0)); 
    	}
    	
    	return userArray;

    }
    

}
