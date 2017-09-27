package edu.wctc.distjava.cdp.bookwebapp.dbaccessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MySqlDataAccess implements DataAccess {
    private final int ALL_RECORDS = 0;
    
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private String driverClass;
    private String url;
    private String userName;
    private String password;
    
    public MySqlDataAccess(String driverClass, String url, String userName, String password) {
        setDriverClass(driverClass);
        setUrl(url);
        setUserName(userName);
        setPassword(password);
    }
 
    @Override
    public final void openConnection() throws ClassNotFoundException, SQLException{
        Class.forName (driverClass);
        conn = DriverManager.getConnection(url, userName, password);
    }
    
    @Override
    public final void closeConnection() throws SQLException {
        if(conn !=null) conn.close();
    }
   
    /**
     * 
     * @param tableName
     * @param maxRecords
     * @return
     * @throws SQLException 
     * @throws java.lang.ClassNotFoundException 
     */
    @Override
    public List<Map<String,Object>> findAll(String tableName, int maxRecords) throws ClassNotFoundException, SQLException  {
        List<Map<String,Object>> rawData = new Vector<>(); // new ArrayList<>()
        String sql = "";
        
        if(maxRecords > ALL_RECORDS) {
            sql = "Select * from " + tableName + " limit " + maxRecords;
        } else {
            sql = "Select * from " + tableName;
        }
        
        openConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
                
        rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        
        while(rs.next()){
            Map<String,Object> record = new LinkedHashMap<>();
            for(int colNum=1; colNum < colCount + 1; colNum++){
                String columnName = rsmd.getColumnName(colNum);
                Object columnData = rs.getObject(columnName);
                record.put(columnName, columnData);                              
            }
            rawData.add(record);
        }
        closeConnection();
        return rawData;                        
    }
    

    // GETTERS AND SETTERS
    @Override
    public final String getDriverClass() {
        return driverClass;
    }

    @Override
    public final void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    @Override
    public final String getUrl() {
        return url;
    }

    @Override
    public final void setUrl(String url) {
        this.url = url;
    }

    @Override
    public final String getUserName() {
        return userName;
    }

    @Override
    public final void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public final String getPassword() {
        return password;
    }

    @Override
    public final void setPassword(String password) {
        this.password = password;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DataAccess db = new MySqlDataAccess("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/book", "root", "admin");                
        
        db.openConnection();
        List<Map<String,Object>> records = db.findAll("author", 0);
        db.closeConnection();
        
        for(Map<String,Object> record : records) {
            System.out.println(record);
        }
    }
    
    
        
    
    
     
    
    
}