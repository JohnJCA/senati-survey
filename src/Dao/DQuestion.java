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
import beans.Question;

public class DQuestion implements IDao<Question> {
	
    private static Connection con;

	@Override
	public String add(Question obj) throws SQLException, Exception {
    	try {
            con=PostGreSQLConnection.getConexion();
            CallableStatement cs = con.prepareCall("{? = call fn_addquestion( ?,? ) }");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, obj.getName());
            cs.setInt(3, obj.getIdCategory());
            cs.execute();
            String newId = Integer.toString(cs.getInt(1));
            cs.close();
            return newId;
            
		} catch (SQLException e) {
			System.out.println("error de sql add question: "+e.getMessage());
		}
		return null;
	}
	
	public List<Integer> addQuestions(String[] array, int id) throws SQLException, Exception {
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < array.length; i++) {
			  Question q = new Question(array[i], id);
			  String newId = this.add(q);
			  list.add( Integer.parseInt(newId));
		}
		return list;
	}

	@Override
	public String update(Question obj) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Object cod) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> search(Object cod) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question getItem(int f) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
