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

    void openConnection() throws SQLException, ClassNotFoundException;
    void closeConnection() throws SQLException;

    List<Map<String, Object>> getAllRecords(String tableName, int maxRecords) throws SQLException, ClassNotFoundException;

    Map<String,Object> getRecordById(String tableName, String columnName, int id) throws SQLException, ClassNotFoundException;
    
    int deleteRecordById(String tableName, String columnName, Object id)throws SQLException, ClassNotFoundException;
    
    int updateRecord(String tableName, ArrayList<String> columnNames, ArrayList<Object> values, String identifierColumnName, Object identifierValue )throws SQLException, ClassNotFoundException;
    
    void insertNewRecord(String tableName, ArrayList<String> columnNames, ArrayList<Object> values) throws SQLException, ClassNotFoundException;
    
    String getDriverClass();

    String getPassword();

    String getUrl();

    String getUserName();

    void setDriverClass(String driverClass);

    void setPassword(String password);

    void setUrl(String url);

    void setUserName(String userName);
    
}
