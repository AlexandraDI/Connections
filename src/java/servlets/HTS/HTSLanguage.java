/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.HTS;

import dao.definitions.UserDAO;
import dao.UserDAOImpl;
import dao.definitions.AdministratorDAO;
import dao.AdministratorDAOImpl;
import dao.definitions.InterestDAO;
import dao.InterestDAOImpl;
import dao.UserHasLanguageDAOImpl;
import dao.definitions.UserHasLanguageDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.Administrator;
import model.Interest;

/**
 *
 * @author alex
 */
@WebServlet(name = "HTSLanguage", urlPatterns = {"/language"})
public class HTSLanguage extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()) {
            // add prefix
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            
            //***************************************************
            //---------------------------------------------------
            //-----------------------USER------------------------
            //---------------------------------------------------
            
            
            out.println("<p>Test1</p>");
            

            UserHasLanguageDAOImpl dao = new UserHasLanguageDAOImpl();
            
            out.println("<p>Test2</p>");
            
            
            try {
                dao.create(59,1);
                out.println("<p>Language created (correct)</p>");
            } catch (Exception ex) {
                out.println("<p>Language not created (error)</p>");
            }     
            
            
            if( dao.remove(52,1)){
                out.println("<p>Language removed (correct)</p>");
            }else{
                out.println("<p>Language not removed (error)</p>");
            }            
            
          
            
            
            
            out.println("<p>Test3</p>");
            
        }
        
        
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

}
