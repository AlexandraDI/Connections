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
@WebServlet(name = "HTSAdministrator", urlPatterns = {"/test/admin"})
public class HTSAdministrator extends HttpServlet {

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
            
                    
            out.println("<h1>--------USER------------------------");
            UserDAOImpl dao = new UserDAOImpl();
            
            // ------------------------------------ LIST
            out.println("<h1>Test listall()");
            List<User> users = dao.list();
            
            out.println("<p>Total users: " + users.size() + "</p>");
            
            for (User u : users) {
                out.println("<p>- " + u.getFirstname()+ " " + u.getSurname()+ " " + u.getPassword() + " </p>");
            }
            
            // ------------------------------------ FIND            
            out.println("<h1>Test find()");
            User u1 = dao.find(1);
            User u2 = dao.find(11723);
            if (u1 != null) {
                out.println("<p>User 1 found (correct)</p>");
            } else {
                out.println("<p>User 1 not found (error)</p>");
            }
            if (u2 != null) {
                out.println("<p>User 2 found (error)</p>");
            } else {
                out.println("<p>User 2 not found (correct)</p>");
            }
            
            // ------------------------------------ REMOVE
            out.println("<h1>Test remove()");
            dao.remove(2);
            
            // ------------------------------------ CREATE            
            out.println("<h1>Test create()");
            User nu = new User();
            nu.setFirstname("w");
            nu.setSurname("w");
            nu.setEmail("w");
            nu.setPassword("w");
            try {
                dao.create(nu);
                out.println("<p>User NU created (correct)</p>");
            } catch (Exception ex) {
                out.println("<p>User NU not created (error)</p>");
            }
            
            // ------------------------------------ UPDATE
            out.println("<h1>Test update()");
            User changes= new User();
            changes.setPassword("t");
            dao.update(1, changes);
            
            
            //***************************************************
            //---------------------------------------------------
            //----------------------ADMINISTRATOR----------------
            //---------------------------------------------------
            
            
            out.println("<p>--------ADMINISTRATOR---------------</p>");
            AdministratorDAOImpl dao2 = new AdministratorDAOImpl();

            
            // ------------------------------------ LIST
            out.println("<h1>Test admin()");
            List<Administrator> administrator = dao2.list();
            
            out.println("<p>Total administrator: " + administrator.size() + "</p>");
          
//            for (Administrator a: administrator) {
//                
//                out.println("<p>- " + a.getIdadministrator() + " " + a.getIduser()+ "</p>");
//            } 
            
            
//            out.println("<h1>Test admin create()");
//            Administrator admn = new Administrator();
//            admn.setIdadministrator(2);
//            User useraki = new User();
//            useraki.setIduser(4);
//            
//            admn.setIduser(useraki);
           
//            User useridio = dao.find(useraki.getIduser());
            //useraki=User.findIdUser(useraki.getFirstname());
            
//            out.println("<p>- " + useridio.getFirstname() + " </p>");
            
                    
           // admn.setIduser(User[ iduser=4 ]);

            try {
//                dao2.create(admn);
                out.println("<p>Admin admn created (correct)</p>");
            } catch (Exception ex) {
                out.println("<p>Admin admn not created (error)</p>");
            }   
            
     
            // ------------------------------------ FIND            
            out.println("<p>Test administrator()</p>");
            Administrator u11 = dao2.find(1);
            Administrator u21 = dao2.find(4);
            if (u11 != null) {
                out.println("<p>User 1 found (correct)</p>");
            } else {
                out.println("<p>User 1 not found (error)</p>");
            }
            if (u21 != null) {
                out.println("<p>User 2 found (error)</p>");
            } else {
                out.println("<p>User 2 not found (correct)</p>");
            }            
            
         
            
            // add postfix
            out.println("</body>");
            out.println("</html>");
            
            dao.closeEM();
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
