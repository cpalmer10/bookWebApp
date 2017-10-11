/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.cdp.bookwebapp.model;

import edu.wctc.distjava.cdp.bookwebapp.dbaccessor.DataAccess;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface AuthorDaoInterface {

    public abstract List<Author> getAuthorList(String tableName) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception;    
    public abstract void deleteAuthor(Integer authorID) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception;
    public abstract void updateAuthor(String authorName, Integer authorID) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception;
    public abstract void insertAuthor(String name) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception;        
    public abstract DataAccess getDb();
    public abstract String getDriverClass();
    public abstract String getPassword();
    public abstract String getUrl();
    public abstract String getUsername();
    public abstract void setDb(DataAccess db);
    public abstract void setDriverClass(String driverClass);
    public abstract void setPassword(String password);
    public abstract void setUrl(String url);
    public abstract void setUsername(String username);
    
}
