/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.cdp.bookwebapp.model.DAO;

import edu.wctc.distjava.cdp.bookwebapp.model.Author;
import edu.wctc.distjava.cdp.bookwebapp.model.DBAccess.IDataAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris.roller
 */
public interface IAuthorDAO {

    Author getAuthorById(int id) throws SQLException, ClassNotFoundException;

    IDataAccess getDb();

    String getDriverClass();

    List<Author> getListOfAuthors() throws SQLException, ClassNotFoundException;
    
    int deleteAuthorById(Integer id) throws SQLException, ClassNotFoundException;
    
    int updateAuthorById(Map<String,Object> author) throws SQLException, ClassNotFoundException;
    
    void addNewAuthor(Map<String,Object> author) throws SQLException, ClassNotFoundException;
    
    String getPassword();

    String getUrl();

    String getUserName();

    void setDb(IDataAccess db);

    void setDriverClass(String driverClass);

    void setPassword(String password);

    void setUrl(String url);

    void setUserName(String userName);
    
}
