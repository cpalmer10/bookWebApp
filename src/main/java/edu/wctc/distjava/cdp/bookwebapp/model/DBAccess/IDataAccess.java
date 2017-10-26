/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.cdp.bookwebapp.model.DBAccess;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris.roller
 */
public interface IDataAccess {

    public abstract void openConnection() throws SQLException, ClassNotFoundException;
    public abstract void closeConnection() throws SQLException;
    public abstract List<Map<String, Object>> getAllRecords(String tableName, int maxRecords) throws SQLException, ClassNotFoundException;   
    public abstract Map<String,Object> getRecordById(String tableName, String columnName, int id) throws SQLException, ClassNotFoundException;  
    public abstract int deleteRecordById(String tableName, String columnName, Object id)throws SQLException, ClassNotFoundException;    
    public abstract int updateRecord(String tableName, ArrayList<String> columnNames, ArrayList<Object> values, String identifierColumnName, Object identifierValue )throws SQLException, ClassNotFoundException;    
    public abstract void insertNewRecord(String tableName, ArrayList<String> columnNames, ArrayList<Object> values) throws SQLException, ClassNotFoundException;
    
    public abstract String getDriverClass();
    public abstract String getPassword();
    public abstract String getUrl();
    public abstract String getUserName();
    public abstract void setDriverClass(String driverClass);
    public abstract void setPassword(String password);
    public abstract void setUrl(String url);
    public abstract void setUserName(String userName);
    
}
