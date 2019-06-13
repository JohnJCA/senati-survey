package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import bd.PostGreSQLConnection;
import beans.SurveyRecord;

public class DSurveyRecord  implements IDao<SurveyRecord> {

   
    private static Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
	@Override
	public String add(SurveyRecord obj) throws SQLException, Exception {
		
    	try {
            con=PostGreSQLConnection.getConexion();
            CallableStatement cs = con.prepareCall("{? = call fn_addsurveyrecord(?,?,?,?,?) }");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(2, obj.getIdUser());
            cs.setInt(3, obj.getIdSurvey());
            cs.setTimestamp(4, obj.getStartAt());
            cs.setTimestamp(5, obj.getEndAt());
            cs.setTime(6, obj.getTotalTime());
            cs.execute();

            String newId = Integer.toString(cs.getInt(1));
            cs.close();
            return newId;
		} catch (SQLException e) {
			System.out.println("error de sql add survey: "+e.getMessage());
		}
		return null;

	}

	@Override
	public String update(SurveyRecord obj) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Object cod) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveyRecord> search(Object cod) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SurveyRecord getItem(int f) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
