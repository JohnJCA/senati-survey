package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import bd.PostGreSQLConnection;
import beans.Diagram;
import beans.Survey;

public class DData {

    private static Connection con;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;
	
	public int getStudentsCount() throws SQLException, Exception {
		
		try {
	        con=PostGreSQLConnection.getConexion();
	        CallableStatement cs = con.prepareCall("{? = call fn_getstudents() }");
	        cs.registerOutParameter(1, Types.INTEGER);
	        cs.execute();
	        return cs.getInt(1);
		} catch (SQLException e) {
			System.out.println("error de sql fn_getstudents: "+e.getMessage());
		}
		return (Integer) null;
		
	}
	
	
	
	public int getRecordsCount(int surveyId) throws SQLException, Exception {
		
		try {
			
            con=PostGreSQLConnection.getConexion();
            CallableStatement cs = con.prepareCall("{? = call fn_getrecordscount(? ) }");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(2, surveyId);
			
	        cs.execute();
	        return cs.getInt(1);
		} catch (SQLException e) {
			System.out.println("error de sql fn_getrecordscount: "+e.getMessage());
		}
		return 0;
		
	}

    public List<Diagram> getDiagramBar(int surveyId) {
    	List<Diagram> diagramArray = new ArrayList<>();
    	System.out.println("surveyId: "+ surveyId);
    	try {
    		
            con=PostGreSQLConnection.getConexion();
            
            ps=con.prepareStatement("select * from getTopfiveQuestions(?)");

            ps.setInt(1, surveyId);
            rs=ps.executeQuery();
            while(rs.next()){

            	diagramArray.add(new Diagram( rs.getString(1), rs.getInt(2)));
      
            }
            
		} catch (SQLException e) {
			System.out.println("error de sql get credentials: "+e.getMessage());
		}
    	return diagramArray;

    }
    
	public String getTAverage(int surveyId) throws SQLException, Exception {
		String timeString;
		try {
			
            con=PostGreSQLConnection.getConexion();
            CallableStatement cs = con.prepareCall("{? = call getSurveyAvg(? ) }");
            cs.registerOutParameter(1, Types.TIME);
            cs.setInt(2, surveyId);
	        cs.execute();
	        timeString =  cs.getTime(1).toString() ; 
	        return timeString;
		} catch (SQLException e) {
			System.out.println("error de sql fn_getrecordscount: "+e.getMessage());
			timeString = "0";
		}
		return null;
		
	}
	
	public String getTFastesUser(int surveyId) throws SQLException, Exception {
		String timeString;
		try {
	        con=PostGreSQLConnection.getConexion();
	        CallableStatement cs = con.prepareCall("{? = call getFastestUser(?) }");
	        cs.registerOutParameter(1, Types.TIME);
	        cs.setInt(2, surveyId);
	        cs.execute();
	        timeString =  cs.getTime(1).toString() ; 
	        return timeString;
		} catch (SQLException e) {
			System.out.println("error de sql fn_getrecordscount: "+e.getMessage());
			timeString = "00:00:00";
		}
		return null;
		
	}
	
	public String getTLowestUser(int surveyId) throws SQLException, Exception {
		String timeString;
		try {
	        con=PostGreSQLConnection.getConexion();
	        CallableStatement cs = con.prepareCall("{? = call getslowestuser(?) }");
	        cs.registerOutParameter(1, Types.TIME);
	        cs.setInt(2, surveyId);
	        cs.execute();
	        timeString =  cs.getTime(1).toString() ; 
	        return timeString;
		} catch (SQLException e) {
			System.out.println("error de sql fn_getrecordscount: "+e.getMessage());
			timeString = "00:00:00";
		}
		return null;
		
	}
	
    
    

}
