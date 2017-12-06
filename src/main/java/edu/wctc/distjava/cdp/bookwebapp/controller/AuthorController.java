/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.cdp.bookwebapp.controller;

import edu.wctc.distjava.cdp.bookwebapp.entity.Author;
import edu.wctc.distjava.cdp.bookwebapp.service.AuthorService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AuthorController", urlPatterns = {"/authorController"})
public class AuthorController extends HttpServlet {
    
    private static String RESULT_PAGE = "/index.jsp";
    private static final String AUTHOR_LIST_PAGE = "/authorList.jsp";
    private static final String ERROR_PAGE = "/error.jsp";
    private static final String LIST_ACTION = "authorList";
    private static final String EDIT = "edit";
    private static final String DELETE = "delete";
    private static final String ACTION = "action";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String DELETION = "deletionMessage";
    private static final String DELETION_MESSAGE = "Record successfully deleted";
    private static final String ADD = "add";
    private static final String AUTHORS = "authors";
    private static final String AUTHOR_NAME = "author_name";
    private static final String AUTHOR_ID = "author_id";
    private static final String AUTHOR_DATE = "author_date";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            String action = request.getParameter(ACTION);
            if(action.equalsIgnoreCase(LIST_ACTION)){
                getAuthorListPage(request,response, as);
            }else if(action.equalsIgnoreCase(EDIT)){
                updateAuthor(request,response, as);
            }else if(action.equalsIgnoreCase(DELETE)){
                deleteAuthor(request,response, as);
            }else if(action.equalsIgnoreCase(ADD)){
                addAuthor(request, response, as);            
            }else{
                RESULT_PAGE = AUTHOR_LIST_PAGE;
                request.setAttribute(AUTHORS, refreshAuthorList(as));
            }
        }catch(ClassNotFoundException | SQLException ex){
            RESULT_PAGE = ERROR_PAGE;
            request.setAttribute(ERROR_MESSAGE, ex.getMessage());
        }
        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**Returns the author list page
     * 
     * @param request
     * @param response 
     */
    private void getAuthorListPage(HttpServletRequest request,HttpServletResponse response, AuthorService as) {
        try{
            RESULT_PAGE = AUTHOR_LIST_PAGE;
            request.setAttribute(AUTHORS, refreshAuthorList(as));
        }catch(ClassNotFoundException | SQLException ex){
            RESULT_PAGE = ERROR_PAGE;
            request.setAttribute(ERROR_MESSAGE, ex.getCause());
        }       
    }
   
    /**update the author
     * 
     * @param request
     * @param response 
     */
    private void updateAuthor(HttpServletRequest request, HttpServletResponse response, AuthorService as) {
        try{            
            String authorName = request.getParameter("updateAuthorName");            
            as.updateById(request.getParameter("author_id"), authorName);
            RESULT_PAGE = AUTHOR_LIST_PAGE;
            request.setAttribute(AUTHORS, refreshAuthorList(as));
        }catch(ClassNotFoundException | NumberFormatException | SQLException ex){
            RESULT_PAGE = ERROR_PAGE;
            request.setAttribute(ERROR_MESSAGE, ex.getCause());
        }
    }
    
    /**Deletes the author by id
     * 
     * @param request
     * @param response 
     */
    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response, AuthorService as){
        try{
            String authorId = request.getParameter("id");
            as.deleteById(authorId);                      
            RESULT_PAGE = AUTHOR_LIST_PAGE;
            request.setAttribute(DELETION , DELETION_MESSAGE);
            request.setAttribute(AUTHORS, refreshAuthorList(as));
        }catch(ClassNotFoundException | NumberFormatException | SQLException ex){
            RESULT_PAGE = ERROR_PAGE;
            request.setAttribute(ERROR_MESSAGE, ex.getCause());
        }
    }
    
    /**Adds a new author
     * 
     * @param request
     * @param response 
     */
    private void addAuthor(HttpServletRequest request, HttpServletResponse response, AuthorService as){
        try{             
            String authorName = request.getParameter("addAuthorName");
            as.add(authorName);
            RESULT_PAGE = AUTHOR_LIST_PAGE;
            request.setAttribute(AUTHORS, refreshAuthorList(as));
        }catch(ClassNotFoundException | SQLException ex){
            RESULT_PAGE = ERROR_PAGE;
           request.setAttribute(ERROR_MESSAGE, ex.getCause()); 
        }
    }
   
    /**Refreshes the author list after CRUD Operations
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    private List<Author> refreshAuthorList(AuthorService as) throws SQLException, ClassNotFoundException{
        return as.findAll();
    }
}
