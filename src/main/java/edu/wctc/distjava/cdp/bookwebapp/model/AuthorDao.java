/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.cdp.bookwebapp.model;

import edu.wctc.distjava.cdp.bookwebapp.dbaccessor.DataAccess;
import edu.wctc.distjava.cdp.bookwebapp.dbaccessor.MySqlDataAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Chris
 */
public class AuthorDao {
    private DataAccess db;
    private String driverClass;
    private String url;
    private String userName;
    private String password;
    
    
    //validate me

    
    public AuthorDao(DataAccess db, String driverClass, String url, String userName, String password){
        setDb(db);
        setDriverClass(driverClass);
        setUrl(url);
        setUserName(userName);
        setPassword(password);       
    }
    
    public List<Author> getListOfAuthors() throws SQLException, ClassNotFoundException{
        List<Author> list = new Vector<>();
        List<Map<String,Object>> rawData = db.findAll("author", 0);
        Author author = null;
        for (Map<String,Object> rec : rawData){
            author = new Author();
            author.setAuthorId(Integer.parseInt(rec.get("author_id").toString()));
            author.setAuthorName(rec.get("author_name").toString());
            author.setDateAdded((Date)rec.get("date_added"));
            
            
        }
        return list;
    }

    
    public List<Author> getAuthorList(String tableName) throws IllegalArgumentException, ClassNotFoundException, SQLException, Exception {
        
        List<Author> authorList = new ArrayList<>();
        db.openConnection();
        
        List<Map<String, Object>> rawData = db.findAll(tableName, 0);
        db.closeConnection();
        for(Map<String, Object> recData : rawData) {
            Author author = new Author();
            Object objAuthorId = recData.get("author_id");
            author.setAuthorId((Integer)recData.get("author_id"));
            Object objName = recData.get("author_name");
            String name = objName != null ? objName.toString() : "";
            author.setAuthorName(name);
            Object objDate = recData.get("date_added");
            Date dateAdded = objDate != null ? (Date)objDate : null;
            author.setDateAdded(dateAdded);            
            authorList.add(author);
        }
        
        
        return authorList;     
    }
    
    public DataAccess getDb() {
        return db;
    }
    
    public void setDb(DataAccess db) {
        this.db = db;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
        AuthorDao dao = new AuthorDao(new MySqlDataAccess(),"com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/book", "root","admin");
        
        List<Author> authors = dao.getAuthorList("author");
        
        for(Author a : authors) {
            System.out.println(a);
        }
    }
    
    
}
