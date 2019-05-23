package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.PostGreSQLConnection;
import beans.QuestionsBySurvey;
import beans.User;

public class DQuestionsBySurvey {

    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
	public static void addQuestionsBySurvey(QuestionsBySurvey obj) throws SQLException, Exception {
		try {
	
	        con=PostGreSQLConnection.getConexion();
	        ps=con.prepareStatement("select * from fn_addquestioninsurvey(?, ?)");
	        ps.setInt(1, obj.getIdSurvey());
	        ps.setInt(2, obj.getIdQuestion());
	        ps.executeQuery();
	        
		} catch (SQLException e) {
			System.out.println("error de sql get credentials: "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		System.out.println("rs,");
        
        try {
        	ps=con.prepareStatement("select * from getSurveyById(42) as (aa int, bb int, cc varchar, dd int, ee varchar) ");
			
			rs=ps.executeQuery();
            while(rs.next()){

            	System.out.println("rs.getString(3),"+rs.getString(3));
          
            }
		} catch (SQLException e) {
			System.out.println("e"+e);
			e.printStackTrace();
		}
        
        
        
	}
}
