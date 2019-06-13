package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bd.PostGreSQLConnection;
import beans.QuestionsBySurvey;
import beans.Survey;
import beans.User;

public class DQuestionsBySurvey {

    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    private static List<QuestionsBySurvey> questionsBySurveyArray=null;
    
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
	
	public List<QuestionsBySurvey> getSurvey(int id) {

        String SQL = "select * from getSurveyById(?) as (idSurvey int, idQuestion int, question varchar, idCategory int, category varchar) order by category ";
        try  {
        	questionsBySurveyArray = new ArrayList<>();
        	con=PostGreSQLConnection.getConexion();
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
 
            while (rs.next()) {
            	
	        	questionsBySurveyArray.add(new QuestionsBySurvey(
	    			 rs.getInt(1),
	    			 rs.getInt(2),
	    			 rs.getString(3),
	    			 rs.getInt(4),
	    			 rs.getString(5))
				);
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
        return questionsBySurveyArray;

	}

}
