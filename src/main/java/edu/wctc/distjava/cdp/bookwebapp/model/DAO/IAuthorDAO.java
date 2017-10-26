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

    public abstract Author getAuthorById(int id) throws SQLException, ClassNotFoundException;
    public abstract List<Author> getListOfAuthors() throws SQLException, ClassNotFoundException;    
    public abstract int deleteAuthorById(Integer id) throws SQLException, ClassNotFoundException;    
    public abstract int updateAuthorById(Map<String,Object> author) throws SQLException, ClassNotFoundException;   
    public abstract void addNewAuthor(Map<String,Object> author) throws SQLException, ClassNotFoundException;
   
    public abstract String getPassword();
    public abstract String getUrl();
    public abstract String getUserName();
    public abstract void setDb(IDataAccess db);
    public abstract void setDriverClass(String driverClass);
    public abstract void setPassword(String password);
    public abstract void setUrl(String url);
    public abstract void setUserName(String userName);
    public abstract IDataAccess getDb();
    public abstract String getDriverClass();

    
}
