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
    public abstract void openConnection(String driverClassName, String url, String username, String password) throws IllegalArgumentException, ClassNotFoundException, SQLException;
    public abstract List<Map<String,Object>> findRecordsFor(String tableName, int maxRecords) throws SQLException;
    public abstract List<Map<String,Object>> findAll(String tableName) throws SQLException;
    public abstract List findRecords(String sqlString) throws SQLException, Exception;
    public abstract Map getRecordByID(String table, String primaryKeyField, Object keyValue) throws SQLException, Exception;
    public abstract boolean insertRecord(String tableName, List<String> columnNames, List columnValues) throws SQLException, Exception;
    public int updateRecords(String tableName, List<String> columnNames, List columnValues, String whereField, Object whereValue) throws SQLException, Exception;
    public abstract int deleteRecords(String tableName, String whereField, Object whereValue) throws SQLException, Exception;
    
}
