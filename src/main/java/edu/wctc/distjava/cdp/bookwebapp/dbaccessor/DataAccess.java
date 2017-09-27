/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.cdp.bookwebapp.dbaccessor;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Chris
 */
public interface DataAccess {

    public abstract void closeConnection() throws SQLException;
    public abstract List<Map<String, Object>> findAll(String tableName, int maxRecords) throws ClassNotFoundException, SQLException;
    public abstract String getDriverClass();
    public abstract String getPassword();
    public abstract String getUrl();
    public abstract String getUserName();
    public abstract void openConnection() throws ClassNotFoundException, SQLException;
    public abstract void setDriverClass(String driverClass);
    public abstract void setPassword(String password);
    public abstract void setUrl(String url);
    public abstract void setUserName(String userName);
    
}
