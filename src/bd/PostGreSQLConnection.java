package bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostGreSQLConnection {
	
	
	public static String url = "jdbc:postgresql://localhost:5432/DBsurvey";
	public static String user = "postgres";
	public static String password = "123";
	public static Connection conexion = null;
	
	public static void connect() {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			
			System.out.println("Error al conectar la base de datos: "+e.getMessage());
		}
		
	}	

	public static Connection getConexion() {
		connect();
		return conexion;
	}
}