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
import dao.UserFollowsUserDAOImpl;
import dao.definitions.UserFollowsUserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.Administrator;
import model.Interest;
import model.UserFollowsUser;
import jpautils.EntityManagerHelper;
import javax.persistence.EntityTransaction;

/**
 *
 * @author alex
 */






@WebServlet(name = "HTSUserFollowsUser", urlPatterns = {"/follow"})
public class HTSUserFollowsUser extends HttpServlet {

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
            

            UserFollowsUserDAOImpl dao = new UserFollowsUserDAOImpl();
            
            out.println("<p>Test2</p>");
            
            //UserDAOImpl dao = new UserDAOImpl();
            
            // ------------------------------------ LIST
            
            
   // public List<User> findFollowers(Integer userId) {
        /*List<User> users;
        int userId=1;
        User u= new User();
        u.setUserId(userId);
        User who = u.find(User.class, userId);
        if (who != null) {
            List<UserFollowsUser> pairs = who.getUserFollowsUserList1();
             users = new ArrayList<>();

            for (UserFollowsUser pair : pairs) {
                User other = em.find(User.class, pair.getUser());
                if (other != null) {
                    users.add(other);
                }
            }
            //return users;
        } else {
            //return null;
            users=null;
        }*/
   // }            
            
            
            
            
            
            
            
            
            
            int userId=1;
            out.println("<h1>Test listall()");
            List<UserFollowsUser> users = dao.find(userId);
            

            out.println("<p>Total users: " + users.size() + "</p>");

            
            //out.println("<p>- " + users.get(1)+ " " + " </p>");
            
            out.println("<p>Test2aa</p>");
            
            
            for (UserFollowsUser u : users) {
               
                out.println("<p>- " + u.getUser1().getUserId()+ " " + " </p>");
            }    
            
            out.println("<h1>Test listall2()");
            List<UserFollowsUser> moreusers;
            moreusers = dao.find2(userId);
            

            out.println("<p>Total moreusers: " + moreusers.size() + "</p>");            
            
            
            for (UserFollowsUser u : moreusers) {
               
                out.println("<p>- " + u.getUser().getUserId()+ " " + " </p>");
            }            
            
             out.println("<p>Test2a</p>");
            
            
            if(dao.startFollowing(3,1)){
                out.println("<p>UserFollowsUser created (correct)</p>");
            } else{
                out.println("<p>UserFollowsUser not created (error)</p>");
            }     
            
            
            /*
            if( dao.remove(52,1)){
                out.println("<p>Language removed (correct)</p>");
            }else{
                out.println("<p>Language not removed (error)</p>");
            } 
            */
            
          
            
            
            
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
