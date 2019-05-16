package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bd.PostGreSQLConnection;
import beans.Category;
import beans.Survey;

public class DCategory implements IDao<Category> {

	
    private static List<Category> categoryArray =null;
    private static Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<Category> getCategorys() {

    	try {
    		categoryArray = new ArrayList<>();
            con=PostGreSQLConnection.getConexion();
            ps=con.prepareStatement("select * from fn_getcategory()");
            rs=ps.executeQuery();
            while(rs.next()){
            	categoryArray.add(new Category(
            			rs.getInt(1), 
            			rs.getString(2), 
            			rs.getString(3))
    			);
      
            }
            
		} catch (SQLException e) {
			System.out.println("error de sql get category: "+e.getMessage());
		}
    	return categoryArray;

    }

	
	@Override
	public String add(Category obj) throws SQLException, Exception {
    	try {
            con=PostGreSQLConnection.getConexion();
            ps=con.prepareStatement("select * from fn_addcategory(?,?)");
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getDescription());
            rs=ps.executeQuery();

		} catch (SQLException e) {
			System.out.println("error de sql get category: "+e.getMessage());
		}
		return null;
	}

	@Override
	public String update(Category obj) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Object cod) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> search(Object cod) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getItem(int f) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
