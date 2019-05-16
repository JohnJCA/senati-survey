/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author
 */
public interface IDao<T> {
    String add(T obj) throws SQLException,Exception;
    String update(T obj) throws SQLException, Exception;
    String delete(Object cod) throws SQLException,Exception;
    List<T> search(Object cod) throws SQLException,Exception;
    T getItem(int f) throws SQLException,Exception;
    
    
    
}
