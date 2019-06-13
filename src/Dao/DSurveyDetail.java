package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import bd.PostGreSQLConnection;
import beans.Survey;
import beans.SurveyDetail;

public class DSurveyDetail implements IDao<SurveyDetail> {
	
    private static List<SurveyDetail> surveyArray=null;
    private static Connection con;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;

	@Override
	public String add(SurveyDetail obj) throws SQLException, Exception {
		
    	try {
            con=PostGreSQLConnection.getConexion();
            CallableStatement cs = con.prepareCall("{ call fn_addsurvey_detail( ?,?,? ) }");
            cs.setInt(1, obj.getIdSurveyRecord());
            cs.setInt(2, obj.getIdQuestion());
            cs.setInt(3, obj.getIdResponse());
            cs.execute();
            cs.close();
		} catch (SQLException e) {
			System.out.println("error de sql fn_addsurvey_detail: "+e.getMessage());
		}
		return null;
		
	
	}

	@Override
	public String update(SurveyDetail obj) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Object cod) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveyDetail> search(Object cod) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SurveyDetail getItem(int f) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
