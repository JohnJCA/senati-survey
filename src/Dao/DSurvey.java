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
import beans.Survey;

public class DSurvey implements IDao<Survey> {
	
	
    private static List<Survey> surveyArray=null;
    private static Connection con;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;
    
    public List<Survey> getSurveys(boolean getOnlyActiveSurveys) {
    	System.out.println("getOnlyActiveSurveys: "+ getOnlyActiveSurveys);
    	try {
    		surveyArray = new ArrayList<>();
            con=PostGreSQLConnection.getConexion();
            
            ps=con.prepareStatement("select * from fn_getsurveys(?)");

            ps.setBoolean(1, getOnlyActiveSurveys);
            rs=ps.executeQuery();
            while(rs.next()){

            	surveyArray.add(new Survey(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7))
                );
      
            }
            
		} catch (SQLException e) {
			System.out.println("error de sql get credentials: "+e.getMessage());
		}
    	return surveyArray;

    }

	
	
	@Override
	public String add(Survey obj) throws SQLException, Exception {
			
    	try {
            con=PostGreSQLConnection.getConexion();
            cs=con.prepareCall("{ ? = call fn_addsurvey(?,?,?,?,?,?) }");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(1, obj.getName());
            cs.setString(2, obj.getDescription());
            cs.setString(3, obj.getTimeLimit());
            cs.setString(4, obj.getStartDate());
            cs.setString(5, obj.getEndDate());
            cs.setString(6, obj.getCreatedBy());
            cs.execute();
            int result = cs.getInt(1);
            System.out.println("result: "+result);

		} catch (SQLException e) {
			System.out.println("error de sql add survey: "+e.getMessage());
		}
		return null;
	}

	@Override
	public String update(Survey obj) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Object cod) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Survey> search(Object cod) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Survey getItem(int f) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
